package dsa.impl;

public class LinkedList<T> implements List<T>{

    private int size = 0;
    private Node<T> head;
    private Node<T> end;

    LinkedList() {
        this.head = null;
        this.end = null;
    }

//    LinkedList(int size) {
//        this.size = size;
//        this.head = null;
//        this.end = null;
//    }

    static class Node<T>{
        private T data;
        private Node<T> prev, next;
        Node(T data){
            this.data = data;
            this.next = prev = null;
        }
    }


    @Override
    public int size(){
        return this.size;
    }

    @Override
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            end = newNode;
        }
        else {
            newNode.prev = end;
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    @Override
    public void remove(T data) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node<T> temp = head;

        // Search for node with matching data
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.next;
        }

        // Not found
        if (temp == null) {
            System.out.println("Data not found");
            return;
        }

        // --- CASE 1: Removing HEAD ---
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else end = null;     // List becomes empty
        }

        // --- CASE 2: Removing END ---
        else if (temp == end) {
            end = end.prev;
            end.next = null;
        }

        // --- CASE 3: Removing MIDDLE NODE ---
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        size--;
    }


    @Override
    public boolean contains(T data) {
        if (head == null) System.out.print("List is null.");
        else {
            Node<T> temp = head;
            while (!temp.data.equals(data) && temp.next != null) {
                temp = temp.next;
            }
            return (temp.data.equals(data));
        }
        return false;
    }

    @Override
    public T get(int index){
        if (head == null)
            throw new RuntimeException("List is null.");
        else if (index < 0 || index >= size) {
            throw new RuntimeException("Index is out of bond, Index is : " + index + ", but Size : " + size);
        } else if (index == 0) {
            return head.data;
        } else{
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next; // 1
            }
            return temp.data;
        }
    }

    public void print(){
        Node<T> temp = head;
        System.out.print("LinkedList : ");
        while(temp != null){
            System.out.print(temp.data+", ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(40);
        list.add(20);
        list.print();
        list.remove(40);
        list.print();
        boolean isContains  = list.contains(40);
        System.out.println(isContains? "Present" : "Not present");
        list.add(30);
        list.add(40);
        list.print();
        int data = list.get(2);
        System.out.println("Index : "+2 +", Data : "+data);
        final int size = list.size();
        System.out.println("Size : "+size);
//        list.get(40);
//        list.get(-4);
    }



}
