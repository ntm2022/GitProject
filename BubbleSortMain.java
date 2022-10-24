public class BubbleSortMain {
    public static void main(String[] args) {
        BubbleSort.bubbleSort(BubbleSort.list);
        for (int i = 0; i < BubbleSort.list.length; i++)
            System.out.print(BubbleSort.list[i] + " ");
    }
}
