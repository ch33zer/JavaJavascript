package com.davidwatson.JBNA.test;

import junit.framework.Assert;

import org.junit.Test;

import com.davidwatson.JBNA.test.test.resources.TestToken;
import com.davidwatson.JBNA.test.test.resources.TestToken2;
import com.davidwatson.JBNA.test.test.resources.TestToken3;
import com.davidwatson.JBNA.token.Token;

public class TypeTest {

	@Test
	public void testIsType() {
		TestToken tt = new TestToken();
		TestToken2 tt2 = new TestToken2();
		Assert.assertTrue(tt.isType(tt.type()));
		Assert.assertTrue(tt.isType(tt));
		Assert.assertTrue(tt.isType(TestToken.class));
		Assert.assertFalse(tt.isType(tt2));
		Assert.assertFalse(tt.isType(tt2.type()));
		Assert.assertFalse(tt.isType((Token)null));
	}
	
	@Test
	public void testOfType() {
		TestToken3 tt3 = new TestToken3();
		TestToken2 tt2 = new TestToken2();
		Assert.assertTrue(tt3.ofType(TestToken2.class));
		Assert.assertFalse(tt3.ofType(TestToken.class));
		Assert.assertFalse(tt2.ofType(TestToken3.class));
		Assert.assertTrue(tt3.ofType(tt3));
		Assert.assertTrue(tt3.type().ofType(tt3.type()));
	}
	
	

}
