import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bin b = new Bin();
        System.out.println("Please enter bin size, number of items, items themselves");
        Scanner sc = new Scanner(System.in);
        int binSize = sc.nextInt();
        int numItems = sc.nextInt();
        for (int i = 0; i < numItems; i++) {
            int item = sc.nextInt();
            b.q.offer(item);
        }
        sc.close();
        Bin.updateBinBestFitDecreasing(b.binsArrOfUnusedSpace,b.q,binSize,0,b.unpackedItems, 3);
        Bin.storeResults(b.binsArrOfUnusedSpace, b.unpackedItems);
        System.out.println("This is unused space and unpacked items: " + Bin.answer);
        System.out.println("This is itemsInBins: " + Bin.itemsInBin);
    }
}
// test data is in the Comments file

