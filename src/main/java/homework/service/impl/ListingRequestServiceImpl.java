package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.listingRequest.ListingRequestFullDto;
import homework.entity.ListingRequest;
import homework.repository.api.ListingRequestRepository;
import homework.service.ListingRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ListingRequestServiceImpl implements ListingRequestService {

    private ListingRequestRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<ListingRequestFullDto> findAll() {

        return repository.findAll().stream()
                .map(listingRequest -> mapper.convertToDto(listingRequest, ListingRequestFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ListingRequestFullDto findById(long id) {
        ListingRequest listingRequest = repository.findById(id);

        return mapper.convertToDto(listingRequest, ListingRequestFullDto.class);
    }

    @Override
    public void save(ListingRequestFullDto object) {
        ListingRequest listingRequest = mapper.convertToEntity(object, ListingRequest.class);
        repository.save(listingRequest);
    }
    @Override
    public void update(long id, ListingRequestFullDto updateDTO) {
        ListingRequest listingRequest  = mapper.convertToEntity(updateDTO, ListingRequest.class);
        repository.update(listingRequest);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
