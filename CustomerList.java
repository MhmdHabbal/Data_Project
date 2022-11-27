package Data_Project;

public class CustomerList<T> {
    
    public Node<T> first;
    public int size;

    private int i, i_total, j;

    CustomerList() {
        first = null;
        size = 0;
        i = 0;
        i_total = 0;
        j = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertAtBack(T d) {

        Node<T> node = new Node<>(d);

        if(isEmpty()) {
            first = node;
        }

        else {
            Node<T> current = first;

            while(current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        size++;
    }

    public T removeFromFront() {

        if(!isEmpty()) {

            T d = first.data;
            first = first.next;
            return d;

        }

        size--;

        return null;
    }

    public Node<T> removeSpecificNode(T d) {

        Node<T> current = first, prev = first;
        
        if(isEmpty()) {
            return null;
        }

        if(current != null && current.data.equals(d)) {

            first = first.next;

            return current;
        }

        while(current != null && !current.data.equals(d)) {

            i++;
            prev = current;
            current = current.next;

            if(i != 0) {
                i_total++;
            }
        }

        if(current == null) {
            return null;
        }

        prev.next = current.next;

        j = i_total;

        return current;

    }

    public double removeSpecific_PriceNode(CustomerList<Double> price) {

        Node<Double> current = price.first;
        Node<Double> prev = price.first;
        
        if(price.isEmpty()) {
            return -1;
        }

        if(j == 0) {
            price.first = price.first.next;

            return current.data;
        }

        else {

            for(int i = 0; i < j; i++) {

                prev = current;
                current = current.next;

            }

            prev.next = current.next;
        }

        i = 0;
        i_total = 0;
        j = 0;

        return current.data;
    }

    public boolean search(String d) {

        Node<T> current = first;

        while(current != null) {
            
            if(current.data.equals(d)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void display(CustomerList<Double> priceList) {

        Node<T> current = first;
        Node<Double> currentList = priceList.first;

        while(current != null) {

            System.out.println(" " + current.data);

            if(currentList != null) {

                System.out.println("Price: $" + currentList.data);

                currentList = currentList.next;
            }
            
            System.out.println();
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T customer) {

        insertAtBack(customer);
    }

    public T dequeue() {
        
        return removeFromFront();
    }

}
