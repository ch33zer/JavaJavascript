package com.davidwatson.JBNA.token;



public abstract class Token {
	final private TokenType type;
	
	private int lineNumber = -1, tokenStart = -1, tokenEnd = -1;
	
	private String sourceLine;
	
	public Token() {
		super();
		this.type = TokenType.getInstance(getClass());
	}

	public abstract String getReadableName();
		
	public final TokenType type() {
		return type;
	}
	
	public final String getSourceDefinition() {
		char nl = '\n';
		StringBuilder sb = new StringBuilder();
		sb.append("Line: " + lineNumber);
		sb.append(nl);
		String notabs = sourceLine.replace('\t', ' ');
		sb.append(notabs);
		String firstSpaces = new String(new char[tokenStart]).replace("\0", " ");
		String secondSpaces = new String(new char[tokenStart - tokenEnd - 1]).replace("\0", " ");
		sb.append(firstSpaces).append("^").append(secondSpaces).append("^");
		return sb.toString();
		

	}
	
	public boolean isType(Class<? extends Token> clazz) {
		return type.isType(clazz);
	}
	
	
	public boolean isType(TokenType tt) {
		return type.isType(tt);
	}
	
	public boolean isType(Token t) {
		return type.isType(t);
	}
	
	public boolean ofType(Class<? extends Token> clazz) {
		return type.ofType(clazz);
	}
	
	public boolean ofType(TokenType tt) {
		return type.ofType(tt);

	}
	public boolean ofType(Token t) {
		return type.ofType(t);
	}

	/**
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * @return the tokenStart
	 */
	public int getTokenStart() {
		return tokenStart;
	}

	/**
	 * @param tokenStart the tokenStart to set
	 */
	public void setTokenStart(int tokenStart) {
		this.tokenStart = tokenStart;
	}

	/**
	 * @return the tokenEnd
	 */
	public int getTokenEnd() {
		return tokenEnd;
	}

	/**
	 * @param tokenEnd the tokenEnd to set
	 */
	public void setTokenEnd(int tokenEnd) {
		this.tokenEnd = tokenEnd;
	}

	/**
	 * @return the sourceLine
	 */
	public String getSourceLine() {
		return sourceLine;
	}

	/**
	 * @param sourceLine the sourceLine to set
	 */
	public void setSourceLine(String sourceLine) {
		this.sourceLine = sourceLine;
	}
}
