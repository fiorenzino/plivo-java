package com.plivo.test;

import java.util.LinkedHashMap;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.call.Call;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;

public class MessageTest {

	static String auth_id = "xx";
	static String auth_token = "xxxxx";

	@Test
	public void testSingleMessage() {

		RestAPI restAPI = new RestAPI(auth_id, auth_token, null);
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("src", "x");
		parameters.put("dst", "xx");
		parameters.put("text", "ciao flower come va?");
		parameters.put("url", "http://xxx.rhcloud.com/statusCallback.jsf");
		try {
			MessageResponse result = restAPI.sendMessage(parameters);
			for (String uid : result.messageUuids) {
				Assert.assertNotNull(uid);
				Assert.assertNull(result.error);
			}
		} catch (PlivoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMultiMessage() {

		RestAPI restAPI = new RestAPI(auth_id, auth_token);
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("src", "xx");
		parameters.put("dst", "xx<xx");
		parameters.put("answer_url",
				"http://xxxx.rhcloud.com/statusCallback.jsf");
		try {
			Call result = restAPI.makeCall(parameters);
			Assert.assertNotNull(result.requestUUID);
			Assert.assertNull(result.error);
		} catch (PlivoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
