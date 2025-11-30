package patterns;

public class P6to10 {
    public static void main(String[] args) {
        //*   *   *
        // * * * *
        //  *   *
        // * * * *
        //*   *   *

        //*   *   *
        // * * * *
        //  *   *
       int r2 = 3;
        int m = 1; //0-2, 1-3
        for (int i = 0; i <r2; i++) {
            // Part-1
            for (int j=0; j<i; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            // Part-2
            for (int k=r2-i; k>i; k--){ //3, 1
                System.out.print(" ");
            }
            if (i != r2-1)
                System.out.print("*");
            // Part-3
            if(i!=0) {
                for (int k = 0; k < m; k++) { //3, 1
                    System.out.print(" ");
                }
                m += 2;
            }

            // Part-4
            if (i!=0)
                System.out.print("*");
            for (int k=r2-i; k>i; k--){ //3, 1
                System.out.print(" ");
            }
            // Part-5
            if (i != r2-1)
                System.out.print("*");
            System.out.println();
        }
        //1
        //123
        //12345
        //1234567
        // * * * *
        //*   *   *
        int r3 = r2-1; // 2
        int m2 = 1;
        for (int i = 0; i < r3; i++) {
            // Part-1
            if (i != r3 - 1) {
                for (int j = 0; j < m2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.print("*");
            // Part-2
            for (int j = 0; j < m2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            // Part-3
            for (int j = 0; j < m2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            // Part-4
            if (i != r3 - 1) {
                for (int j = 0; j < m2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                m2 += 2;
                System.out.println();
            }
        }
        System.out.println("\n");
//        Butterfly Pattern
//        *   *
//        ** **
//        *****
//        ** **
//        *   *
        int r4 = 3;
        for (int i = 0; i < r4; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            for (int k = 3; k > i+1; k--) { // 3 1 0
                System.out.print(" ");
            }
            for (int k = 3; k > i+2; k--) { // 3 1 0
                System.out.print(" ");
            }
            for (int l=0; l<=i; l++){
                if (i == r4-1 && l==0)
                    System.out.print("");
                else System.out.print("*");
            }
            System.out.println();
        }
        int r5 = 2;
        for (int i = 0; i < r5; i++) {
            for (int k = r5; k > i; k--) {
                System.out.print("*");
            }
            for (int j = 0; j <=i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int l=r5; l>i; l--){
                System.out.print("*");
            }
            System.out.println();
        }
//        Zig-Zag Pattern
//           *     *
//         *   *  *
//        *     *
        int r6 = 3;
        for (int i = 0; i < r6; i++) {
            for (int j = r6; j > i+1; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k=0; k<i; k++){
                System.out.print(" ");
            }
            for (int k=0; k<i; k++){
                System.out.print(" ");
            }

            if (i!=0)
                System.out.print("*");
            else
                System.out.print(" ");

            for (int l=r6; l>i+1; l--){
                System.out.print(" ");
            }
            for (int l=r6; l>i+1; l--){
                System.out.print(" ");
            }
            if (i!=r6-1)
                System.out.println("*");
        }
//        Hollow Diamond
//           *
//          * *
//         *   *
//        *     *
//         *   *
//          * *
//           *
        System.out.println("\n");
        int r7 = 4;
        for (int i = 0; i < r7; i++) {
            for (int j = r7; j > i+1; j--) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i-1; k++) {
                System.out.print(" ");
            }
            if (i!=0)
                System.out.print("*");
            System.out.println();
        }
        int r8 = 4;
        for (int i = 0; i < r8-1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k = i; k < r8-2; k++) {
                System.out.print(" ");
            }
            for (int k = i; k < r8-3; k++) {
                System.out.print(" ");
            }
             if (i != r8-2)System.out.print("*");
            System.out.println();
        }

    }
}
