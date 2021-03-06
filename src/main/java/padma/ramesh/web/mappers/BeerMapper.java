package padma.ramesh.web.mappers;

import org.mapstruct.Mapper;
import padma.ramesh.domain.Beer;
import padma.ramesh.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
