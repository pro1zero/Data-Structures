package Stacks;
import java.util.*;
public class StackConstruction{

    List<Integer> stack;
    int top;
    int size; 

    public StackConstruction(int size){
        this.size = size;
        top = -1;
        stack = new ArrayList<>(size);
    }

    public void push(int value) throws Exception{
        if(top + 1 >= size) throw new Exception("Stack OVerflow: " + top);
        else{
            top += 1;
            if(stack.size() > top){
                stack.set(top, value);
            }else{
                stack.add(value);
            }
        }
    }

    public int pop() throws Exception{
        if(top == -1) throw new Exception("STack underflow" + top);
        else{
            top -= 1;
        }
        return stack.get(top + 1);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int peek() throws Exception{
        if(top == -1) throw new Exception("STack underflow" + top);
        return stack.get(top);
    }

    public static void main(String[] args) {
        
    }
}