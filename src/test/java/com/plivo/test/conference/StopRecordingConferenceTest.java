package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class StopRecordingConferenceTest extends AbstractTest {

	@Test
	public void test() {
		getParameters().put("conference_name", "1234");

		try {
			GenericResponse response = getRestApi().stopRecordConference(
					getParameters());
			Assert.assertNotNull(response.apiId);
		} catch (PlivoException plivoException) {
			plivoException.printStackTrace();
		}
	}
}
