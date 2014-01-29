package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.conference.LiveConferenceFactory;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class GetAllConferencesTest extends AbstractTest {

	@Test
	public void test() {

		try {
			LiveConferenceFactory liveConferenceList = getRestApi()
					.getLiveConferences();
			Assert.assertNotNull(liveConferenceList.apiId);
			for (String conferenceName : liveConferenceList.conferences) {
				Assert.assertNotNull(conferenceName);
			}
		} catch (PlivoException e) {
			e.printStackTrace();
		}

	}

}
