package com.davidwatson.JBNA.token;

public class IndentToken extends Indentation {
	private int indentLevel;
	public IndentToken(int indentLevel) {
		this.indentLevel = indentLevel;
	}
	@Override
	public String getReadableName() {
		return "Indent";
	}
	/**
	 * @return the indentLevel
	 */
	public int getIndentLevel() {
		return indentLevel;
	}

}
