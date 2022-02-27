package Trie;

public class Trie {
    class Node{
        char c;
        Node[] children;
        boolean isWord;

        public Node(char c){
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }

    Node root;

    public Trie(){
        root = new Node('\0');
    }

    public void insert(String word){
        Node current = root;
        // "apple" i -> 0 => c ='a'
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) current.children[c - 'a'] = new Node(c);
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word){
        Node node = helper(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String word){
        Node node = helper(word);
        return node != null;
    }

    public Node helper(String word){
        // let's say book is present in the trie and we are lookng for "bob"
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) return null;
            current = current.children[c - 'a'];
        }
        return current;
    }
}
