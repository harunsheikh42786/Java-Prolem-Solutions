package dsa.impl;

public interface List<T> {
    int size();
    void add(T data);
    void remove(T data);
    T get(int index);
    boolean contains(T data);
}
