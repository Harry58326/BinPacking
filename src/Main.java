import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bin b = new Bin();
        Bin.getRandomSizeOfItems();
        System.out.println(Arrays.toString(Bin.items));
        Bin.putItemsIntoQueue(b.q);
        while (!b.q.isEmpty()){
            System.out.println(b.q.poll());
        }
    }
}