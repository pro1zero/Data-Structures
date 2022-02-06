package Hashing;

public class HashTable {
    int key;
    int value;

    public HashTable(int key, int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }

    public class HashMap{
        HashTable[] hashTable;
        int size = 10;

        public HashMap(){
            hashTable = new HashTable[size];
            for(int i = 0; i < size; i++){
                hashTable[i] = null;
            }
        }

        public void put(int key, int value){
            int index = key % size;
            //once the table is full - go into infinite loop.
            while(hashTable[index] != null && hashTable[index].getKey() != key){
                index = (index + 1) % size;
            }
            hashTable[index] = new HashTable(key, value);
        }

        public int get(int key){
            int index = key % size;
            // if the table is full, go in infinite loop again -> we will keep on doing linear probing. 
            while(hashTable[index] != null && hashTable[index].getKey() != key){
                index = (index + 1) % size;
            }
            if(hashTable[index] == null) return -1;
            return hashTable[index].getValue();
        }
    }
}
