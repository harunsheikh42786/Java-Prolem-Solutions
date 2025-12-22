package patterns;

import java.util.Arrays;
import java.util.Scanner;

public class P16to20 {

    public static void main(String[] args) {

//        Number Spiral Pattern
//        1 2 3
//        8 9 4
//        7 6 5
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (size of square matrix): ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("n should be positive.");
            return;
        }
        int[][] a = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // left -> right on top row
            for (int j = left; j <= right; j++) a[top][j] = num++;
            top++;

            // top -> bottom on right column
            for (int i = top; i <= bottom; i++) a[i][right] = num++;
            right--;

            if (top <= bottom) {
                // right -> left on bottom row
                for (int j = right; j >= left; j--) a[bottom][j] = num++;
                bottom--;
            }

            if (left <= right) {
                // bottom -> top on left column
                for (int i = bottom; i >= top; i--) a[i][left] = num++;
                left++;
            }
        }
        Arrays.stream(a).forEach(System.out::println);

//        Concentric Square Pattern
//        For n=4:
//        4 44444 4 
//        43 333 34
//        432 2 234
//        4321 234

//        432 2 234
//        43 333 34
//        4 44444 4
        int raw = 4, p2 = 4, c1 = 5, p3 = 4;
        for (int i = 0; i < raw; i++) {
            int p1 = 4;
            for (int j = 0; j <= i; j++) {
                System.out.print(p1--);
            }
            int insideP2 = p2;
            for (int j = 0; j<c1; j++) {
                System.out.print(insideP2);
            }
            c1 = c1-2;
            p2--;
            int insideP3 = p3;
            for (int k = 0; k <=i; k++) {
                if (k == 0 && i == raw-1)
                    insideP3++;
                else System.out.print(insideP3++);
            }
            p3--;
            System.out.println();
        }

        int raw2 = 3, p21 = 2, c11 = 1, p31 = 2;
        for (int i = 0; i < raw2; i++) {
            int p11 = 4;
            for (int j = 0; j <= raw2-i-1; j++) {
                System.out.print(p11--);
            }
            int insideP21 = p21;
            for (int j = 0; j<c11; j++) {
                System.out.print(insideP21);
            }
            c11 = c11+2;
            p21++;
            int insideP31 = p31;
            for (int k = 0; k <raw2-i; k++) {
                System.out.print(insideP31++);
            }
            p31++;
            System.out.println();
        }

//        Hourglass Pattern
//        *
//         *
//          *
//           *
//          *
//         *
//        *
        int raw3 = 4, coloumn3 = 4;
        for (int i = 0; i < raw3; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        int raw4 = 3, coloumn4 = 3;
        for (int i = 0; i < raw4; i++) {
            for (int j = i; j<coloumn4-1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
//        X Pattern (no space mistakes allowed)
//        *   *
//         * *
//          *
//         * *
//        *   *
        int raw5 = 3, ms = 3;
        for (int i = 0; i < raw5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < ms; j++) {
                System.out.print(" ");
            }
            ms = ms-2;
            if (i != raw5-1)
                System.out.print("*");
            System.out.println();
        }
        int raw6 = 2, ms1 = 1, ms2 = 1;
        for (int i = 0; i < raw6; i++) {
            for (int j = 0; j <ms1; j++) {
                System.out.print(" ");
            }
            ms1--;
            System.out.print("*");
            for (int j = 0; j < ms2; j++) {
                System.out.print(" ");
            }
            ms2 = ms2+2;
            System.out.print("*");
            System.out.println();
        }
//      Hollow Pyramid
//           *
//          * *
//         *   *
//        *     *

        int raw7 = 4, ms3 = 1;
        for (int i = 0; i < raw7; i++) {
            for (int j = 0; j < raw7-i-1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            if (i!=0) {
                for (int j = 0; j < ms3; j++) {
                    System.out.print(" ");
                }
                ms3 = ms3 + 2;
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
