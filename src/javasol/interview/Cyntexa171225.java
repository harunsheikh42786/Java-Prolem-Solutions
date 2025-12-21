package javasol.interview;


import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cyntexa171225 {
    // Round 1
    // Sol : 1
    public static String reverseStringExceptSpeChar(String str) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException("String must not be null or empty");
        }

        char[] letters = new char[str.length()];
        int index = 0;

        // Collect letters in reverse order
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                letters[index++] = ch;
            }
        }

        // Build result
        StringBuilder result = new StringBuilder();
        int letterIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isLetter(ch)) {
                result.append(ch);
            } else {
                result.append(letters[letterIndex++]);
            }
        }
        return result.toString();
    }
    // Sol : 2 (Stream)
    public static Character firstNoneRepeatedCharWithStream(String str){
        return str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry-> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
    }
    // Sol : 2 (Manual code)
    public static Character firstNoneRepeatedChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
    // Sol : 4
    public static int[] arrangeNegAndPosInArr(int[] arr) {
        int[] temp = new int[arr.length];
        int index = 0;

        for (int num : arr) {
            if (num < 0) temp[index++] = num;
        }
        for (int num : arr) {
            if (num >= 0) temp[index++] = num;
        }
        return temp;
    }

    // Round 2
    // Sol : 1
    public static void printPattern(int rows) {
        for (int i = 0; i < rows; i++) {
            int val = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(val);
                val = (val == 1) ? 0 : 1;
            }
            System.out.println();
        }
    }
    // Sol : 2
    public static void snakePattern(int n, int m) {
        int[][] arr = new int[n][m];
        int num = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = num++;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    arr[i][j] = num++;
                }
            }
        }

        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    // Sol : 3
    public static void fibonacciTrianglePattern(int rows) {
        int a = 0, b = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a + " ");
                int c = a + b;
                a = b;
                b = c;
            }
            System.out.println();
        }
    }
    // Sol : 4
    public static int equilibriumPoint(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];
            if (leftSum == totalSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
    // Sol : 5
    public static int[] contiguousSubArrayOfTargetSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    // Sol : 6
    public static int longestSubstringPalindrome(String str) {
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (isPalindrome(str, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    // Sol : 6 (Helper)
    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    // Sol : 7
    public static String convertInteger(int num) {
        if (num == 0) return "0";

        int[] binary = new int[32];
        int index = 0;

        while (num > 0) {
            binary[index++] = num % 2;
            num /= 2;
        }

        StringBuilder result = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            result.append(binary[i]);
        }
        return result.toString();
    }



    public static void main(String[] args) {
        //Reverse string except special char
        //input : ab-cd,efg
        //output : gf-ed,cba
        String str = "ab-cd,efg";
        System.out.println("\nReverse String except special characters");
        final String reverseStringExceptSpeChar = reverseStringExceptSpeChar(str);
        System.out.println("Original : " + str);
        System.out.println("Output : " + reverseStringExceptSpeChar);

        //Rearrange arr negative in left and positive in right
        //input : [-13,5,-10,9,2,-5,-1,11]
        //output : [-13,-10,-5,-1,5,9,2,11]
        int [] arr = {-13,5,-10,9,2,-5,-1,11};
        System.out.println("\nArrange neg in left and pos in right in original order");
        System.out.print("Original : ");
        Arrays.stream(arr).forEach(e-> System.out.print(e + ", "));
        arr = arrangeNegAndPosInArr(arr);
        System.out.print("\nOutput : ");
        Arrays.stream(arr).forEach(e-> System.out.print(e + ", "));
        System.out.println();

        //1
        //10
        //101
        //1010
        //10101
        int row = 5;
        System.out.println("\nPrint logic Pattern :");
        printPattern(row);

        // First None Repeated Char
        String str2 = "swiss";
        System.out.println("Return first none repeated char of String");
        final Character firstNoneRepeatedCharWithStream = firstNoneRepeatedCharWithStream(str2);
        System.out.println("Result with stream : " + ((firstNoneRepeatedCharWithStream != null) ? firstNoneRepeatedCharWithStream : "null"));
        final Character firstNoneRepeatedCharManually = firstNoneRepeatedChar(str2);
        System.out.println("Result with manually code : " + ((firstNoneRepeatedCharManually != null) ? firstNoneRepeatedCharManually : "null"));

        // Print array in snake Pattern
        // 0 1 2 3
        // 7 6 5 4
        // 8 9 10 11
        // 15 14 13 12...
        System.out.println("\nPrinting Snake Pattern : ");
        int n =4, m=4;
        snakePattern(n, m);

        // Fibonacci Triangle (90 degree left)
        //0
        //1 1
        //2 3 5
        //8 13 21 34
        //...
        int row2 = 4;
        System.out.println("\nFibonacci Triangle Pattern : ");
        fibonacciTrianglePattern(row2);

        int [] arr1 = {1,3,5,2,2};
        System.out.println("\nEquilibrium point Search for TargetSum ");
        final int equilibriumPoint = equilibriumPoint(arr1);
        System.out.print("Original Array : ");
        Arrays.stream(arr1).forEach(e-> System.out.print(e+", "));
        System.out.println("\nEquilibrium Point result : " + equilibriumPoint);

        int [] arr2 = {2,3,5,7,4,6};
        int targetSum2 = 15;
        System.out.println("\nFind target sum in contiguous subArray and return start and end indices");
        System.out.print("Original : [");
        Arrays.stream(arr2).forEach(e-> System.out.print(e+", "));
        System.out.println("]");
        final int[] resultIndices = contiguousSubArrayOfTargetSum(arr2, targetSum2);
        if (resultIndices != null) {
            System.out.println("Result : Start : " + resultIndices[0] + ", End : " + resultIndices[1]);
        }else {
            System.out.println("Return indices is null.");
        }
        String str3 = "babad";
        System.out.println("\nLongest substring palindrome :");
        final int longestSubstringPalindrome = longestSubstringPalindrome(str3);
        System.out.println("Original : " + str3);
        System.out.println("Longest Substring : " + longestSubstringPalindrome);

        int num = 5;
        final String convertedInteger = convertInteger(num);
        System.out.println("\nOriginal : " + num);
        System.out.println("ConvertedInteger : " + convertedInteger);
    }
}
