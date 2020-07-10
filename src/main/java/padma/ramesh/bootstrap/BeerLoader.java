package padma.ramesh.bootstrap;

import org.springframework.boot.CommandLineRunner;
import padma.ramesh.domain.Beer;
import padma.ramesh.repositories.BeerRespository;

import java.math.BigDecimal;

public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "25457+91234";
    public static final String BEER_2_UPC = "25457+91234";
    public static final String BEER_3_UPC = "25457+91234";

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
                .upc(BEER_1_UPC)
                .price(new BigDecimal(12.95))
                .build());

        beerRespository.save(Beer.builder()
                .beerName("Budwiser")
                .beerStyle("Lager")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_2_UPC)
                .price(new BigDecimal(11.95))
                .build());

        beerRespository.save(Beer.builder()
                .beerName("Budwiser")
                .beerStyle("Lager")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_3_UPC)
                .price(new BigDecimal(11.95))
                .build());
    }


}
