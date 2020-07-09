package padma.ramesh.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import padma.ramesh.web.model.BeerDto;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ramesh.padma on 25-06-2020.
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
        //todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        //Todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,@ Valid  @RequestBody BeerDto beerDto){

        //TODO IMPL
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
   /* @ExceptionHandler(Exception.class)
   public ResponseEntity<String> handleError(MethodArgumentNotValidException e){
 *//*        List<String> errors = new ArrayList<>(e.get().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });*//*

        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }*/
}
