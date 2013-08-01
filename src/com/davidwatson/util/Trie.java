package com.davidwatson.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Trie {
	private Map<Character, Trie> transitions = new HashMap<Character, Trie>();
	private boolean endsWord = false;
	
	public Set<Character> getTransitions() {
		return transitions.keySet();
	}
	
	public boolean endsWord() {
		return endsWord;
	}
	
	public boolean contains(String test) {
		if (test.length() != 0) {
			char start = test.charAt(0);
			if (transitions.containsKey(start)) {
				return transitions.get(start).contains(test.substring(1));
			}
			return false;
		}
		else {
			return endsWord;
		}
	}
	
	public void addWord(String word) {
		if (word.length() != 0) {
			char start = word.charAt(0);
			String restOfString = word.substring(1);
			if (transitions.containsKey(start)) {
				transitions.get(start).addWord(restOfString);
			}
			else {
				Trie newTrie = new Trie();
				newTrie.addWord(restOfString);
				transitions.put(start, newTrie);
			}
		}
		else {
			endsWord = true;
		}
	}
}
