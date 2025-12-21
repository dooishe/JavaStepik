package com.elmir.question_1;

public abstract class CustomList<T> {
    public abstract int size();

    public abstract void add(T value);

    public abstract void set(int index, T value);

    public abstract T get(int index);
}
