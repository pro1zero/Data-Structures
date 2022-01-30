package Queues;

//Generics

public class Queue {
    int[] queue;

    int capacity;
    int index = 0;

    public Queue(int capacity) throws Exception{
        if(capacity <= 0) throw new Exception("");
        this.capacity = capacity;
        queue = new int[this.capacity];
    }

    public Queue() {
    }

    public boolean isEmpty(){
        return index == 0;
    }

    // O(1)
    public void enqueue(int value) throws Exception{
        if(index == queue.length) throw new Exception("");
        queue[index] = value;
        index += 1;
    }

    // O(N)
    public int dequeue() throws Exception{
        if(index == 0) throw new Exception("");
        int poppedElement = queue[0];
        for(int i = 0; i < queue.length - 1; i++){ // O(N - 1) => O(N)
            queue[i] = queue[i + 1]; // [1,2,3,4] -> [2,3,4,4]
        }
        index -= 1;
        return poppedElement;
    }
}
