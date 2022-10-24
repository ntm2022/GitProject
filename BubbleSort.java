public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;//biến needNextPass nếu bằng false -> mảng k cần sắp xếp (sorted)

        for (int k = 1; k < list.length && needNextPass; k++) {
            /* Array may be sorted and next pass not needed */
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
        }
        //list[]->2 3 2 5 6 1 -2 3 14 12
        //k     ->1                      2               3 4 5 6 7 8 9
        //i     ->0 1 2 3 4  5 6 7 8     0 1 2 3 4 5 6 7
        //list[]->2 2 3 5 1 -2 3 6 14 12
    }
}
