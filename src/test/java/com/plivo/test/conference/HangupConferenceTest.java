package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class HangupConferenceTest extends AbstractTest {

	@Test
	public void test() {
		getParameters().put("conference_name", "1234");
		try {
			GenericResponse genResponse = getRestApi().hangupConference(
					getParameters());
			Assert.assertNotNull(genResponse.apiId);
		} catch (PlivoException plivoException) {

			plivoException.printStackTrace();
		}

	}

}
