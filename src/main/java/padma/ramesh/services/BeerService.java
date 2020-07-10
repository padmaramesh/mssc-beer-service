package padma.ramesh.services;

import padma.ramesh.exceptions.NotFoundException;
import padma.ramesh.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId) throws NotFoundException;

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto) throws NotFoundException;
}
