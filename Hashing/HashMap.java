package Hashing;

public class HashMap {

    LinkedList[] hashmap;

    public HashMap(){
        hashmap = new LinkedList[10];
        for(int i = 0; i < 10; i++){
            hashmap[i] = new LinkedList();
        }
    }

    public int computeIndex(long key){
        long firstDigit = Long.parseLong("" + Long.toString(key).charAt(0));
        return (int) firstDigit;
    }

    public void add(long key, String value){
        int index = computeIndex(key);
        hashmap[index].add(key, value);
    }

    public boolean remove(long key){
        int index = computeIndex(key);
        return hashmap[index].remove(key);
    }

    public String getValue(long key){
        int index = computeIndex(key);
        return hashmap[index].getValue(key);
    }

    public void print(){
        for(int i = 0; i < 10; i++){
            hashmap[i].print();
        }
    }

    class LinkedList{
        Node head;

        public LinkedList(){
            head = new Node(-1, "", null);
        }

        class Node{
            private long key;
            private String value;
            private Node next;
    
            public Node(){

            }

            public Node(long key, String value, Node next){
                this.key = key;
                this.value =value;
                this.next = next;
            }
        }

        public void add(long key, String value){
            head = new Node(key, value, head);
        }

        public boolean remove(long key){
            if(head == null) return false;
            Node temp = head;
            while(temp.next != null && temp.next.key != key) temp = temp.next;
            if(temp.next == null) return false;
            temp.next = temp.next.next;
            return true;
        }

        public String getValue(long key){
            Node temp = head;
            while(temp != null && temp.key != key) temp = temp.next;
            if(temp == null) return "not found";
            return temp.value;
        }

        public void print(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.key + "-->");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
    }
}
