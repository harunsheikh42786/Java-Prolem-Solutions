package sortings;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int [] arr = {1,2,15,7,21,2,54,11,12};
        System.out.print("Original : ");
        Arrays.stream(arr).forEach(e-> System.out.print(e+", "));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.print("\nSorted : ");
        Arrays.stream(arr).forEach(e-> System.out.print(e+", "));
    }

}
