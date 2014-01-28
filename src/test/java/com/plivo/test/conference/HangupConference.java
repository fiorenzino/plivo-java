package com.plivo.test.conference;

import java.util.LinkedHashMap;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;

public class HangupConference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RestAPI restAPI = new RestAPI("<AUTH_ID>", "<AUTH_TOKEN>", "v1");

		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		params.put("conference_name", "1234");

		GenericResponse genResponse = new GenericResponse();

		try {
			genResponse = restAPI.hangupConference(params);
			System.out.println(genResponse.apiId);
		} catch (PlivoException plivoException) {

			plivoException.printStackTrace();
		}

	}

}
