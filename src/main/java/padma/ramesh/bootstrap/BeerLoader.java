package padma.ramesh.bootstrap;

import org.springframework.boot.CommandLineRunner;
import padma.ramesh.domain.Beer;
import padma.ramesh.repositories.BeerRespository;

import java.math.BigDecimal;

public class BeerLoader implements CommandLineRunner {

    private final BeerRespository beerRespository;

    public BeerLoader(BeerRespository beerRespository) {
        this.beerRespository = beerRespository;
    }

    @Override
    public void run(String... args) throws Exception {
            loadBeerObjects();
    }

    private void loadBeerObjects() {

        beerRespository.save(Beer.builder()
                .beerName("Kingfisher")
                .beerStyle("Lager")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(23156666L)
                .price(new BigDecimal(12.95))
                .build());

        beerRespository.save(Beer.builder()
                .beerName("Budwiser")
                .beerStyle("Lager")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(23896666L)
                .price(new BigDecimal(11.95))
                .build());
    }


}
