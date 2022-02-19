package Trees;

public class BST {
    class Node{
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
        }
    }

    Node root;

    public BST(){
        root = null;
    }

    public void insert(int value){
        root = insertHelper(root, value);
    }

    // ideally complexity is O(logn) || incase of a left or right skewed tree -> O(N)
    public Node insertHelper(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(value < root.value){
            root.left = insertHelper(root.left, value);
        }else if(value > root.value){
            root.right = insertHelper(root.right, value);
        }
        return root;
    }

    public void remove(int valueToRemove){
        root = removeHelper(root, valueToRemove);
    }

    public Node removeHelper(Node root, int value){
        if(root == null) return root;
        if(value < root.value){
            root.left = removeHelper(root.left, value);
        }else if(value > root.value){
            root.right = removeHelper(root.right, value);
        }else{
            //that means we found the value to remove
            //line 49 and 50 took care of leaf nodes and nodes with one child..
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            //at Node -> 2 chilldren
            root.value = minValue(root.right);//10 -> 11
            root.right = removeHelper(root.right, root.value); //remove 11
        }
        return root;
    }

    public int minValue(Node root){
        int min = 0;
        while(root != null){
            min = root.value;
            root = root.left;
        }
        return min;
    }

    public boolean search(int value){
        return helperSearch(root, value);
    }

    public boolean helperSearch(Node root, int value){
        if(root != null){
            if(value < root.value){
                helperSearch(root.left, value);
            }else if(value > root.value){
                helperSearch(root.right, value);
            }else return true;
        }
        return false;
    }

    public void inOrderTraversal(){
        inOrder(root);
    }

    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.value + "-->");
            inOrder(root.right);
        }
    }

    public void preOrderTraversal(){
        preOrder(root);
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.value + "-->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + "-->");
        }
    }

}
