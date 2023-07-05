package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    @GetMapping(value = "/ships/{id}")
    public Optional<Ship> getShip(@PathVariable Long id){
        return shipRepository.findById(id);
    }

//    @GetMapping(value = "/ships")
//    public List<Ship> getAllShips(){
//        return shipRepository.findAll();
//    } //This is superceeded by the code below


    @GetMapping(value = "/ships") //RequestParam
    public ResponseEntity<List<Ship>> getShipWithPirateFirstName(@RequestParam(name = "byPirateFirstName", required = false) String name){
        //browser query at local host = http://localhost:8080/ships?byPirateFirstName=Jack
        if(name != null) {
        return new ResponseEntity<>(shipRepository.findByPirates_FirstName(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(shipRepository.findAll(), HttpStatus.OK);
        }
    }



    @PostMapping(value = "/ships")
    public ResponseEntity<Ship> postShip(@RequestBody Ship ship){
        shipRepository.save(ship);
        return new ResponseEntity<>(ship, HttpStatus.CREATED);
    }

}
