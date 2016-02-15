package com.tjut.magic.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tjut.magic.login.util.HttpUtils;

public class LoginTjut {

	private String LOGIN_URL = "http://211.81.31.34/uhtbin/cgisirsi/x/0/0/57/49?user_id=LIBSCI_ENGI&password=LIBSC";
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 获取必要的登陆参数信息
	 * 
	 * @throws IOException
	 */
	

	public boolean mockLogin(String user_id, String password) {
		logger.info("开始登陆。。。。。");
		boolean result = false;
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("user_id", user_id));
		nvps.add(new BasicNameValuePair("password", password));
		
		String ret = HttpUtils.sendPost(LOGIN_URL, nvps);
		if (ret.indexOf("redirect_back") > -1) {
			logger.info("登陆成功。。。。。");
			result = true;
		} else if (ret.indexOf("登录太频繁") > -1) {
			logger.info("登录太频繁，请稍后再试。。。。。");
		} else {
			logger.info("登陆失败。。。。。");
		}
		return result;
	}

}
