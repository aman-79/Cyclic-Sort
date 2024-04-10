import java.util.ArrayList;
import java.util.List;

public class cyclicSort {
    public static void main(String args[]) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(arr);
        System.out.println(disappearedNumbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> disappeared = new ArrayList<>();

        // Cyclic Sort
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        // Find Missing Numbers
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                disappeared.add(j + 1);
            }
        }

        return disappeared;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
