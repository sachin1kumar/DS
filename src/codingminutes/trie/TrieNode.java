package codingminutes.trie;

public class TrieNode {

    public TrieNode[] children;
    public boolean isTerminated;
    public char data;

    public TrieNode(char data) {
        this.data = data;
        this.children = new TrieNode[26];
        this.isTerminated = false;
    }
}
