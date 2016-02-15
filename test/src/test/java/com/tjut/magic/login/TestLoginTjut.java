package com.tjut.magic.login;

import java.io.IOException;

import org.junit.Test;

public class TestLoginTjut {
	
	@Test
	public void TestfetchNecessaryParam() throws IOException {
		String user_id = "R0500A20135916";
		String password = "000";
		LoginTjut lt = new LoginTjut();
		lt.mockLogin(user_id, password);
	}

}
