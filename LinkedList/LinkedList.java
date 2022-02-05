package LinkedList;

public class LinkedList {
    class Node{
        private int value;
        private Node next;

        public Node(){
            value = -1;
            next = null;
        }

        public Node(int value, Node next){
            this.value =value;
            this.next = next;
        }
    }

    Node head;

    public LinkedList(){
        head = null;
    }

    // Time: O(1)
    public void addFirst(int value){
        head = new Node(value, head);
    }

    // time: O(N)
    public void addLast(int value){
        if(head == null) {
            addFirst(value); 
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(value, null);
    }

    // time: O(N)
    public Node findNodeWithValue(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value) return temp;
            temp = temp.next;
        }
        return null;
    }

    // inserstAFter(5, 10)
    // 1 -> 2 -> 3 -> 7 -> 4 -> 5 -> 10 -> null
        // time: O(N)
    public boolean insertAfter(int ithValue, int valueToInsert){
        if(head == null) return false;
        Node temp = head;
        while(temp != null && temp.value != ithValue){
            temp = temp.next;
        }
        if(temp == null) return false;
        temp.next = new Node(valueToInsert, temp.next);
        return true;
    }
    //insesrtBefore(3, 7)
    // 1 -> 2 -> 3 -> 4 -> 5
    // time: O(N)
    public boolean insertBefore(int ithValue, int valueToInsert){
        if(head == null) return false;
        if(head.value == ithValue) head = new Node(valueToInsert, head);
        Node temp = head;
        while(temp.next != null && temp.next.value != ithValue){
            temp =temp.next;
        }
        if(temp.next == null) return false;
        temp.next = new Node(valueToInsert, temp.next);
        return true;
    }

    // time: O(N)
    public int size(){
        int lengthOfLL = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            lengthOfLL += 1;
        }
        return lengthOfLL;
    }

        // time: O(N)
    public boolean containsNodeWithValue(int value){
        Node temp = findNodeWithValue(value);
       return temp != null;
    }

        // time: O(N)
    public boolean replace(int oldValue, int newValue){
        Node temp = findNodeWithValue(oldValue);
        if(temp != null) temp.value = newValue;
        return false;
    }

        // time: O(N)
    public void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "-->");
        }
        System.out.print("null\n");
    }


























}
