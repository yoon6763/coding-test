package programmers.lv2;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        stackSetAndMap(str1, set1, map1);
        stackSetAndMap(str2, set2, map2);

        HashSet<String> union = new HashSet<>(set1);
        union.addAll(set2);

        HashSet<String> inter = new HashSet<>(set1);
        inter.retainAll(set2);

        int unionLength = 0;
        int interLength = 0;

        for (String str : union) {
            unionLength += Math.max(map1.getOrDefault(str, 0), map2.getOrDefault(str, 0));
        }

        for (String str : inter) {
            interLength += Math.min(map1.get(str), map2.get(str));
        }

        if (unionLength == 0) return 65536;
        return (int) (((double) interLength / unionLength) * 65536);
    }

    void stackSetAndMap(String str, HashSet<String> set, HashMap<String, Integer> map) {
        str = str.toUpperCase();

        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            if (!valid(sub)) continue;
            set.add(sub);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
    }

    boolean valid(String str) {
        char first = str.charAt(0);
        char second = str.charAt(1);
        return first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z';
    }
}