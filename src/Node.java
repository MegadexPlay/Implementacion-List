public class Node<T> {
    private T data;
    private Node<T> Next;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return Next;
    }

    public void setNext(Node<T> next) {
        Next = next;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", Next=" + Next + "]";
    }

    
    
}
