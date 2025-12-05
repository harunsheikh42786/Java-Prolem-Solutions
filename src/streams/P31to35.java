package streams;

import streams.entities.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P31to35 {

    public static void main(String[] args) {
//        21. Reverse each word in a sentence using Streams.
//        Input: `"I love Java"` → `"I evol avaJ"`
        String str1 = "I love Java";
        final String reversedEveryWord = Arrays.stream(str1.split("[ .,-]")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" "));
        System.out.println("Original : " + str1);
        System.out.println("ReversedEveryWord : " + reversedEveryWord);
//        22. Given a list of transactions, group them by status (FAILED/SUCCESS).
        final List<Transaction> transactions = List.of(
                new Transaction(2000, "Harun", "Wasim", true),
                new Transaction(200, "Sohail", "Javed", false),
                new Transaction(400, "Usman", "Lukman", true),
                new Transaction(500, "Sohil", "Wasim", true),
                new Transaction(50, "Harun", "Sohail", false),
                new Transaction(20, "Sohil", "Usman", true)
        );
        final Map<Boolean, List<Transaction>> transactionStatusGroup = transactions.stream().collect(Collectors.partitioningBy(Transaction::getSuccessStatus));
        System.out.println("Original : " + transactions);
        System.out.println("\nGroupOfSuccessTransaction : " + transactionStatusGroup.get(true));
        System.out.println("\nGroupOfFailedTransaction : " + transactionStatusGroup.get(false));
//        23. Find top 3 maximum numbers using Streams.
        final List<Transaction> top3Transaction = transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).limit(3).toList();
        System.out.println("Original : " + transactions.stream().map(Transaction::getAmount).toList());
        System.out.println("Top3Transaction : " + top3Transaction.stream().map(Transaction::getAmount).toList());

//        24. Check if two strings are anagrams using Streams.
//        (Without sorting)
        String str2 = "Listen", str3 = "Silent";
        Map<Character, Long> map1 = str2.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> map2 = str3.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        final boolean equals = map1.equals(map2);
        System.out.println("Check Anagram : " + equals);
//
//        25. Convert a List<String> into a single comma-separated string.
//                Input: `["A","B","C"]` → Output: `"A,B,C"`
        String[] str5 = {"A","B","C"};
        final String joinedString = Arrays.stream(str5).collect(Collectors.joining(","));
        System.out.println("Joined : " + joinedString);

    }
}
