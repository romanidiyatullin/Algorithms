package data_structures.list;

class DoubleNode{

    private int val;
    private DoubleNode next;
    private DoubleNode prev;

    DoubleNode(int value){
        this.val = value;
    }

     int getVal(){
        return val;
    }

    void setVal(int val){
        this.val = val;
    }

     DoubleNode getNext(){
        return next;
    }

     DoubleNode getPrev(){
        return prev;
    }

     void setNext(DoubleNode next){
        this.next = next;
    }

     void setPrev(DoubleNode prev){
        this.prev = prev;
    }

    @Override
    public String toString(){
        return "VAL = " + this.val + " ";
    }
}

public class MyDoubleLinkedList {

    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public void addToEnd(DoubleNode element){
        if(head==null) {
            head = element;
            tail = element;
            size++;
        }
        else{
            DoubleNode lastPreviouslyAddedNode = tail;
            tail = element;
            lastPreviouslyAddedNode.setNext(element);
            element.setPrev(lastPreviouslyAddedNode);
            size++;
        }

    }

    public void addToHead(DoubleNode element){
        if(head==null) {
            head = element;
            tail = element;
            size++;
        }
        else{
            DoubleNode firstNode = head;
            head = element;
            element.setNext(firstNode);
            firstNode.setPrev(element);
            size++;
        }

    }

    public boolean addToIndex(int position, DoubleNode element){
        try {

            if(position==0)
                this.addToHead(element);

            else if(position==getSize()-1)
                this.addToEnd(element);

            else {
                DoubleNode nodeToReplace = this.get(position);
                DoubleNode previosNodeFromNodeToReplace = nodeToReplace.getPrev();
                nodeToReplace.setPrev(element);
                element.setNext(nodeToReplace);
                previosNodeFromNodeToReplace.setNext(element);
            }
        }
        catch (Exception e){
            return false;
        }
        size++;
        return true;
    }

    public DoubleNode get(int position) throws IndexOutOfBoundsException {

        if(position<0 || this.getSize()<position)
            throw new IndexOutOfBoundsException("EXCEPTION: Incorrect index!");

        int currentPosition = 0;
        DoubleNode currentNode = head;

        while(currentPosition!=position && currentNode!=null){
            currentNode = currentNode.getNext();
            currentPosition++;
        }
        if(currentNode == null) throw new IndexOutOfBoundsException("EXCEPTION: No such index!");
        return currentNode;
    }

    public DoubleNode remove(int position){
        DoubleNode nodeToRemove = this.get(position);
        nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
        size--;
        return nodeToRemove;
    }

    @Override
    public String toString(){
        DoubleNode walker = head;
        StringBuilder sb = new StringBuilder();
        while(walker!=null){
            sb.append(walker);
            walker = walker.getNext();
        }
        return sb.toString();
    }

    public int getSize(){
        return size;
    }

    public DoubleNode getHead(){
        return head;
    }

    public DoubleNode getTail(){
        return tail;
    }

    public static void main(String[] args) {
        DoubleNode d1 = new DoubleNode(1);
        DoubleNode d2 = new DoubleNode(2);
        DoubleNode d3 = new DoubleNode(3);
        MyDoubleLinkedList list = new MyDoubleLinkedList();

        // d1 -> d2 ->d3
        // 3
        list.addToEnd(d2);
        list.addToEnd(d3);
        list.addToHead(d1);
        System.out.println(list);
        System.out.println(list.getSize());


        // d1 -> d4 -> d2 ->d3   4
        DoubleNode d4 = new DoubleNode(4);
        System.out.println(list.addToIndex(1, d4));
        System.out.println(list);
        System.out.println(list.getSize());

        // d1 -> d4 ->d3   3
        System.out.println(list.remove(2));
        System.out.println(list);
        System.out.println(list.getSize());

        // d2
        System.out.println(list.get(2));

        // d1
        System.out.println("HEAD IS " + list.getHead());

        // d3
        System.out.println("TAIL IS " + list.getTail());

    }
}




