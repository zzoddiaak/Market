package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.listingRequest.ListingRequestFullDto;
import homework.entity.ListingRequest;
import homework.repository.api.ListingRequestRepository;
import homework.service.ListingRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListingRequestServiceImpl implements ListingRequestService {
    private ListingRequestRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<ListingRequestFullDto> findAll() {
        return repository.findAll().stream()
                .map(listingRequest -> mapperService.convertToDto(listingRequest, ListingRequestFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ListingRequestFullDto findById(long id) {
        ListingRequest listingRequest = repository.findById(id);
        return mapperService.convertToDto(listingRequest, ListingRequestFullDto.class);
    }

    @Override
    public void save(ListingRequestFullDto object) {
        ListingRequest listingRequest = mapperService.convertToEntity(object, ListingRequest.class);
        repository.save(listingRequest);
    }

    @Override
    public void update(long id, ListingRequestFullDto updateDTO) {
        ListingRequest listingRequest= mapperService.convertToEntity(updateDTO, ListingRequest.class);
        repository.update(id, listingRequest);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
