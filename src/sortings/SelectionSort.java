package sortings;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int [] arr = {1,2,15,7,21,2,54,11,12};
        System.out.print("Original : ");
        Arrays.stream(arr).forEach(e-> System.out.print(e+", "));

        for (int i = 0; i < arr.length-1; i++) { // 0 - 8
            int min = i;
            for (int j = i+1; j < arr.length; j++) { // 1,2,3...9
                if (arr[min] > arr[j]){ // 1 > 2 F
                    min = j;
                }
            }
            if (arr[min] < arr[i]){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        System.out.print("\nSorted : ");
        Arrays.stream(arr).forEach(e-> System.out.print(e+", "));
    }

}
