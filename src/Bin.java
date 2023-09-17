import java.util.*;

public class Bin implements Comparator<Integer> {

    public Queue<Integer> q;
    // use an array to store the items
    static int[] items = new int[8];
    public Bin() {
        this.q = new PriorityQueue<>(Collections.reverseOrder());
    }

    public static int[] getRandomSizeOfItems (){
        for (int i = 0; i < items.length; i++) {
            items[i] = (int)(Math.random() * 10 + 1);
        }
        return items;
    }
    // put those items into the priority queue
    public static Queue<Integer> putItemsIntoQueue(Queue<Integer> q){
        for (int i = 0; i < items.length; i++) {
            q.offer(items[i]);
        }
        return q;
    }
















    static ArrayList<Integer> bin = new ArrayList<Integer>(3);
    int capacityOfBin = 20;



    public static ArrayList<Integer> getBin (){
        for (int i = 0; i < 3; i++) {
            bin.add(20);
        }
        return bin;
    }
    public static ArrayList<Integer> updateBin (){
        int result =  bin.get(0) - items[0];
        bin.set(0,result);
        return bin;
    }


    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
