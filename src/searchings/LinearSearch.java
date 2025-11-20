package searchings;

public class LinearSearch {
    public static void main(String[] args) {
        int [] arr = {1,2,15,7,21,2,54,11,12};
        int searchKey = 7;
        for (int i=0; i<arr.length; i++){
            if (searchKey == arr[i]){
                System.out.println("Search key " + searchKey + " found at " + i+" index.");
                break;
            }
        }
    }
}
