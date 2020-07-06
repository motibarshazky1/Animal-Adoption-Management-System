package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import logicalLayers.login;
import userInterfaceLayer.Login_Panel;

class loginTest {

	@Test
	void test() {

	Login_Panel test=new Login_Panel();
	try
	{
		test.start_login(" ", "123");

	}catch (IllegalArgumentException e) {
Assertions.assertEquals("user or password must not be null", e.getMessage());	}
	
	
	}

}
