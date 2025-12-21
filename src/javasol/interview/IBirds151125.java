package javasol.interview;

public class IBirds151125 {

    // Sol : 1
    public static void printPattern(int row){
        int outerCount = 1;
        boolean startPrintCondition = true;
        for (int i=0; i<row; i++){
            int printCount = outerCount;
            boolean printCondition = startPrintCondition;
            for (int j = 0; j <= i; j++) {

                if (printCondition) System.out.print(printCount);
                else System.out.print("*");

                printCount--;
                printCondition = !printCondition;
            }
            outerCount++;
            startPrintCondition = !startPrintCondition;
            System.out.println();
        }
    }

    // Sol : 2
    public static int swapFirstAndLastDigit(int num){
        int copyNum = num; // 123
        int firstDigit; // 123/10  = 12/10 = 1/10 = 0
        int lastDigit = num%10; // 123 % 10  = 3
        int countDigit = 1;
        while (copyNum/10 > 0){ // 123/10 = 12 -> T 12/10 = T 1/10 = F 0
            copyNum /= 10;
            countDigit *= 10; // 10 -> 100
        }
        firstDigit = copyNum; // 1
        int middleDigits = num - firstDigit*countDigit - lastDigit; // 123 - 100 = 23 - 3 = 20

        return lastDigit*countDigit + middleDigits + firstDigit; // 300 + 20 = 320 + 1 = 321
    }

    public static void main(String[] args) {
        System.out.println("Q1 : Print Pattern");
        // 1
        // *1
        // 3*1
        // *3*1
        // 5*3*1
        int row = 5;
        printPattern(row);

        System.out.println("\nQ2 : Swap first and last digit");
        int num = 123;
        final int swappedFirstAndLastDigit = swapFirstAndLastDigit(num);
        System.out.println("Input : " + num);
        System.out.println("Swapped Output : " + swappedFirstAndLastDigit);
    }

}
