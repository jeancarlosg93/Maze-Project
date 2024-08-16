public class Queue<T> {
    private int front;
    private int rear;
    private int size;
    public Queue() {
        front = 0;
        rear = 0;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == size;
    }
    public void enqueue(Object obj) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        size++;
        front = rear;

    }
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Object obj = front;
        front = front + 1;
        size--;
        return obj;
    }
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return front;
    }

}
