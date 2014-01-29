package com.plivo.test.conference;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class MuteMemberTest extends AbstractTest {

	@Test
	public void test() {

		/**
		 * getParameters() : member_id - one single id multiple member ids
		 * delimited by ',' 'all' - to mute all members of conference
		 */

		getParameters().put("conference_name", "1234");
		getParameters().put("member_id", "1,2,3");
		try {
			GenericResponse response = getRestApi().muteMember(getParameters());
			Assert.assertNotNull(response.apiId);
		} catch (PlivoException plivoException) {
			plivoException.printStackTrace();
		}
	}

}
