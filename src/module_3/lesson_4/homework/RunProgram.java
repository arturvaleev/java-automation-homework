package module_3.lesson_4.homework;

import module_3.lesson_4.homework.TelephoneDirectory.Exeption.ContactNotFoundException;
import module_3.lesson_4.homework.TelephoneDirectory.Exeption.DuplicatePhoneNumberException;
import module_3.lesson_4.homework.TelephoneDirectory.TelephoneDirectory;
import module_3.lesson_4.homework.WordsCount.WordsCount;

import java.util.Map;

public class RunProgram {

    public static void main(String[] args) {

        System.out.println("     ===Задание 1===");
        String[] words = {"яблоко", "банан", "апельсин", "яблоко", "груша", "банан", "киви", "апельсин", "манго", "яблоко"};
        String[] words2 = {};
        Map<String, Integer> wordCountMap;

        System.out.println("Только уникильные:");
        words2 = WordsCount.getUniqueWords(words);
        for (int i = 0; i < words2.length; i++) {
            System.out.println(words2[i]);
        }

        System.out.println("Сколько раз встречается каждое слово:");
        wordCountMap = WordsCount.getCountWords(words);
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("     ===Задание 2===");
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

        try {
            telephoneDirectory.add("Иванов", "123-456");
            telephoneDirectory.add("Петров", "234-567");
            telephoneDirectory.add("Иванов", "789-012");
            telephoneDirectory.add("Сидоров", "345-678");
            telephoneDirectory.add("Иванов", "123-456");
        } catch (DuplicatePhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Телефоны Иванова: " + telephoneDirectory.get("Иванов"));
            System.out.println("Телефоны Смирнова: " + telephoneDirectory.get("Смирнов"));
        } catch (ContactNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
