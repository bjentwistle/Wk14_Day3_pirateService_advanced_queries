package com.example.codeclan.pirateservice;


import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.models.Signup;
import com.example.codeclan.pirateservice.repository.PirateRepository;
import com.example.codeclan.pirateservice.repository.RaidRepository;
import com.example.codeclan.pirateservice.repository.ShipRepository;
import com.example.codeclan.pirateservice.repository.SignUpRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	RaidRepository raidRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	SignUpRepository signUpRepository;

	@Test
	public void contextLoads() {
	}

// NOTE - These tests relied on the dataloader which was bad
//
//	@Test
//	public void canFindPiratesOfSpesficAge(){
//		List<Pirate> foundPirates = pirateRepository.findPiratesByAge(32);
//		for (Pirate pirate : foundPirates){
//			assertTrue(pirate.getAge() == 32);
//		}
//	}
//
//	@Test
//	public void canFindPiratesByNameAndAge(){
//			List<Pirate> foundPirates = pirateRepository.findByAgeAndFirstName(55, "John");
//			assertTrue(foundPirates.size() > 0);
//			for (Pirate pirate : foundPirates){
//			assertEquals(pirate.getAge(), 55);
//			assertEquals(pirate.getFirstName(), "John");
//		}
//	}
//
//	@Test
//	public void canFindPiratesOver30(){
//		List<Pirate> foundPirates = pirateRepository.findByAgeGreaterThan(30);
//		assertTrue(foundPirates.size() == 7);
//	}
//
//	@BeforeEach


	@Test
	public void can_Find_All_The_Pirates_For_A_Given_Raid_Id(){
		Ship ship = new Ship("The Dolphin");
		shipRepository.save(ship);
		Pirate alex = new Pirate("Alex", "B", 72, ship );
		pirateRepository.save(alex);
		Raid raid = new Raid("Edinburgh", 1000);
		raidRepository.save(raid);
		Signup signup = new Signup(alex, raid);
		signUpRepository.save(signup);
		List<Pirate> foundPirates = pirateRepository.findBySignupsRaidId(raid.getId());
		assertEquals(1, foundPirates.size());
		assertEquals(alex.getId(), foundPirates.get(0).getId());
	}




}
