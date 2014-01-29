package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.Record;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class RecordConferenceTest extends AbstractTest {

	@Test
	public void test() {

		getParameters().put("conference_name", "1234");
		/**
		 * Optional parameters:
		 * 
		 * getParameters().put("file_format","mp3");
		 */
		try {
			Record response = getRestApi().recordConference(getParameters());
			Assert.assertNotNull(response.url);
		} catch (PlivoException plivoException) {
			plivoException.printStackTrace();
		}
	}

}
