/**
 * 
 */
package trie;

import alg.Logger;

/**
 * @author cvv
 *
 */
class TrieNode {
	TrieNode [] arr;
	boolean isLeaf;
	public TrieNode () {
		this.arr = new TrieNode [26];
	}
}
class Trie {
	private TrieNode root;
	public Trie ()
	{
		root = new TrieNode ();
	}
	public void insert (String word)
	{
		if (word == null || word.trim().length() == 0) return;
		TrieNode p = root;
		for (int i = 0; i< word.length(); i ++)
		{
			TrieNode l = p.arr [word.charAt(i) - 'a'];
			if (l != null)
			{
				p = l;
			}
			else
			{
				l = new TrieNode ();
				p.arr [word.charAt(i) - 'a'] = l;
				p = l;
			}
		}
	}
	public String toString ()
	{
		StringBuffer sb = new StringBuffer ();
		TrieNode p = root;
		for (int i = 0; i < 26; i ++)
		{
			if (p.arr [i] != null)
			{
				sb.append((char) ('a' + i));
			}
		}
		return sb.toString();
	}
}
public class WordGame {
	public static void main (String [] args)
	{
		Trie t = new Trie ();
		t.insert("test");
		t.insert("tech");
		t.insert("god");
		t.insert("good");
		t.insert("fine");
		t.insert("finish");
		Logger.log("{}", t);
	}
}
