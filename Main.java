package Data_Project;

public class Main {
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();

        list.insertAtBack("hello");
        list.insertAtBack("world");
        list.insertAtBack("hello");
        list.insertAtBack("world");

        list.insertAtFront("mhmd");

        list.insertAtPosition(2, "null");
        list.display();

    }
}
