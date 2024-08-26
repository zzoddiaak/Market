package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.listing.ListingFullDto;
import homework.entity.Listing;
import homework.repository.api.ListingRepository;
import homework.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {
    private final ListingRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<ListingFullDto> findAll() {
        return repository.findAll().stream()
                .map(listing -> mapperService.convertToDto(listing, ListingFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ListingFullDto findById(long id) {
        Listing listing = repository.findById(id);
        return mapperService.convertToDto(listing, ListingFullDto.class);
    }

    @Override
    public void save(ListingFullDto object) {
        Listing listing = mapperService.convertToEntity(object, Listing.class);
        repository.save(listing);
    }

    @Override
    public void update(long id, ListingFullDto updateDTO) {
        Listing listing = mapperService.convertToEntity(updateDTO, Listing.class);
        repository.update(id, listing);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
