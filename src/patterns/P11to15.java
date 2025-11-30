package patterns;

public class P11to15 {

    public static void main(String[] args) {
        // Floyd’s Triangle
        //1
        //2 3
        //4 5 6
        //7 8 9 10
        int r =4, count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(++count+" ");
            }
            System.out.println();
        }


        // Binary Number Pattern (0 & 1 alternate)
        //1
        //01
        //101
        //0101
        int r2=4;
        boolean outer = true, inner = false;
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j <=i; j++) {
                if (i%2==0 && j==0) {
                    System.out.print(1);
                    inner = !outer;
                }else{
                    System.out.print(inner ? 1 : 0);
                    inner = !inner;
                }
            }
            System.out.println();
        }

        // Full Pyramid
        //   *
        //  *
        // *
        //*
        int r3 = 4;
        for (int i = 0; i < r3; i++) {
            for (int j = r3; j > i+1; j--) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        // Pascal Triangle (no formula, simple logic)
        //1
        //1 1
        //1 2 1
        //1 3 3 1
        int n=5;
        for (int i = 0; i < n; i++) {
            int number = 1; // Har row start 1 se hoti hai

            // Spaces for pyramid shape
            for (int space = 0; space < n - i - 1; space++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                // Next number = current * (i - j) / (j + 1)
                number = number * (i - j) / (j + 1); // 2 - 0 / 0+1 = 2 // 2-1/1+1
            }
            System.out.println();
        }

        // Inverted Full Pyramid
        //*
        // *
        //  *
        //   *
        int r4 = 4;
        for (int i = 0; i < r4; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }

}
