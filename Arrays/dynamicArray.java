package Arrays;

public class dynamicArray{
    //attributes(Variables) to our dynamicArray
    int[] array;
    int length;
    int capacity;
// dynamicArray array = new dynamicARray();
// this(10) -> dynamicArray(int oneARgument)
    public dynamicArray() throws Exception{
        this(10);  //this calls another dynamicArray(with one argument)
    }

    public dynamicArray(int capacity) throws Exception{
        if(capacity < 0) throw new Exception("Length cannot be -ve: " + capacity); //a small check if there no negative size assigned.
        this.capacity = capacity;
        array = new int[capacity];
    }

    // O(1)
    public int size(){
        //our length variable has the actual size of our dynamic array, return length to get the size of the array. 
        //If you're wondering why can't we just return capacity, since it is the current length, well, that's because it would not yield a correct size.
        //capacity can be more than the actual length as we have doubled the capacity at some point, in this case, capacity will always be more than or equal to length.
        return length;
    }

    // O(1)
    public int get(int index) throws Exception{
        if(index < 0 || index >= length) throw new Exception("Length out of bounds: " + length);
        //if index is a valid index, return the value present in the array at position: index.
        return array[index];
    }

    // O(1)
    public void set(int index, int value) throws Exception{
        if(index < 0 || index >= length) throw new Exception("Length out of bounds: " + length);
        //same logic as get(index), but instead of getting a value, we modify the value.
        array[index] = value;
    }

    // O(1)
    public boolean isEmpty(){
        //return true if length == 0. 
        //size() == 0 is essentially length == 0.
        return size() == 0;
    }

    // O(1)
    public void clear(){
        //As I told earlier, we don't care, what's in the array right now, we will reset the length variable to 0 and start to push values again.
        length = 0;
    }

    // O(N)
    public void add(int value){
        //this if will be executed if you remove the this(10) and start adding from 0.
        if(length + 1 >= capacity){
            //if the current index is the last position in your dynamic array, increase the size to 1 if 0 and size * 2 otherwise.
            if(capacity == 0){
                capacity = 1;
            }else{
                capacity *= 2;
            }
            //since we increased the capacity, make a new array with new capacity.
            int[] newArray = new int[capacity];
            for(int i = 0; i < length; i++){
                newArray[i] = array[i];
            }
            //copy the newArray to our current accessible array.
            array = newArray;
        }
        //this will always execute - add the value to array and increment the length counter.
        array[length++] = value;
    }

    // O(N)
    public boolean remove(int valueToRemove) throws Exception{
        //we have the parameter valueToRemove, not the index, we need index, so look for index first.
        for(int i = 0; i < length; i++){
            //if we find the index where the value is, call helper(i) as pass in the index.
            if(array[i] == valueToRemove) return helper(i);
        }
        return false;
    }

    // O(N)
    public boolean helper(int index) throws Exception{
        //check for invalid indices, just in case.
        if(index < 0 || index >= length) throw new Exception("INdex is invalid: " + index);
        //keep track of two indices, i and j, the moment, i matches index, decrement j once. This lag is necessary as it will shift all the elements after -
        //-the removeVAlue's index to left by 1.
        int[] newArray = new int[length - 1];
        //make new array with lower size (length - 1).
        for(int i = 0, j = 0; i < length; i++, j++){
            if(i == index){
                j -= 1;
            }else{
                newArray[j] = array[i];
            }
        }
        //assign the newArray to our own array.
        //decrease length by 1, update the capacity and return true since we were successfully able to remove the value.
        array = newArray;
        length -= 1;
        capacity = length;
        return true;
    }

    // O(N)
    //We want to get the index of a value known to us.
    //simply iterate over all the values until we find the number or hit the end of the array.
    public int getIndex(int value){
        for(int i = 0; i < length; i++){
            if(array[i] == value) return i;
        }
        //we traversed the entire array and didn't find the value, so return -1.
        return -1;
    }

    // O(N)
    //use getIndex(value) to determine if the value is present in the array.
    public boolean contains(int value){
        return getIndex(value) != - 1;
    }

    // O(N)
    //Use stringbuilder instead of a string.
    //somebody asked me why we don't use string and the reason is because strings are immutable.
    //that means, when we do "hello" += "world" (which yields "helloworld"),
    //a new copy of string "helloworld" is created and then it is assigned to the variable EXAMPLE: (stringOne - in this case) --> (stringOne += stringTwo) 
    //stringbuilder however, maintains an array of characters and check if there is any free space to append characters which turns out to be very efficient.
    //string on the other end is very costly as it will consume more space and time to copy and creating new strings. 
    public String toString(){
        if(length == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        //our sb so far --> ""
        sb.append("[");
        //our sb so far --> "["
        for(int i = 0; i < length - 1; i++){
            sb.append(array[i] + ", ");
        }
        //our sb so far --> "[1,2,3, "
        return sb.append(array[length - 1] + "]").toString();
        //our sb.toString() that we return --> "[1, 2, 3, 4]" is the array is {1,2,3,4}
    }
}