package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.listing.ListingFullDto;
import homework.entity.Listing;
import homework.repository.api.ListingRepository;
import homework.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ListingServiceImpl implements ListingService {

    private final ListingRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<ListingFullDto> findAll() {

        return repository.findAll().stream()
                .map(listing -> mapper.convertToDto(listing, ListingFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ListingFullDto findById(long id) {
        Listing listing = repository.findById(id);

        return mapper.convertToDto(listing, ListingFullDto.class);
    }

    @Override
    public void save(ListingFullDto object) {
        Listing listing = mapper.convertToEntity(object, Listing.class);
        repository.save(listing);
    }

    @Override
    public void update(long id, ListingFullDto updateDTO) {
        Listing listing  = mapper.convertToEntity(updateDTO, Listing.class);
        repository.update(listing);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
