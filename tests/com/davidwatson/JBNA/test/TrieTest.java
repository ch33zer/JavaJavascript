package com.davidwatson.JBNA.test;

import junit.framework.Assert;

import org.junit.Test;

import com.davidwatson.util.Trie;

public class TrieTest {
	@Test
	public void testcontains() {
		Trie trie = new Trie();
		trie.addWord("as");
		Assert.assertTrue(trie.contains("as"));
		Assert.assertFalse(trie.contains("a"));
		Assert.assertFalse(trie.contains("asd"));
		trie.addWord("asd");
		Assert.assertTrue(trie.contains("as"));
		Assert.assertFalse(trie.contains("a"));
		Assert.assertTrue(trie.contains("asd"));
		Assert.assertFalse(trie.contains("asdf"));
		trie.addWord("asf");
		Assert.assertTrue(trie.contains("as"));
		Assert.assertFalse(trie.contains("a"));
		Assert.assertTrue(trie.contains("asd"));
		Assert.assertTrue(trie.contains("asf"));
		Assert.assertFalse(trie.contains("asdf"));
		Assert.assertFalse(trie.contains("asfd"));

	}
}
