package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class HangupAllConferencesTest extends AbstractTest {

	@Test
	public void test() {
		try {
			GenericResponse genResponse = getRestApi().hangupAllConferences();
			Assert.assertNotNull(genResponse.apiId);
		} catch (PlivoException plivoException) {
			plivoException.printStackTrace();
		}
	}

}
