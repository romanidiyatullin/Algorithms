package data_structures.list.performance;

import java.util.*;

public class TestListCollections {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> stack = new Stack<>();

        System.out.println(getElapsedTime(arrayList));
        System.out.println("now linked list:");
        System.out.println(getElapsedTime(linkedList));
        System.out.println("now stack:");
        System.out.println(getElapsedTime(stack));
    }

    public static Map<String, Long> getElapsedTime(List<Integer> list){
        long startTime =0;
        long endTime  = 0;
        Map<String, Long> resultMap = new HashMap<>();

        // Test 1: Populate with elements:
        startTime = System.currentTimeMillis();
        for(int i=0; i< 100000; i++)
            list.add(i);
        endTime = System.currentTimeMillis();
        resultMap.put("POPULATION TOOK:", endTime-startTime);

        // Test 2: Get each element (GET EACH ELEMENT)
        startTime = System.currentTimeMillis();
        for(int i=0; i< 100000; i++)
            list.get(i);
        endTime = System.currentTimeMillis();
        resultMap.put("GET EACH ELEMENT TOOK:", endTime-startTime);

        // Test 3: Insert elements (add(int position, Element element))
        startTime = System.currentTimeMillis();
        for (int i=0; i<10000; i++)
            list.add(0, 999);
        endTime = System.currentTimeMillis();
        resultMap.put("INSERT EACH AT FIRST POSITION TOOK:", endTime-startTime);

        // Test 4: Find element (SEARCH)
        startTime = System.currentTimeMillis();
        for (int i=0; i<10000; i++)
            list.contains(i);
        endTime = System.currentTimeMillis();
        resultMap.put("CONTAINS FOR EACH ELEMENT TOOK:", endTime-startTime);

        // Test 5: Walk through (TRAVERSE)
        startTime = System.currentTimeMillis();
        for(Integer i:list){
            ;
        }
        endTime = System.currentTimeMillis();
        resultMap.put("TRAVERSE TOOK:", endTime-startTime);

        // Test 6: Delete elements (REMOVE) all except one last:
        startTime = System.currentTimeMillis();
        for (int i=0; i<9999; i++)
            list.remove(i);
        endTime = System.currentTimeMillis();
        resultMap.put("REMOVE ALL EXCEPT ONE TOOK:", endTime-startTime);
        Iterator<Integer> iter = list.iterator();

        return resultMap;
    }
}
