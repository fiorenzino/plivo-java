package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.conference.Conference;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class RetrieveConferenceDetailsTest extends AbstractTest {

	@Test
	public void test() {
		getParameters().put("conference_name", "1234");
		try {
			Conference response = getRestApi().getLiveConference(
					getParameters());
			Assert.assertNotNull(response.conferenceMemberCount);
		} catch (PlivoException e) {
			e.printStackTrace();
		}

	}

}
