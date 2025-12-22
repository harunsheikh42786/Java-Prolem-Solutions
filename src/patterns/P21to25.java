package patterns;

public class P21to25 {

    public static void main(String[] args) {
//        Alphabet Pattern (Tricky)
//        A
//        AB
//        ABC
//        ABCD
        int row = 4;
        for (int i = 0; i < row; i++) {
            char ch = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print((char)(ch+j));
            }
            System.out.println();
        }

// ➕ BONUS — LOGIC-BASED PATTERN (VERY GOOD PRACTICE)
//        Palindrome Number Pyramid
//        1
//        121
//        12321
//        1234321
        int row2 = 4;
        for (int i = 0; i < row2; i++) {
            int start = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(start++);
            }
            int second = start-2;
            for (int k = 0; k <i; k++) {
                System.out.print(second--);
            }
            System.out.println();
        }

//        0/1 Triangle Using (i+j) rule
//        1
//        01
//        010
//        1010
        int row3 = 4;
        boolean condition = true;
        for (int i = 0; i < row3; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(condition ? 1: 0);
                condition = !condition;
            }
            System.out.println();
        }
//    Hollow Diamond Pattern
//    *********
//    **** ****
//    ***   ***
//    **     **
//    *       *
//    **     **
//    ***   ***
//    **** ****
//    *********

        int row4 = 5, col = 5;
        int space = -1;
        for (int i = 0; i < row4; i++) {
            for (int j = i; j < col; j++) {
                System.out.print("*");
            }
            for (int k = 0; k <space; k++) {
                System.out.print(" ");
            }
            space += 2;
            for (int l = i; l < col; l++) {
                if (i==0 && l==0) continue;
                System.out.print("*");
            }
            System.out.println();
        }
        int row5 = row4, col1 = 5, space2 = space-2;
        for (int i = 1; i < row5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            space2 -= 2;
            for (int k = 0; k <space2; k++) {
                System.out.print(" ");
            }
            for (int l = 0; l <= i; l++) {
                if (i==row5-1 && l==0) continue;
                System.out.print("*");
            }
            System.out.println();
        }
//   Real Staircase Pattern
//        **
//        **
//        ****
//        ****
//        ******
//        ******
        int row6 = 6, col2 = 2;
        for (int i = 0; i < row6; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.print("*");
            }
            if (i%2!=0)
                col2 += 2;
            System.out.println();
        }


    }
}
