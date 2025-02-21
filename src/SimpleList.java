import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleList<T> implements List<T>{

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
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
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
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
