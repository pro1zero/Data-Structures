package assignment3;

public class AVL {
	class Node{
		public Node(int value2) {
			// TODO Auto-generated constructor stub
		}
		int value;
		int height;
		Node left;
		Node right;
	}
	
	Node root;
	
	public int getHeight(Node node) {
		return node == null ? -1 : node.height;
	}
	
	public void updateHeight(Node node) {
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	public int getBalance(Node node) {
		return node == null ? 0 : getHeight(node.right) - getHeight(node.left);
	}
	
	public Node rotateRight(Node y) {
		Node x = y.left;
		Node z = x.right;
		x.right = y;
		y.left = z;
		//order matters as x is the root now. see definition of updateHeight().
		updateHeight(y);
		updateHeight(x);
		//return new root;
		return x;
	}
	
	public Node rotateLeft(Node y) {
		Node x = y.right;
		Node z = x.left;
		x.left = y;
		y.right = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}
	
	public Node rebalance(Node z) {
		updateHeight(z);
		int balance = getBalance(z);
		if(balance > 1) {
			if(getHeight(z.right.right) > getHeight(z.right.left)) {
				z = rotateLeft(z);
			}else {
				z.right = rotateRight(z.right);
				z = rotateLeft(z);
			}
		}else if(balance < -1) {
			if(getHeight(z.left.left) > getHeight(z.left.right)) {
				z = rotateRight(z);
			}else {
				z.left = rotateLeft(z.left);
				z = rotateRight(z);
			}
		}
		return z;
	}
	
	public Node insert(Node node, int value) {
		if (node == null) {
	        return new Node(value);
	    } else if (node.value > value) {
	        node.left = insert(node.left, value);
	    } else if (node.value < value) {
	        node.right = insert(node.right, value);
	    }
		return rebalance(node);
	}
	
	Node delete(Node node, int value) {
	    if (node == null) {
	        return node;
	    } else if (node.value > value) {
	        node.left = delete(node.left, value);
	    } else if (node.value < value) {
	        node.right = delete(node.right, value);
	    } else {
	        if (node.left == null || node.right == null) {
	            node = (node.left == null) ? node.right : node.left;
	        } else {
	            Node mostLeftChild = minValue(node.right);
	            node.value = mostLeftChild.value;
	            node.right = delete(node.right, node.value);
	        }
	    }
	    if (node != null) {
	        node = rebalance(node);
	    }
	    return node;
	}
	
	public Node minValue(Node root) { //inorder successor
		Node minValue = null;
		while(root != null) {
			minValue = root;
			root = root.left;
		}
		return minValue;
	}
	
	public boolean contains(int value) {
		return helperContains(root, value);
	}
	
	public boolean helperContains(Node root, int value) {
		while(root != null) {
			if(value < root.value) {
				helperContains(root.left, value);
			}else if(value > root.value) {
				helperContains(root.right, value);
			}else return true;
		}
		return false;
	}
}
