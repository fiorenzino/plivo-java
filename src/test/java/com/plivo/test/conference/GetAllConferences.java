package com.plivo.test.conference;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.conference.LiveConferenceFactory;
import com.plivo.helper.exception.PlivoException;

public class GetAllConferences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RestAPI restAPI = new RestAPI("<AUTH_ID>", "<AUTH_TOKEN>", "v1");

		try {
			LiveConferenceFactory liveConferenceList = restAPI
					.getLiveConferences();
			System.out.println(liveConferenceList.apiId);
			for (String conferenceName : liveConferenceList.conferences) {
				System.out.println("Conference name : " + conferenceName);
			}
		} catch (PlivoException e) {
			e.printStackTrace();
		}

	}

}
