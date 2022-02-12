package Heap;

public class heapConstruction {
    int[] heap;
    int size;
    int maxSize;

    public heapConstruction(int maxSize){
        size = 1;
        this.maxSize = maxSize;
        heap = new int[this.maxSize];
    }

    public int getParent(int index){
        return (index - 1) / 2;
    }

    public int getLeftChild(int index){
        return (2 * index);
    }

    public int getRightChild(int index){
        return (2 * index) + 1;
    }

    public boolean isLeafNode(int index){
        return (index > size / 2) && (index <= size);
    }

    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value){
        heap[size] = value;
        int currentIndex = size;
        while(heap[currentIndex] > heap[getParent(currentIndex)]){
            swap(currentIndex, getParent(currentIndex));
            currentIndex = getParent(currentIndex);
        }
        size += 1;
    }

    public int remove(){
        int maxElement = heap[1];
        heap[1] = heap[size];
        heapify(1);
        size -= 1;
        return maxElement;
    }

    public void heapify(int index){
        if(isLeafNode(index)) return;
        while(heap[index] < heap[getLeftChild(index)] || heap[index] < heap[getRightChild(index)]){
            if(heap[getLeftChild(index)] >= heap[getRightChild(index)]){
                swap(index, getLeftChild(index));
                heapify(getLeftChild(index));
            }else{
                swap(index, getRightChild(index));
                heapify(getRightChild(index));
            }
        }
    }
}
