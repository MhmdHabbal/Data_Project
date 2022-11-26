package Data_Project;

public class Node<T> {
    
    T data;
    Node<T> next;

    Node() {
        next = null;
    }

    Node(T data) {
        this.data = data;
    }
}
