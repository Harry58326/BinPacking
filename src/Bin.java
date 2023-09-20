import java.util.*;

public class Bin {
    public ArrayList<Integer> binsArrOfUnusedSpace;  // ArrayList to store the remaining space in each bin.
    public Queue<Integer> q;  // Priority Queue to hold the items to be placed in bins.

    public ArrayList<Integer> itemsInBin;

    public ArrayList<Integer> unpackedItems;

    public ArrayList<ArrayList<Integer>> answer;

    public Bin() {
        this.q = new PriorityQueue<>(Collections.reverseOrder());  // Items will be sorted in descending order.
        this.binsArrOfUnusedSpace = new ArrayList<>();
        this.itemsInBin = new ArrayList<>();
        this.unpackedItems = new ArrayList<>();
        this.answer = new ArrayList<>();
    }

    /**
     * Update bins using Best-Fit Decreasing algorithm.
     *
     * @param binsArrOfUnusedSpace ArrayList that records the amount of unused space in each bin.
     * @param q                    Priority Queue containing items to place.
     * @param binSize              The capacity of a new bin.
     */
    public static void updateBinBestFitDecreasing(ArrayList<Integer> binsArrOfUnusedSpace, Queue<Integer> q, int binSize) {
        Queue<Integer> tempQ = new PriorityQueue<>(q);
        binsArrOfUnusedSpace.add(binSize);  // Add a new bin.

        // Initialize an ArrayList to hold the indices sorted by unused space.
        ArrayList<Integer> unUsedSpaceDescending = new ArrayList<>();
        for (int i = 0; i < binsArrOfUnusedSpace.size(); i++) {
            unUsedSpaceDescending.add(i);
        }

        // remove each item in the priority queue
        while (!tempQ.isEmpty()) {
            int item = tempQ.poll();// remove the first item from the queue
            boolean flag = false;  // To indicate if an item has been placed.

            // Sort the ArrayList based on the unused space in each bin.
            Collections.sort(unUsedSpaceDescending, (i1, i2) -> Integer.compare(binsArrOfUnusedSpace.get(i1), binsArrOfUnusedSpace.get(i2)));

            // try to place an item in the least unused space
            for (Integer integer : unUsedSpaceDescending) {
                if (item <= binsArrOfUnusedSpace.get(integer)) {
                    binsArrOfUnusedSpace.set(integer, binsArrOfUnusedSpace.get(integer) - item);  // Update the unused space in the bin.
                    flag = true;  // Mark that the item has been placed.
                    break;
                }
            }

            // If the item couldn't be placed in any existing bin, create a new bin.
            if (!flag) {
                binsArrOfUnusedSpace.add(binSize - item);
                unUsedSpaceDescending.add(binsArrOfUnusedSpace.size() - 1);  // Add the index of the new bin to sorted indices.
            }
        }
    }

    /**
     * Update bins using First-Fit Decreasing algorithm.
     *
     * @param binsArrOfUnusedSpace ArrayList that records the amount of unused space in each bin.
     * @param q                    Priority Queue containing items to place.
     * @param binSize              The capacity of a new bin.
     */
    public static void updateBinFirstFitDecreasing(ArrayList<Integer> binsArrOfUnusedSpace, Queue<Integer> q, int binSize) {
        Queue<Integer> tempQ = new PriorityQueue<>(q);  // Make a temporary copy of the queue.

        // Loop to process each item in the queue.
        while (!tempQ.isEmpty()) {
            int item = tempQ.poll();  // Retrieve and remove the head of the queue.
            boolean flag = false;  // To indicate if an item has been placed.

            // place an item into the bin, we don't care about the unused space at this time
            for (int i = 0; i < binsArrOfUnusedSpace.size(); i++) {
                if (binsArrOfUnusedSpace.get(i) >= item) {
                    binsArrOfUnusedSpace.set(i, binsArrOfUnusedSpace.get(i) - item);  // Update the unused space in the bin.
                    flag = true;
                    break;
                }
            }

            // If the item couldn't be placed in any existing bin, create a new bin.
            if (!flag) {
                binsArrOfUnusedSpace.add(binSize - item);
            }
        }
    }
}
