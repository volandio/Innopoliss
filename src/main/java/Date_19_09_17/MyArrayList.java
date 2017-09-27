package Date_19_09_17;

import static java.lang.System.arraycopy;

public class MyArrayList<V> {
    private V[] elements;
    private int size;

    MyArrayList(int i) {
        elements = (V[]) new Object[i];
    }

    MyArrayList() {
        this(10);
    }

    private void increaseSizeArray() {
        if (elements.length == size) {
            V[] array2 = (V[]) new Object[size * 3 / 2];
            System.arraycopy(elements, 0, array2, 0, size);
            elements = array2;
        }
    }

    public void checkThrowArrayIndexOutOfBoundsException(int i) {
        if (i > size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
        }
    }

    public boolean add(V e) {
        increaseSizeArray();
        elements[size++] = e;
        return true;
    }

    public void add(int i, V e) {
        checkThrowArrayIndexOutOfBoundsException(i);
        increaseSizeArray();
        arraycopy(elements, i, elements, i + 1, size - i);
        elements[i] = e;
        size++;
    }

    public V set(int i, V e) {
        checkThrowArrayIndexOutOfBoundsException(i);
        V prev = elements[i];
        elements[i] = e;
        return prev;
    }

    public V get(int i) {
        checkThrowArrayIndexOutOfBoundsException(i);
        return elements[i];
    }

    public V remove(int i) {
        checkThrowArrayIndexOutOfBoundsException(i);
        V removedElement = elements[i];
        arraycopy(elements, i + 1, elements, i, size - 1 - i);
        elements[--size] = null;
        return removedElement;
    }

    public boolean remove(Object e) {
        int removedElement = indexOf(e);
        if (removedElement == -1) {
            return false;
        }
        remove(removedElement);
        return true;
    }

    public int indexOf(Object e) {
        if (e == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (e.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }
}
