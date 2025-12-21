package javasol.interview;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DecipherZone151225 {

    // Sol : 1
    public static Map<Character, Long> countChar(String str){
        return str.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
    // Sol : 2
    public static void incrementedPatternHalfTriangle(int row){
        for (int i=0; i<row; i++){
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        // Write your name and count char occurrence
        System.out.println("Q1. Write your name and count char occurrence.");
        String name = "Harun";
        final Map<Character, Long> countStringChars = countChar(name);
        System.out.println("Input : " + name);
        System.out.println("Output : " + countStringChars);

        //Print Pattern
        //*
        //**
        //***
        //****
        //*****
        System.out.println("\nQ2. Print Incremental triangle pattern with '*'.");
        int row = 5;
        incrementedPatternHalfTriangle(row);
    }

}
