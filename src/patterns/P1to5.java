package patterns;

public class P1to5 {
    public static void main(String[] args) {
        // Left to Right : Number Triangle
        //1
        //12
        //123
        //1234
        //12345
        int row = 5, column=5; // row (up to down) column (left to right)
        for(int i=0; i<row; i++){ // up to down 1 to 5 as value or 0 to 4 as index
            for(int j=0; j<=i; j++){ // j=0 to i because we need column is equals to i ex :- 0 -> 1 , 1-> 2
                System.out.print(j+1); // j+1 because j = 0 not 1 - > 0+1 = 1, 1+1 = 2, 2+1 = 3, 3+1 = 4... not 0,1,2...
                // print without new line, because we need number left to right
            }
            System.out.println();// new line
        }

        // Right to Left : Number Triangle
        //    1
        //   21
        //  321
        // 4321
        //54321
        int row2 = 5, column2 = 5;
        for (int i=0; i<row2; i++){
            for (int j=0; j<column2-i-1; j++){ // column2-i-1 = 5-0-1 = 4 // space
                System.out.print(" "); // print spaces
            }
            int count = i+1; // 0 + 1 = 1
            for (int k=count; k>0; k--){
                System.out.print(count);
                count--; // for decrement 5->4...1->0
            }
            System.out.println(); // new line
        }

        // Pyramid
        //    *
        //   ***
        //  *****
        // *******
        //*********

        //1234 *
        //123 ** *
        //12 *** **
        //1 **** ***
        // ***** ****
        int row3 = 5, column3 = 5;
        for (int i=0; i<row2; i++){
            // 1st decrement pyramid 4->1
            for (int j=0; j<column2-i-1; j++){ // column2-i-1 = 5-0-1 = 4 // space
                System.out.print(" "); // print spaces
            }

            // 2nd increment pyramid 1->5
            int count = i+1; // 0 + 1 = 1
            for (int k=count; k>0; k--){
                System.out.print("*");
                count--; // for decrement 5->4...1->0
            }

            // 3rd increment pyramid
            for (int j=0; j<i; j++){ // i = 0, * = 0, //  * ** ***
                System.out.print("*"); // print spaces
            }
            System.out.println(); // new line
        }

        // Diamond
        //    *
        //   ***
        //  *****
        // *******
        //*********
        // *******
        //  *****
        //   ***
        //    *
        // Solution break it into sub problem
        //    *
        //   ** *
        //  *** **
        // **** ***
        //***** **** row1 = 5
        int row4 = 5, column4 = 5, row5 = 4, column5 = 4;
        for(int i=0; i<row4; i++){ // 0 -> 5
            for (int j=0; j<column4-i-1; j++){ // 0 -> (5 - 0 - 1) = 0 -> 4
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++) {
                System.out.print("*");
            }
            for (int l = 0; l < i; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // **** ***
        //  *** **
        //   ** *
        //    * row2 = 4
        for(int i=0; i<row5; i++){ // 0 -> 5
            for (int j=0; j<i+1; j++){ // 0 -> (5 - 0 - 1) = 0 -> 4
                System.out.print(" ");
            }
            for (int k = i; k < column5; k++) {
                System.out.print("*");
            }
            for (int l = i; l < column5-1; l++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lightning
        //    *
        //   **
        //  ***
        // ****
        //*****
        //    *****
        //    ****
        //    ***
        //    **
        //    *
        int row6 = 5, column6 = 5;
        for(int i=0; i<row6; i++){ // 0 -> 5
            for (int j=i; j<column6-1; j++){ // 0 -> (5 - 0 - 1) = 0 -> 4
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        int row7 = 5, column7 = 5;
        for(int i=0; i<row6; i++){ // 0 -> 5
            for (int j=0; j<column6-1; j++){ // 0 -> (5 - 0 - 1) = 0 -> 4
                System.out.print(" ");
            }
            for (int k = column7; k > i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
