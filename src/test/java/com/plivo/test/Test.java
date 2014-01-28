package com.plivo.test;

import java.util.LinkedHashMap;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.call.Call;
import com.plivo.helper.api.response.message.MessageResponse;
import com.plivo.helper.exception.PlivoException;

public class Test {

	static String auth_id = "xxx";
	static String auth_token = "xxxx";

	public static void main1(String[] args) {

		RestAPI restAPI = new RestAPI(auth_id, auth_token, null);
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("src", "xxx");
		parameters.put("dst", "xx");
		parameters.put("text", "ciao flower come va?");
		parameters.put("url",
				"http://xxx.rhcloud.com/statusCallback.jsf");
		try {
			MessageResponse result = restAPI.sendMessage(parameters);
			for (String uid : result.messageUuids) {
				System.out.println(uid);
			}
			System.out.println();
		} catch (PlivoException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		RestAPI restAPI = new RestAPI(auth_id, auth_token);
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("from", "xx");
		parameters.put("to", "xx<xx");
		parameters.put("answer_url",
				"http://xxxx.rhcloud.com/statusCallback.jsf");
		try {
			Call result = restAPI.makeCall(parameters);
			System.out.println(result.requestUUID);
			System.out.println(result.apiId);
			System.out.println(result.message);
			System.out.println(result.error);
		} catch (PlivoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
