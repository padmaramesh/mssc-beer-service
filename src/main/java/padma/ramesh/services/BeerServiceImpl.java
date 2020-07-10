package padma.ramesh.services;

import org.springframework.beans.factory.annotation.Autowired;
import padma.ramesh.domain.Beer;
import padma.ramesh.exceptions.NotFoundException;
import padma.ramesh.repositories.BeerRespository;
import padma.ramesh.web.mappers.BeerMapper;
import padma.ramesh.web.model.BeerDto;

import java.util.UUID;

public class BeerServiceImpl implements BeerService {

    @Autowired
    BeerRespository beerRespository;

    @Autowired
    BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) throws NotFoundException {
        return beerMapper.beerToBeerDto(beerRespository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRespository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) throws NotFoundException {
        Beer beer = beerRespository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRespository.save(beer));
    }
}
