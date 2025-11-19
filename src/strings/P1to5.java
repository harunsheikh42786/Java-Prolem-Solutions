package strings;

public class P1to5 {

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
    public static String reverseStringUsingRec(String str){
        // Validate string
        if (str == null || str.isEmpty()) throw new RuntimeException("String should not be null or empty");
        if (str.length() == 1) return str;

        return str.charAt(str.length()-1)+reverseStringUsingRec(str.substring(0,str.length()-1));
    }

    public static void main(String[] args) {
//        final String reversedStringUsingLoop1 = reverseStringUsingLoop(null); // throw exception
//        final String reversedStringUsingLoop2 = reverseStringUsingLoop(""); // o/p : throw exception
        final String reversedStringUsingLoop3 = reverseStringUsingLoop("H"); // o/p : H
        System.out.println(reversedStringUsingLoop3);
        final String reversedStringUsingLoop4 = reverseStringUsingLoop("Harun"); // o/p : nuraH
        System.out.println(reversedStringUsingLoop4);

        final String reversedStringUsingLoop5 = reverseStringUsingRec("H"); // o/p : H
        System.out.println(reversedStringUsingLoop5);
        final String reversedStringUsingLoop6 = reverseStringUsingRec("Harun"); // o/p : nuraH
        System.out.println(reversedStringUsingLoop6);

    }
}
