package data_structures.list;

public final class MyList {

    private Node head;

    public MyList() {
        head = null;
    }

    public void add(int element) {
        Node previous;
        if (head == null) previous = null;
        else previous = head;
        head = new Node(element, previous);
    }

    public boolean remove(int element) {
        Node currentNode = head;
        Node previousNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == element) {
                previousNode.setNext(currentNode.getNext());
                if (currentNode==head)
                    head = currentNode.getNext();
                return true;
            } else {
                previousNode = currentNode;
                currentNode  = currentNode.getNext();
            }
        }
        return false;
    }

    public boolean isExist(int element) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == element) {
                return true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    public int size(){
        Node currentNode = head;
        int size = 0;
        while(currentNode!=null) {
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.getNext();
        }
    }
}