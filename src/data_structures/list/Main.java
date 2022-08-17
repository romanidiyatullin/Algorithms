package data_structures.list;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.print();
        System.out.println("Current list size is: " + list.getSize());
        System.out.println("Did we removed existing element 10? " + list.remove(10));
        System.out.println("Element 10 (oldest) was removed");
        System.out.println("Current list size is: " + list.getSize());
        list.print();
        list.remove(50);
        System.out.println("Element 50 (latest) was removed");
        System.out.println("Current list size is: " + list.getSize());
        list.print();
        list.remove(30);
        System.out.println("Element 30 (middle) was removed");
        System.out.println("Current list size is: " + list.getSize());
        list.print();
        list.remove(20);
        list.remove(40);
        System.out.println("All elements were removed");
        System.out.println("Current list size is: " + list.getSize());
        list.print();
        System.out.println("Attempt to remove non-existing element 40: " + list.remove(40));
        System.out.println("Current list size is: " + list.getSize());
        list.print();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        System.out.println("Check if method isExist for existing element will return true: "+ list.isExist(100));
        System.out.println("Check if method isExist for non-existing element will return false: "+ list.isExist(10));
        System.out.println("BEFORE REVERSE:");
        list.print();
        list.reverse();
        System.out.println("AFTER REVERSE:");
        list.print();
        list.add(500);
        System.out.println("After element 500 was added:");
        list.print();
    }
}
