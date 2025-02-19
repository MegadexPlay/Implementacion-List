import java.util.Iterator;

public class NumberSimpleList<T> implements Iterable<T> {

    private Node<T> head;

    public NumberSimpleList() {
        head = null;
    }

    public void insert(T data){
        Node<T> auxNode = head;
        if (auxNode == null){
            head = new Node<T>(data);
        }else{
            while (auxNode != null) {
                if (auxNode.getNext() == null) {
                    auxNode.setNext(new Node<T>(data));
                    auxNode = null;
                }else{
                    auxNode = auxNode.getNext();
                }
            }
        }
    }

    public Boolean exist(T data){
        Node<T> auxNode = head;
        boolean exist = false;
        while (auxNode != null && exist == false) {
            if (auxNode.getNext() == null) {
                exist = auxNode.getData() == data ? true:false;
                auxNode = null;
            }else{
                exist = auxNode.getData() == data ? true:false;
                auxNode = auxNode.getNext();
            }
        }
        return exist;
    }

    public Boolean exist2(T data){
        Node<T> auxNode = head;
        boolean exist = false;
        while (auxNode.getNext() != null && exist == false) {
            exist = auxNode.getData() == data ? true:false;
            auxNode = auxNode.getNext();
        }
        return exist;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public String Show(){
        Node<T> auxNode = head;
        String listString = "";
        while (auxNode != null) {
            if (auxNode.getNext() == null) {
                listString += auxNode.getData();
                auxNode = null;
            }else{
                listString += auxNode.getData() + "-";
                auxNode = auxNode.getNext();
            }
        }
        return listString;
    }

    @Override
    public Iterator<T> iterator() {
        
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
}
