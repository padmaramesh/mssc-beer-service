package padma.ramesh.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import padma.ramesh.domain.Beer;

import java.util.UUID;

public interface BeerRespository extends PagingAndSortingRepository<Beer, UUID> {
}
