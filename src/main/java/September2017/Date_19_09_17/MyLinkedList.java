package September2017.Date_19_09_17;

public class MyLinkedList<V> {
    private int size;
    private Element<V> first;
    private Element<V> last;

    public MyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(V val) {
        Element<V> l = last;
        Element<V> newElement = new Element<>(last, null, val);
        last = newElement;
        if (l == null) {
            first = newElement;
        } else {
            l.next = newElement;
        }
        size++;
        return true;
    }

    private Element<V> findElement(int i) {
        if (i >= size || size < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i < size / 2) {
            Element<V> currentElement = first;
            for (int j = 0; j < i; j++) {
                currentElement = currentElement.next;
            }
            return currentElement;
        } else {
            Element<V> currentElement = last;
            for (int j = size - 1; j > i; j--) {
                currentElement = currentElement.prev;
            }
            return currentElement;
        }
    }

    public void add(int index, V element) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        }
        Element<V> currentElement = findElement(index);
        Element<V> previousElement = currentElement.prev;
        Element<V> addedElement = new Element<>(previousElement, currentElement, element);
        currentElement.prev = addedElement;
        if (previousElement == null) {
            first = addedElement;
        } else {
            previousElement.next = addedElement;
        }
        size++;
    }

    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        for (Element<V> removed = first; removed != null; removed = removed.next) {
            if (o == null && removed.val == null || o.equals(removed.val)) {
                Element<V> previousElement = removed.prev;
                Element<V> next = removed.next;
                previousElement.next = next;
                next.prev = previousElement;
                size--;
                return true;
            }
        }
        return false;
    }

    public V remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Element<V> currentElement = findElement(index);
        V element = currentElement.val;
        Element<V> previousElement = currentElement.prev;
        Element<V> nextElement = currentElement.next;
        if (previousElement == null) {
            first = nextElement;
        } else {
            previousElement.next = nextElement;
            currentElement.prev = null;
        }
        if (nextElement == null) {
            last = previousElement;
        } else {
            nextElement.prev = previousElement;
            currentElement.next = null;
        }
        currentElement.val = null;
        size--;
        return element;
    }

    public V get(int index) {
        Element<V> currentElement = findElement(index);
        return currentElement.val;
    }

    void linkBefore(V e, Element<V> succ) {
        final Element<V> pred = succ.prev;
        final Element<V> newNode = new Element<V>(pred, succ, e);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    private static class Element<V> {
        Element<V> prev;
        Element<V> next;
        V val;

        Element(Element<V> prev, Element<V> next, V val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }
}
