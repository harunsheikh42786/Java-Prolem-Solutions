package dsa.impl;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    static class Node<T>{
        private T data;
        private Node<T> next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if (front == null && rear == null){
            front = rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void dequeue(){
        if (front == null){
            throw new RuntimeException("Queue is empty");
        }else {
            front = front.next;
            if (front == null) {
                rear = null; // Important: queue becomes empty
            }
        }
    }

    public void print(){
        System.out.print("Queue ");
        if (front == null){
            System.out.println("is empty");
            return;
        }

        System.out.print(": ");

        Node<T> temp = front;

        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue(); // 10
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue(); // 20
        queue.enqueue(50);
        queue.print();
    }
}
