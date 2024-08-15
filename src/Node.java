
public class Node<T> {
    private T data;
    private Node<T> prev;

    public Node(T data) {
        setData(data);
        setPrev(null);
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return prev;
    }

}
