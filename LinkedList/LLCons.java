package assignment3;

public class LLCons {
	private static Node head;
	//Node class defined as static. 
	//I prefer this way, because it is easy to use ADT if defined as 'static'.
	static class Node{
		private int value;
		private Node next;
		
		public Node() {
			value = 0;
			next = null;
		}
		
		public Node(int x) {
			value = x;
			next = null;
		}
		
		public Node(int val, Node nxt) {
			value = val;
			next = nxt;
		}
	}
	//The constructor for the main public class when created a reference, the head is set to null.
	public LLCons() {
		head = null;
	}
	
	//to add a node to the start, we simply initialize the head to a new value and set the next node of head to head again because now the 'new' head appears before the former head. 
	public static void addFirst(int value) {
		head = new Node(value, head);
	}
	
	//similar logic with just a few caviers.
	public static void addLast(int value) {
		//If the head is empty, it is the same as addFirst function.
		//Since, the list is empty, we point the next to null as there's just 1 element in the list that we just inserted. 
		if(head == null) {
			head = new Node(value, null);
			return;
		}
		//Initialize a temporary variable because if we iterate over head, we will lost the track of former nodes inserted so far.
		Node temp = head;
		//Iterate till the last node, as in a LinkedList we do not have indices, so we iterate till the last element.
		// (i.e.) till the (last.next == null) we stop, the reference would be stored in temp pointer.
		while(temp.next != null) {
			temp = temp.next;
		}
		//Now, simply we insert the new value on temp.next (because the next will point to last) as set it's value to and set it's next pointer to null as there are no elements after that newly inserted value.
		temp.next = new Node(value, null);
	}
	
	//The method name is so intuitive, we find the node with value 'x'.
	public static Node findNodeWithValueX(int x) {
		Node temp = head;
		//iterate till you find the value. 
		while(temp != null) {
			if(temp.value == x) {
				//if value matches, simply return the node (temp).
				return temp;
			}
			temp = temp.next;
		}
		//By this point, we have traversed entire LL and didn't find a value. So return null. 
		return null;
	}
	
	//static method to insert a new node with the 'valueToInsert' after the 'ithValue'. 
	public static boolean insertAfter(int ithValue, int valueToInsert) {
		//if the head is null, that means the list is null, so we won't find the ithValue. Therefore, return false.
		if(head == null) {
			return false;
		}
		Node temp = head;
		//simple checks to make sure, we don't hit null node and we traverse till the ithValue. (The value after which we insert the new value.)
		while(temp != null && temp.value != ithValue) {
			temp = temp.next;
		}
		//if the value is not present in the list, we'll have the value 'null' in the temp node.
		//As a result, we didn't find the node with the ithValue, so return false.
		if(temp == null) {
			return false;
		}
		//By this point, we have found the Node with the ithValue, so insert after that node. 
		temp.next = new Node(valueToInsert, temp.next);
		return true;
	}
	
	//static method to insert a new node with the 'valueToInsert' before the 'ithValue'. 
	public static boolean insertBefore(int ithValue, int valueToInsert) {
		//if the head is null, that means the list is null, so we won't find the ithValue. Therefore, return false.
		if(head == null) {
			return false;
		}
		//we make a quick check if the ithValue is the value for the first node, (i.e.) the head.
		if(head.value == ithValue) {
			//If that is indeed the case, we insert the node before the head, and point it to the current head.
			head = new Node(valueToInsert, head);
			return true;
		}
		Node temp = head;
		//Again, we traverse the list, by checking the value of the next node as the ithValue. 
		//If we found the ithValue, that means we insert the node with the valueToInsert at current position, as this is insertBefore function().
		while(temp.next != null && temp.next.value != ithValue) {
			temp = temp.next;
		}
		//if the value is not present in the list, we'll have the value 'null' in the temp node.
				//As a result, we didn't find the node with the ithValue, so return false.
		if(temp.next == null) {
			return false;
		}
		//By this point, we have found the Node with the ithValue, so insert after(because, we search for temp.next, so we insert after the current node. (before the node with ithValue)) that node. 
		temp.next = new Node(valueToInsert, temp.next);
		return true;
	}
	
	//static method to find the length of the LL.
	public static int size() {
		int sizeOfLL = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.next;
			sizeOfLL += 1;
		}
		return sizeOfLL;
	}
	
	//the method is so intuitive, we look for a node with the value 'x'.
	//this is exactly the same as findNodeWithX() method. But here, we return true or false instead of null or the found/required node.  
	public static boolean containsNodeWithValueX(int x) {
		if(findNodeWithValueX(x) != null) {
			//the findNodeWithValueX will return a node(maybe null).
			//If it is null, that means we did not find the node, so return false, else true.
			return true;
		}
		return false;
	}
	
	//static method to replace the node with ithValue and if found, it replaces that value with the newUpdatedValue.
	//If not found, it will return false.
	//According to Professor, if there are multiple nodes with the 'ithValue' we just change the first value. 
	public static boolean replace(int ithValue, int newUpdatedValue) {
		//same stuff, we traverse the list using the findNodeWithValueX() method
		Node temp = findNodeWithValueX(ithValue);
		//findNodeWithX() method returns a node, so if we get a null value we didn't find the node with the 'ithValue', return false.
		if(temp == null) {
			return false;
		}
		//By now, we have the correct node with the value 'ithValue' as its value, so we simply replace the value and return true.
		temp.value = newUpdatedValue;
		return true;
	}
	
	public static void printLinkedList() {
		Node temp = head;
		//basic check, we return if the head is null.
		if(temp == null) {
			return;
		}
		System.out.println("Following is the Linked List: ");
		while(temp != null) {
			System.out.print(temp.value + "-->");
			temp = temp.next;
		}
		//By now we have printed the entire LL. Now, we simply end the string by 'NULL'.
		System.out.print("NULL\n");
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		LLCons ll = new LLCons();
		LLCons.addFirst(18);
		LLCons.addFirst(22);
		LLCons.addFirst(4);
		LLCons.addFirst(7);
		LLCons.addFirst(32);
		LLCons.addFirst(48);
		LLCons.addLast(108);
		LLCons.addFirst(18);
		LLCons.addFirst(12);
		LLCons.addFirst(32);
		LLCons.printLinkedList();
		LLCons.replace(4, 52);
		LLCons.printLinkedList();
		LLCons.replace(95, 72);
		LLCons.printLinkedList();
		LLCons.insertAfter(7, 93);
		LLCons.printLinkedList();
		LLCons.insertBefore(48, 55);
		LLCons.printLinkedList();
		LLCons.insertBefore(32, 68);
		LLCons.printLinkedList();
		LLCons.replace(18, 44);
		LLCons.printLinkedList();
		LLCons.insertAfter(18, 98);
		LLCons.printLinkedList();
		LLCons.insertAfter(60, 3);
		LLCons.printLinkedList();
	}
	
	
	
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode temp = head;
        while(temp.next != null){
            if(temp.next.value == val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head.value == val ? head.next : head;
    }

}