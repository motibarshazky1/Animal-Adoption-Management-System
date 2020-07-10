package Tests;

import static org.junit.Assert.assertFalse;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import BussinessLayer.Adopter;
import BussinessLayer.Adoption;
import BussinessLayer.Animal;
import BussinessLayer.AnimalFactory;
import BussinessLayer.SendEmail;
import BussinessLayer.login;
import BussinessLayer.serverTunnel;

class testFile {

	
	
	@Test
	public void TestLogin() {
		login log=new login("","123");
		serverTunnel tunnel=null;
		try {
			 tunnel=serverTunnel.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tunnel.login(log);
		assertEquals("user or password must not be null",log.getMsg());
		}
	
	
	
	
	@Test
	public void TastAddAnimal() {
		//Test if Animal is available after adoption.
		AnimalFactory animalFctory = new AnimalFactory(); 
		Animal a = animalFctory.createAnimal(-3,"tomer","dog","male",5,6);  // create the dog or cat object.
		Adopter adopterTest=new Adopter(0, "tomer", "male", 6, "", 05074254, "rishon", "@.com");
		Adoption adoptionCaseTest=new Adoption(0,a,adopterTest);
		assertFalse("The animal is already was adopted but its still available to adoption", a.getStatus());
		}
	


	
	@Test
	public void TestIdsIfEqualToAdoptionCase() 
	//Test if Animal ID and Adopter ID are equal in Adoption case.
	{
		AnimalFactory animalFctory = new AnimalFactory(); 
		Animal a = animalFctory.createAnimal(3,"tomer","dog","male",5,6);  // create the dog or cat object.
		Adopter adopterTest=new Adopter(0, "tomer", "male", 6, "", 05074254, "rishon", "@.com");
		Adoption adoptionCaseTest=new Adoption(0,a,adopterTest);
		assertEquals(a.getId(), adoptionCaseTest.animal.getId());
		assertEquals(adopterTest.GetId(), adoptionCaseTest.adopter.GetId());
		
		}





}
