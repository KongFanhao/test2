package com.tjut.magic.login;

import java.io.IOException;

import org.apache.commons.logging.impl.Log4JLogger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tjut.magic.login.util.HttpUtils;

public class TestLoginTestCSDN {

	@Test
	public void TestfetchNecessaryParam() throws IOException {
		String username = "619157417@qq.com";
		String password = "zero911108";
		LoginTestCSDN login = new LoginTestCSDN();
		login.fetchNecessaryParam();
		login.mockLogin(username, password);
	}

}
