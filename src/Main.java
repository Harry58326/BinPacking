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
        Bin.updateBinBestFitDecreasing(b.binsArrOfUnusedSpace,b.q,20);
        System.out.println(b.binsArrOfUnusedSpace);
 /*       ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(-1);
        arr.add(100);
        arr.add(3);
        arr.add(29);
        arr.add(78);
        System.out.println(arr);
        Collections.sort(arr, (o1, o2) -> o2 - o1 );
        System.out.println(arr);*/
    }
}