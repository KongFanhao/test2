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

public class LoginTestCSDN {

	private String lt;
	private String execution;
	private String _eventId;
	private String LOGIN_URL = "https://passport.csdn.net/account/login";
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 获取必要的登陆参数信息
	 * 
	 * @throws IOException
	 */
	public void fetchNecessaryParam() throws IOException {
		// 此处该用统一的配置文件存信息

		// 查看CSDN登陆页面源码发现登陆时需要post5个参数
		// name、password，另外三个在页面的隐藏域中，a good start
		logger.info("获取必要的登陆信息。。。。。");
		// 这样登陆不行，因为第一次需要访问需要拿到上下文context
		// Document doc = Jsoup.connect(LOGIN_URL).get();
		String html = HttpUtils.sendGet(LOGIN_URL);
		Document doc = Jsoup.parse(html);
		Element form = doc.select(".user-pass").get(0);
		lt = form.select("input[name=lt]").get(0).val();
		execution = form.select("input[name=execution]").get(0).val();
		_eventId = form.select("input[name=_eventId]").get(0).val();

		logger.info("It:" + lt);
		logger.info("execution:" + execution);
		logger.info("_eventId" + _eventId);
		logger.info("获取成功。。。。。");
	}

	public boolean mockLogin(String username, String password) {
		logger.info("开始登陆。。。。。");
		boolean result = false;
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", username));
		nvps.add(new BasicNameValuePair("password", password));
		nvps.add(new BasicNameValuePair("lt", lt));
		nvps.add(new BasicNameValuePair("execution", execution));
		nvps.add(new BasicNameValuePair("_eventId", _eventId));
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
