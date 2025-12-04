package strings;

import java.util.*;

public class P46to50 {
    public static Map<String, Integer> duplicateWords(String str){
        Map<String, Integer> map = new HashMap<>();
        for (String s : str.split("[ ,.-]")){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        return map;
    }
    public static Map<String, Integer> duplicateWordsFrequency(String str){
        Map<String, Integer> map = new HashMap<>();
        for (String s : str.split("[ ,.-]")){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        return map;
    }
    public static String findLongestWord(String str){
        List<String> list = new ArrayList<>();
        List<Character> charList = List.of(',','.','-',' ');
            StringBuilder currentSb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!charList.contains(str.charAt(i))){
                currentSb.append(str.charAt(i));
            }else {
                list.add(currentSb.toString());
                currentSb = new StringBuilder();
            }
        }
        System.out.println(list);
        return list.stream().max(Comparator.comparing(String::length)).get();
    }
    public static Map<Character, Integer> countFreqOfChar(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        return map;
    }
    public static String removeExtraCommas(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
        char currentChar = str.charAt(i), previousChar = str.charAt(i-1), comma = ',';
            boolean shouldBeAdd = true;
            if (previousChar == comma && currentChar == comma){
                shouldBeAdd = false;
            }
            if (shouldBeAdd) sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {

//         Find duplicate words in a sentence
        final Map<String, Integer> duplicateWordsFrequency = duplicateWordsFrequency("Hello brother, I am brother of your friend, can I be your friend.");
        System.out.println("DuplicateWords : " + duplicateWordsFrequency);
//         Count frequency of each word in a paragraph
        final List<String> duplicateWords = duplicateWordsFrequency.entrySet().stream().filter(map->map.getValue()>1).map(map-> map.getKey()).toList();
        System.out.println("DuplicateWo zrds : " + duplicateWords);

//         Find longest word without using split()
        String longestWord = findLongestWord("Hello I am a programmer, Looking for a job, If you have reference somewhere Please help me to get a job.");
        System.out.println("LongestWord : " + longestWord);
//         Count repeated characters only (ignore unique ones)
        final Map<Character, Integer> mapChar = countFreqOfChar("Programming");
        System.out.println(mapChar);
//         Remove extra commas from string
        String removedExtraCommas = removeExtraCommas("Hello friend's ki haal,,, chaal");
        System.out.println("RemovedExtraCommas : " + removedExtraCommas);
    }
}
