package com.plivo.test.number;

import junit.framework.Assert;

import org.junit.Test;

import com.plivo.helper.api.response.number.NumberSearchFactory;
import com.plivo.helper.exception.PlivoException;
import com.plivo.test.common.AbstractTest;

public class ListRentedNumberTest extends AbstractTest {

	@Test
	public void test() {

		try {
			NumberSearchFactory numbers = getRestApi().getNumbers();
			Assert.assertNotNull(numbers.numberList.get(0).number);
		} catch (PlivoException plivoException) {
			plivoException.printStackTrace();
		}

	}

}
