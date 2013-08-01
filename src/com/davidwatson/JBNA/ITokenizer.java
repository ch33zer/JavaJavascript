package com.davidwatson.JBNA;

import java.io.IOException;
import java.util.List;

import com.davidwatson.JBNA.token.Token;

public interface ITokenizer {
	public List<Token> getTokens() throws IOException;
}
