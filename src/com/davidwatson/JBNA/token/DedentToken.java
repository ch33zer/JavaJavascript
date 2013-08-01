package com.davidwatson.JBNA.token;

public class DedentToken extends Indentation {
	private int indentLevel;
	public DedentToken(int indentLevel) {
		this.indentLevel = indentLevel;
	}
	@Override
	public String getReadableName() {
		return "Dedent";
	}
	/**
	 * @return the indentLevel
	 */
	public int getIndentLevel() {
		return indentLevel;
	}

}
