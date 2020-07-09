package padma.ramesh.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import padma.ramesh.web.model.BeerDto;
import padma.ramesh.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidDto();

        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidDto();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString(),beerDto)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    private BeerDto getValidDto() {
        return BeerDto.builder()
                .beerName("KingFisher")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal(2.99))
                .upc(12344444L)
                .build();
    }
}