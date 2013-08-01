package com.davidwatson.JBNA.token;

import java.util.HashMap;
import java.util.Map;

import com.davidwatson.util.Util;

public class  TokenType {

	private Class<? extends Token> ID;
	private static Map<Class<? extends Token>, TokenType> idents;
	private TokenType(Class<? extends Token> ID) {
		this.ID = ID;
	}
	
	@Override
	public String toString() {
		return ID.getName();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this == null) {
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		TokenType other = (TokenType) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	/** Returns whether this token is exactly of the specified class
	 * @param clazz The Type to check
	 * @return Whether the tokens are of the same type
	 */
	public boolean isType(Class<? extends Token> clazz) {
		return equals(getInstance(clazz));
	}
	
	
	public boolean isType(TokenType tt) {
		return isType(tt.ID);
	}
	
	public boolean isType(Token t) {
		if (Util.n(t)) {
			return false;
		}
		return isType(t.type());
	}
	
	/** Determines whether this token is<i> or is a subclass</i> of the specified token
	 * @param clazz
	 * @return
	 */
	public boolean ofType(Class<? extends Token> clazz) {
		return clazz.isAssignableFrom(ID);
	}
	
	public boolean ofType(TokenType tt) {
		if (Util.n(tt)) {
			return false;
		}
		return ofType(tt.ID);
	}
	public boolean ofType(Token t) {
		if (Util.n(t)) {
			return false;
		}
		return ofType(t.type());
	}

	public static synchronized  TokenType getInstance(Class<? extends Token> clazz) {
		if (clazz == null) {
			return null;
		}
		if (idents == null) {
			idents = new HashMap<Class<? extends Token>, TokenType>();
		}
		if (!idents.containsKey(clazz)) {
			idents.put(clazz, new TokenType(clazz));
		}
		return idents.get(clazz);
	}
}
