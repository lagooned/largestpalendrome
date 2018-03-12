/**
 * LargestPalendrome.java
 * @author jared engler
 */

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class LargestPalendrome {
    public static void main(String [] args) {
        String str = "abcbahellohowracecarareyouiloveuevoliiamaidoinggood";
        ArrayList<String> palendromes = findPalendromes(str);

        Collections.sort(palendromes, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return a.length() - b.length();
                }
            });

        System.out.println(palendromes.get(palendromes.size() - 1));
    }

    public static ArrayList<String> findPalendromes(String str) {
        ArrayList<String> palendromes = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String possibleLargest = str.substring(i, j);
                if (isPalendrome(possibleLargest) && possibleLargest.length() > 1) {
                    palendromes.add(possibleLargest);
                }
            }
        } 

        return palendromes;
    }

    public static boolean isPalendrome(String s) {
        if (s.length() < 2) {
            return true;
        } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalendrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
    }
}

