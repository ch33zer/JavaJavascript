package com.davidwatson.util;

public class Util {
	public static boolean n(Object... objects) {
		if (objects == null) {
			return false;
		}
		for (Object object : objects) {
			if (object == null) {
				return true;
			}
		}
		return false;
	}
}
