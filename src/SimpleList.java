import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleList<T> implements List<T> {

    private Node<T> head;

    public SimpleList() {
        head = null;
    }

    @Override
    public int size() {
        Node<T> aux = head;
        int count = 0;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head != null;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> aux = head;
        while (aux != null) {
            if (aux.getData().equals(o)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            Node<T> auxNode = head;

            @Override
            public boolean hasNext() {
                return auxNode != null;
            }

            @Override
            public T next() {
                T data = auxNode.getData();
                auxNode = auxNode.getNext();
                return data;
            }
        };

        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node<T> aux = head;
        for (int i = 0; i < size(); i++) {
            array[i] = aux.getData();
            aux = aux.getNext();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= this.size()) {
            Node<T> auxNode = (Node<T>) head;
            for (int j = 0; j < this.size(); j++) {
                a[j] = (auxNode.getData());
                auxNode = auxNode.getNext();
            }
            return a;
        } else {
            T[] tempArray = null;
            Node<T> auxNode = (Node<T>) head;
            for (int j = 0; j < a.length; j++) {
                tempArray[j] = (auxNode.getData());
                auxNode = auxNode.getNext();
            }
            return tempArray;
        }
    }

    @Override
    public boolean add(Object e) {
        Node<T> newNode = new Node<>((T) e);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean objectFound = true;
        while (objectFound != false) {
            Iterator colectionIterator = c.iterator();
            while (colectionIterator.hasNext()) {
                objectFound = this.contains(colectionIterator.next());
            }
        }
        return objectFound;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        boolean add = false;
        for (T t : c) {
            if (add(t)) {
                add = true;
            }
        }
        return add;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean result = false;
        if (c.isEmpty() == true || index > size() || index < 0) {
            result = false;
        }
        if (index == 0) {
            addAll(c);
            result = true;
        } else if (index > 0) {
            Node<T> temp = head;
            Node<T> nextTemp = null;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            nextTemp = temp.getNext();
            for (T element : c) {
                Node<T> aux = new Node<T>(element);
                temp.setNext(aux);
                temp = temp.getNext();
            }
            temp.setNext(nextTemp);
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean modified = false;
        Iterator colectionIterator = c.iterator();
        while (colectionIterator.hasNext()) {
            Object auxObject = colectionIterator.next();
            if (this.contains(auxObject)) {
                this.remove(auxObject);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean modified = false;
        while (head != null && !c.contains(head.getData())) {
            head = head.getNext();
            modified = true;
        }

        if (head == null)
            return modified;

        Node<T> current = head;
        while (current.getNext() != null) {
            if (!c.contains(current.getNext().getData())) {
                current.setNext(current.getNext().getNext());
                modified = true;
            } else {
                current = current.getNext();
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public T get(int index) {
        Node<T> aux = head;
        T data = null;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                data = aux.getData();
            } else {
                aux = aux.getNext();
            }
        }
        return data;
    }

    @Override
    public T set(int index, T element) {
        T originalObject = null;
        for (int i = 0; i <= index; i++) {
            Node<T> aux = head;
            if (i == index) {
                originalObject = aux.getData();
                aux.setData(element);
            }
            aux = aux.getNext();
        }
        return originalObject;
    }

    @Override
    public void add(int index, Object element) {
        Node<T> newNode = new Node<>((T) element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            return;
        }
        Node<T> aux = head;
        for (int i = 0; i < index - 1; i++) {
            aux = aux.getNext();
        }
        newNode.setNext(aux.getNext());
        aux.setNext(newNode);
    }

    @Override
    public T remove(int index) {
        Node<T> aux = head;
        Node<T> nodeToSend = head;
        if (index == 0) {
            head = head.getNext();
        } else {
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            nodeToSend = aux.getNext();
            aux.setNext(aux.getNext().getNext());

        }
        return nodeToSend.getData();
    }

    @Override
    public int indexOf(Object o) {
        int result = 0;
        Node<T> aux = head;

        while (aux != null) {
            if (aux.getData().equals(o)) {
                return result;
            }
            aux = aux.getNext();
            result++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        List<T> finalList = new ArrayList<>();
        for (int i = 0; i <= toIndex; i++) {
            Node<T> aux = head;
            if (i >= fromIndex) {
                finalList.add(aux.getData());
            }
            aux = aux.getNext();
        }
        return finalList;
    }

}
