
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StorageImpl<E extends Object & Comparable<E> & Serializable> implements IStorage<E> {

    private E[] data;
    private int currentSize;

    public StorageImpl(E[] data) {
        this.data = data;
    }

    public StorageImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    public StorageImpl(Class<E> type, int maxSize) {
        this.data = (E[]) Array.newInstance(type, maxSize);
    }

    @Override
    public void add(E value) {
        add(value, currentSize);
    }

    @Override
    public void add(E value, int index) {
        data[index] = value;
        currentSize++;
    }

    @Override
    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public boolean find(E value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    @Override
    public void sort() {
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                E a = data[j];
                E b = data[j + 1];
                if (a.compareTo(b) > 0) {
                    exchange(j, j + 1);
                }
            }
        }
    }

    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    public void exchange(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public ArrayList exportArr(){
        ArrayList ar = new ArrayList();
        for (int i = 0; i < data.length; i++) {
            ar.add(data[i]);
        }
        return ar;
    }

}