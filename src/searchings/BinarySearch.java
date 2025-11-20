package searchings;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int [] arr, int key, int low, int high){
        int mid = low + (high - low)/2;
        if (arr[mid] > key){
            return search(arr, key, low, mid-1);
        } else if (arr[mid] < key) {
            return search(arr, key, mid+1, high);
        }else
            return mid;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,15,7,21,2,54,11,12};
        Arrays.sort(arr); // Because Binary Search applied on sort array
        final int searchedIndex = search(arr, 15, 0, arr.length - 1);
        System.out.println("Key "+ 15+" found at : " + searchedIndex + " index.");
    }
}
