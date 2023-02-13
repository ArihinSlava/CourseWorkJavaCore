package coursework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;

public class FunctionalProgramming {

    public static void main(String[] args) {

        String words = " the little mouse has been running away from the big cat all his life ";
        System.out.println("Top 10: ");
        Stream<String> stringStream = new ArrayList<>(List.of(words.split(" "))).stream();
        Map<String, Long> wordsMap = stringStream
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        wordsMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(comparingByKey()))
                .limit(10)
                .forEach(System.out::println);



        
    }
}
