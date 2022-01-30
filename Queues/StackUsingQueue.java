package Queues;

public class StackUsingQueue {
    Queue queue1 = new Queue();
    Queue queue2 = new Queue();

    int size;
    int topElement;

    public StackUsingQueue(int size){
        this.size = size;
    }

    // Time: O(N) | O(N)
    public void push(int value) throws Exception{
        queue2.enqueue(value);
        while(!queue1.isEmpty()){
            queue2.enqueue(queue1.dequeue());
        }
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = new Queue();
        size += 1;
    }

    // O(1)
    public int pop() throws Exception{
        if(queue1.isEmpty()){
            // throw
        }
        return queue1.dequeue();
    }
}
