package strings;

public class P1to5 {

    // P1
    public static String reverseStringUsingLoop(String str){
        // Validate string
        if (str == null || str.isEmpty()) throw new RuntimeException("String should not be null or empty");
        if (str.length() == 1) return str;

        StringBuilder stringBuilder = new StringBuilder(); // Doesn't create new String object in pool or Heap with new Keyword

        // Reverse loop for string
        for (int i=str.length()-1; i>=0 ; i--){
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }
    // P2
    public static String reverseStringUsingRec(String str){
        // Validate string
        if (str == null || str.isEmpty()) throw new RuntimeException("String should not be null or empty");
        if (str.length() == 1) return str;

        return str.charAt(str.length()-1)+reverseStringUsingRec(str.substring(0,str.length()-1));
    }
    // P3
    public static String reverseStringUsingStringBuilder(String str){
        // Validate string
        if (str == null || str.isEmpty()) throw new RuntimeException("String should not be null or empty");
        if (str.length() == 1) return str;

        return new StringBuilder(str).reverse().toString();
    }
    // P4
    public static String reverseStringUsingStringBuffer(String str){
        // Validate string
        if (str == null || str.isEmpty()) throw new RuntimeException("String should not be null or empty");
        if (str.length() == 1) return str;

        return new StringBuffer(str).reverse().toString();
    }
    // P5
    public static boolean checkPalindrome(String str){
        // Validate string
        if (str == null || str.isEmpty()) throw new RuntimeException("String should not be null or empty");
        if (str.length() == 1) return true;

        return str.equalsIgnoreCase(reverseStringUsingRec(str));
    }

    public static void main(String[] args) {
//        final String reversedStringUsingLoop1 = reverseStringUsingLoop(null); // throw exception
//        final String reversedStringUsingLoop2 = reverseStringUsingLoop(""); // o/p : throw exception
        final String reversedStringUsingLoop3 = reverseStringUsingLoop("H"); // o/p : H
        System.out.println(reversedStringUsingLoop3);
        final String reversedStringUsingLoop4 = reverseStringUsingLoop("Harun"); // o/p : nuraH
        System.out.println(reversedStringUsingLoop4);

        final String reversedStringUsingRec1 = reverseStringUsingRec("H"); // o/p : H
        System.out.println(reversedStringUsingRec1);
        final String reversedStringUsingRec2 = reverseStringUsingRec("Harun"); // o/p : nuraH
        System.out.println(reversedStringUsingRec2);

        final String reversedStringUsingStringBuilder1 = reverseStringUsingStringBuilder("H"); // o/p : H
        System.out.println(reversedStringUsingStringBuilder1);
        final String reversedStringUsingStringBuilder2 = reverseStringUsingRec("Harun"); // o/p : nuraH
        System.out.println(reversedStringUsingStringBuilder2);

        final String reversedStringUsingStringBuffer1 = reverseStringUsingStringBuilder("H"); // o/p : H
        System.out.println(reversedStringUsingStringBuffer1);
        final String reversedStringUsingStringBuffer2 = reverseStringUsingRec("Harun"); // o/p : nuraH
        System.out.println(reversedStringUsingStringBuffer2);

        final boolean isPalindrome1 = checkPalindrome("H"); // o/p : true
        System.out.println("H : "+isPalindrome1);
        final boolean isPalindrome2 = checkPalindrome("Harun"); // o/p : false
        System.out.println("Harun : " + isPalindrome2);
        final boolean isPalindrome3 = checkPalindrome("madam"); // o/p : true
        System.out.println("madam : "+isPalindrome3);

    }
}
