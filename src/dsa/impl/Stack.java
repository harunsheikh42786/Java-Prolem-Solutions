package dsa.impl;

public class Stack<T> {

    private Node<T> top;

    static class Node<T>{
        private T data;
        private Node<T> prev;
        Node(T data){
            this.data = data;
            this.prev = null;
        }
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if (top == null){
            top = newNode;
        }else {
            newNode.prev = top;
            top = newNode;
        }
    }

    public void pop(){
        if (top.prev == null) top = null;
        else top = top.prev;
    }

    public void print(){
        Node<T> temp = top;
        System.out.print("Stack ");
        if (top == null){
            System.out.println("is null.");
        }
        System.out.print(": ");
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(20);
        stack.add(40);
        stack.pop();
        stack.add(30);
        stack.add(50);
        stack.pop();
        stack.add(40);
        stack.add(50);
        stack.print();
    }

}
