package module_3.lesson_4.homework.WordsCount;

import java.util.*;

public class WordsCount {

    public static String[] getUniqueWords(String[] inputArray){

        Set<String> arraySet = new LinkedHashSet<>(Arrays.asList(inputArray));
        return arraySet.toArray(new String[0]);
    }

    public static Map<String, Integer> getCountWords(String[] inputArray){

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : inputArray) {
            if (wordCountMap.containsKey(word)){
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        return wordCountMap;
    }
}
