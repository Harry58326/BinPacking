import java.util.*;

// First fit decreasing
public class Bin {
    public ArrayList<Integer> binsArr;
    public Queue<Integer> q;
    // use an array to store the items
    static int[] items = new int[8];
    public Bin() {
        this.q = new PriorityQueue<>(Collections.reverseOrder());
        this.binsArr = new ArrayList<>();
    }

    public static int[] getRandomSizeOfItems() {
        for (int i = 0; i < items.length; i++) {
            items[i] = (int) (Math.random() * 10 + 1);
        }
        return items;
    }

    // put those items into the priority queue
    public static Queue<Integer> putItemsIntoQueue(Queue<Integer> q) {
        for (int i = 0; i < items.length; i++) {
            q.offer(items[i]);
        }
        return q;
    }

    public static void updateBinBestFitDecreasing(ArrayList<Integer> binsArr, Queue<Integer> q) {
        Queue<Integer> tempQ = new PriorityQueue<>(q);
        binsArr.add(20);
        int minAvailableSpace = 100;
        int position = -1;
        while (!tempQ.isEmpty()) {
            int item = tempQ.poll();
            boolean flag = false;
            for (int i = 0; i < binsArr.size(); i++) {
                if (binsArr.get(i) < minAvailableSpace){
                    minAvailableSpace = binsArr.get(i);
                    position = i;
                }
            }
            for (int i = 0; i < binsArr.size(); i++) {
                if (item <= minAvailableSpace){
                    binsArr.set(position, binsArr.get(position) - item);
                    minAvailableSpace = minAvailableSpace - item;
                    flag = true;
                } else if (binsArr.get(i) >= item) {
                    binsArr.set(i, binsArr.get(i) - item);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                binsArr.add(20 - item);
            }
        }
    }

    public static void updateBinFirstFitDecreasing(ArrayList<Integer> binsArr, Queue<Integer> q) {
        Queue<Integer> tempQ = new PriorityQueue<>(q);
        while (!tempQ.isEmpty()) {
            int item = tempQ.poll();
            boolean flag = false;
            for (int i = 0; i < binsArr.size(); i++) {
                if (binsArr.get(i) >= item) {
                    binsArr.set(i, binsArr.get(i) - item);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                binsArr.add(20 - item);
            }
        }
    }
}