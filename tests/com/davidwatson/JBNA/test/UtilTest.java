package com.davidwatson.JBNA.test;

import junit.framework.Assert;

import org.junit.Test;

import com.davidwatson.util.Util;

public class UtilTest {

	@Test
	public void testNullChecker() {
		Assert.assertTrue(Util.n((Object)null));
		Assert.assertTrue(Util.n("", (Object)null));
		Assert.assertFalse(Util.n(""));
		Assert.assertFalse(Util.n("",""));
	}

}
