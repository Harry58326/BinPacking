import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bin b = new Bin();
        Bin.getRandomSizeOfItems();
        System.out.println(Arrays.toString(Bin.items));
        Bin.putItemsIntoQueue(b.q);
        Bin.updateBinBestFitDecreasing(b.binsArr,b.q);
        System.out.println(b.binsArr);
    }
}