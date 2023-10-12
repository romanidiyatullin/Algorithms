package algorithms.interview.generic;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }

    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
    public String toString(){
        return " " + this.val;
    }
}

public class ReverseList {

    public static Node reverseNode(Node head){

        if(head == null)
            return null;

        if(head.next==null)
            return head;

        Node a = head;
        Node b = head.next;
        Node c;

        while(b.next!=null){
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        b.next=a;
        head.next=null;
        head = b;

        return head;

    }

    public static String printAllNodes(Node node){
        StringBuilder sb = new StringBuilder();
        while(node!=null){
            System.out.println(node.val);
            sb.append(node.val);
            sb.append('\n');
            node = node.next;
        }
        return sb.toString();
    }

    public static Node createNodes(int howMany){
        Node head = new Node(0);
        Node node = head;
        for(int i = 1; i <howMany; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        return  head;
    }

    public static void main(String[] args) {

        for(int i=1; i<5; i++){
            System.out.println("Before reverse:");
            Node node = createNodes(i);
            printAllNodes(node);
            System.out.println("After reverse:");
            printAllNodes(ReverseList.reverseNode(node));
        }
    }
}
