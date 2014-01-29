package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class StopPlayMemberTest extends AbstractTest {

	@Test
	public void test() {

		getParameters().put("conference_name", "1234");
		getParameters().put("member_id", "1,2");
		/* single member_id or multiple or 'all' */

		try {
			GenericResponse response = getRestApi().stopPlayMember(
					getParameters());
			Assert.assertNotNull(response.apiId);
		} catch (PlivoException plivoException) {

			plivoException.printStackTrace();
		}

	}

}
