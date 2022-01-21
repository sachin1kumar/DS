package codingminutes.trie_advance;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public char data;
    public Map<Character, TrieNode> map;
    public boolean isTerminated;

    public TrieNode(char data) {
        this.data = data;
        this.map = new HashMap<>();
        this.isTerminated = false;
    }
}
