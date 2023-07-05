package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repository.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RaidController {

    @Autowired
    RaidRepository raidRepo;

    @GetMapping(value = "/raids")
    public ResponseEntity<List<Raid>> getAllRaids(){
        return new ResponseEntity<>(raidRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/raids/{id}")
    public ResponseEntity<Optional<Raid>> getRaidbyID(@PathVariable Long id){
        Optional<Raid> optionalRaid = raidRepo.findById(id);
        if (!optionalRaid.isPresent()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(optionalRaid,HttpStatus.FOUND);
        }
    }
    @PostMapping(value = "/raids")
    public ResponseEntity<Raid> postPirate(@RequestBody Raid raid){
        raidRepo.save(raid);
        return new ResponseEntity<>(raid, HttpStatus.CREATED);
    }

}
