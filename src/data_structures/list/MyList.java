package data_structures.list;

public final class MyList {
    private Node head;
    private int size;

    public MyList() {
        head = null;
    }

    public void add(int element) {
        Node previous;
        if (head == null) previous = null;
        else previous = head;
        head = new Node(element, previous);
        size++;
    }

    public boolean remove(int element) {
        Node currentNode = head;
        Node previousNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == element) {
                if (currentNode == head) {
                    head = currentNode.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }
                currentNode.setNext(null);
                size--;
                return true;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
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

    public int getSize() {
        return size;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.getNext();
        }
    }

    public void reverse() {

        Node previousNode = null;
        Node currentNode = head;
        Node nextNode;

        while(currentNode!=null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head = previousNode;
    }
}