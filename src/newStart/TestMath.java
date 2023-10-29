package newStart;

import java.util.HashMap;
import java.util.Map;

public class TestMath {
    public static void main(String[] args) {
        String str = "PNEUMONOUTRAMICROSOPICILICOVOL-CANOCONIOSIS";
        countLetters(str);
    }

    public static void countLetters(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}
