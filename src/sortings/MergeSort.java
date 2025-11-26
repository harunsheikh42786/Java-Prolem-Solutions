package sortings;

import java.util.Arrays;

public class MergeSort {

    private int [] arr;
    private int length;
    private int [] tempArr;

    public MergeSort(int [] arr){
        this.arr = arr;
        this.length = arr.length;
        this.tempArr = new int[this.length];
    }

    public void sort(int low, int high){
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(0, mid);
            sort(mid + 1, high);
            merge(low, mid, high);
        }
    }
    public void merge(int lowerIndex, int middle, int higherIndex){
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempArr[i] = arr[i];
        }

        int i = lowerIndex;
        int j = middle+1;
        int k = lowerIndex;

        while(i <= middle && j <= higherIndex){
            if (tempArr[i] >= tempArr[j]) arr[k++] = tempArr[j++];
            else arr[k++] = tempArr[i++];
        }
        while(i <= middle){
            arr[k++] = tempArr[i++];
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{45,12,65,78,12,45,44};
        MergeSort ms = new MergeSort(arr);
        ms.sort(0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);

    }

}
