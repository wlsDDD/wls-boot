package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution767 {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        map.entrySet().stream().sorted((o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1).
                collect(Collectors.toList()).forEach(e -> linkedHashMap.put(e.getKey(), e.getValue()));
        return "";
        
    }
}