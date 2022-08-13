package data_structures.list;

public final class Node {
    private int data;
    private Node next;

    public Node(int x, Node next){
        data = x;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node){
        next = node;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
