package com.plivo.test.conference;

import java.util.LinkedHashMap;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.exception.PlivoException;
import com.plivo.helper.api.response.response.GenericResponse;

public class SpeakToMember {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		RestAPI restAPI = new RestAPI("<AUTH_ID>", "<AUTH_TOKEN>", "v1");
		
		LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		
		params.put("conference_name", "1234");
		params.put("member_id", "1");			/* single member_id or multiple or 'all' */
		params.put("text", "Hello! Member. Welcome to the conference 1234");
		
		/**
		 * Optional Parameters
		 * 
		 * voice : MAN, WOMAN, Defaults to WOMAN
		 * language : en-US,el-GR etc.
		 * 
		 * params.put("voice", "MAN");
		 * params.put("language", "en-US");
		 */
		
		GenericResponse response = new GenericResponse();
		
		try
		{
			response = restAPI.speakMember(params);
			System.out.println(response.apiId);
		} 
		catch (PlivoException plivoException) {

			plivoException.printStackTrace();
		}
		
	}

}
