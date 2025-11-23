package dsa.impl;

public class HashDS<K,V> {
    private int size;
    private Node<K,V> [] hashTable;

    HashDS(int hashTableSize){
        this.size = hashTableSize;
        this.hashTable = new Node[size];
    }

    static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next;
        Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public boolean exist(K key, V value){
        int hashIndex = hashFunction(key);
        Node<K,V> temp = hashTable[hashIndex];

        while(temp != null){
            if(temp.key.equals(key)) return true;
            temp = temp.next;
        }
        return false;
    }

    private int hashFunction(K key){
        return Math.abs(key.hashCode() % size);
    }

    public void add(K key, V value){
        if (exist(key, value)){
            System.out.println("Duplicate key = " + key + " provided.");
            return;
        }

        int hashIndex = hashFunction(key);
        Node<K,V> newNode = new Node<>(key, value);

        if(hashTable[hashIndex] == null){
            hashTable[hashIndex] = newNode;
        } else {
            Node<K,V> temp = hashTable[hashIndex];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void remove(K key){
        int hashIndex = hashFunction(key);

        Node<K,V> head = hashTable[hashIndex];

        if(head == null){
            System.out.println("Key doesn't exist");
            return;
        }

        // Case 1: key is in head
        if(head.key.equals(key)){
            hashTable[hashIndex] = head.next;  // remove head
            return;
        }

        // Case 2: key inside the chain (not head)
        Node<K,V> prev = null;
        Node<K,V> curr = head;

        while(curr != null && !curr.key.equals(key)){
            prev = curr;
            curr = curr.next;
        }

        if(curr == null){
            System.out.println("Key doesn't exist");
            return;
        }

        // Remove the node
        prev.next = curr.next;
    }


    public void print(){
        for (int i=0; i<size; i++) {
            System.out.print(i + " : ");
            if (hashTable[i] == null){
                System.out.print("Null");
            } else {
                Node<K, V> currentNode = hashTable[i];
                while (currentNode != null) {
                    System.out.print("(" + currentNode.key + "," + currentNode.value + "), ");
                    currentNode = currentNode.next;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String [] keys = {"Apple", "Banana","Pineapple","Grapes","Apple"};
        String [] values = {"10", "20","30","40","15"};

        HashDS<String, String> hashDS = new HashDS<>(10);
        for (int i = 0; i < 4; i++) {
            hashDS.add(keys[i], values[i]);
        }
        hashDS.print();
        hashDS.remove("Apple");
        hashDS.print();

        System.out.println(hashDS.exist(keys[3], values[3]));
    }
}
