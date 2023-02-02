public class MyLinkedList <T>{
    private Node<T> root;
    private int countNode;

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(4);
        myLinkedList.add(9);
        myLinkedList.add(7);
        myLinkedList.add(8);
        myLinkedList.remove(6);
        int test0 = myLinkedList.getNode(3);
        boolean test2 = myLinkedList.contains(4);
        System.out.println(test0);
        System.out.println(test2);
    }

    public void add(T obj) {
        if (countNode == 0) {
            root = new Node<T>(obj);
        } else {
            Node<T> current = root;
            for (int i = 0; i < countNode - 1; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(obj);
            current.setNext(newNode);
        }
        countNode++;
    }
    public void remove(int a) {
        Node<T> previous = root;
        Node<T> current = root.getNext();
        Node<T> next = current.getNext();
        if (a < countNode) {
            if (a == 1) {
                root = current;
            } else {
                for (int i = 0; i < a - 2; i++) {
                    previous = previous.getNext();
                    current = current.getNext();
                    next = next.getNext();
                }
                previous.setNext(next);
            }
            countNode--;
        }
    }
    public int size() {
       return countNode;
    }
    public void clear() {
        root = null;
        countNode = 0;
    }
    public T getNode(int a) {
        Node<T> current = root;
        for (int i = 0; i < a - 1; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
    public boolean contains(T obj) {
        Node<T> current = root;
        for(int i = 0; i < countNode - 1; i++) {
            if(current.getData().equals(obj)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    public void revers() {

    }
}
class Node <T> {
    private T data;
    private Node<T> next;
    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
