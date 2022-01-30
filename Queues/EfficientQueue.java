package Queues;

public class EfficientQueue {
    int[] queue;
    int capacity;
    int front;
    int rear;
    int size;

    public EfficientQueue(int capacity) throws Exception{
        if(capacity <= 0) throw new Exception("");
        this.capacity = capacity;
        queue = new int[this.capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // O(1)
    public void enqueue(int value){
        rear += 1;
        if(front > rear || rear == capacity){
            if(front == 0) return;
            rear = 0;
        }
        queue[rear] = value;
        size += 1;
    }

    // O(1)
    public int dequeue() throws Exception{
        if(isEmpty() || front > rear) throw new Exception();
        int poppedElement;
        front += 1;
        if(front == capacity - 1){
            poppedElement = queue[front - 1];
            front = 0;
        } else poppedElement = queue[front - 1];
        size -= 1;
        return poppedElement;
    }

}
