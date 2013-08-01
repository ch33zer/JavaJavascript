package com.davidwatson.JBNA;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import com.davidwatson.JBNA.token.DedentToken;
import com.davidwatson.JBNA.token.IndentToken;
import com.davidwatson.JBNA.token.Token;

public class Tokenizer implements ITokenizer {

	private BufferedReader reader;

	private int sourcePosition = 0;
	private int lineNumber = 0;
	private String line = "";

	private int tokenStart;

	private int tokenEnd;

	public Tokenizer(BufferedReader reader) {
		super();
		this.reader = reader;
	}

	public List<Token> getTokens() throws IOException {
		List<Token> tokens = new ArrayList<Token>();
		try {
			int oldIndent = 0;
			while (reader.ready()) {
				lineNumber++;
				line = reader.readLine();
				boolean onlySeenWhitespace = true;
				int indentCount = 0;
				char[] lineChars = line.toCharArray();
				StringBuilder sb = new StringBuilder();
				tokenStart = 0;
				for (int i = 0; i < lineChars.length; i++) {
					sourcePosition = i;
					char c = lineChars[i];
					if (Character.isWhitespace(c) && onlySeenWhitespace) {
						if (c == '\t') {
							indentCount += 8;
						} else {
							indentCount += 1;
						}
					} else {
						if (onlySeenWhitespace) {
							onlySeenWhitespace = false;
							tokenEnd = i;
							if (oldIndent > indentCount) {
								tokens.add(infoify(new DedentToken(indentCount)));
							} else if (oldIndent < indentCount) {
								tokens.add(infoify(new IndentToken(indentCount)));
							}
						}
						

					}
				}
				oldIndent = indentCount;
			}
		} catch (IOException e) {
			tokens.clear();
		}
		for (Token token : tokens) {
			if (token.getTokenStart() == -1) {
				throw new InvalidParameterException(
						"Token "
								+ token
								+ " does not contain starting position info. Was it passed through infoifyToken?");
			}
		}
		return tokens;
	}

	private Token infoify(Token t) {
		t.setSourceLine(line);
		t.setLineNumber(lineNumber);
		t.setTokenStart(tokenStart);
		t.setTokenEnd(tokenEnd);
		return t;
	}

}
