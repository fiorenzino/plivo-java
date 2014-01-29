package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class HangUpConferenceMemberTest extends AbstractTest {

	@Test
	public void test() {

		getParameters().put("conference_name", "1234");
		getParameters().put("member_id", "5");
		try {
			GenericResponse response = getRestApi().hangupMember(
					getParameters());
			Assert.assertNotNull(response.message);
		} catch (PlivoException plivoException) {

			plivoException.printStackTrace();
		}

	}

}
