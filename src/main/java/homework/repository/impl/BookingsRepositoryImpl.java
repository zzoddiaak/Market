package homework.repository.impl;

import homework.connect.ConnectionHolder;
import homework.entity.Bookings;
import homework.entity.Listing;
import homework.entity.User;
import homework.repository.api.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookingsRepositoryImpl implements BookingsRepository {

    private final ConnectionHolder connectionHolder;

    // SQL Queries as constants
    private static final String SELECT_ALL_BOOKINGS = "SELECT * FROM bookings";
    private static final String SELECT_BOOKING_BY_ID = "SELECT * FROM bookings WHERE id = ?";
    private static final String INSERT_BOOKING = "INSERT INTO bookings (listing_id, user_id, start_date, end_date, status, created_at) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_BOOKING = "UPDATE bookings SET listing_id = ?, user_id = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?";
    private static final String DELETE_BOOKING_BY_ID = "DELETE FROM bookings WHERE id = ?";

    @Override
    public List<Bookings> findAll() {
        List<Bookings> bookingsList = new ArrayList<>();
        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOKINGS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                bookingsList.add(mapBookings(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookingsList;
    }

    @Override
    public Bookings findById(Long id) {
        Bookings booking = null;
        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BOOKING_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    booking = mapBookings(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booking;
    }

    @Override
    public void save(Bookings booking) {
        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, booking.getListing().get(0).getId());
            statement.setLong(2, booking.getUsers().get(0).getId());
            statement.setObject(3, booking.getStartDate());
            statement.setObject(4, booking.getEndDate());
            statement.setString(5, booking.getStatus());
            statement.setObject(6, booking.getCrearedAt());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    booking.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating booking failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Bookings booking) {
        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING)) {
            statement.setLong(1, booking.getListing().get(0).getId());
            statement.setLong(2, booking.getUsers().get(0).getId());
            statement.setObject(3, booking.getStartDate());
            statement.setObject(4, booking.getEndDate());
            statement.setString(5, booking.getStatus());
            statement.setLong(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection connection = connectionHolder.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOKING_BY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Bookings mapBookings(ResultSet resultSet) throws SQLException {
        Long listingId = resultSet.getLong("listing_id");
        Long userId = resultSet.getLong("user_id");
        String status = resultSet.getString("status");
        LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
        LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
        LocalDate endDate = resultSet.getDate("end_date").toLocalDate();

        Listing listing = loadListing(listingId);
        User user = loadUser(userId);


        return Bookings.builder()
                .listing(List.of(listing))
                .users(List.of(user))
                .status(status)
                .crearedAt(createdAt)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    private Listing loadListing(Long id) throws SQLException {

        return new Listing();
    }

    private User loadUser(Long id) throws SQLException {

        return new User();
    }
}
