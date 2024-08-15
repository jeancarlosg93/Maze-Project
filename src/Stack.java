public class Stack<T> {
    Node<T> head;
    int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setPrev(head);
        head = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T item = head.getData();
        head = head.getPrev();
        size--;
        return item;
    }

    public T peek() {
        return isEmpty() ? null : head.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


}

