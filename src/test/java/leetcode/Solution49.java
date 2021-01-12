package leetcode;


import org.junit.jupiter.api.Test;

import java.util.*;

class Solution49 {
    
    @Test
    public void test01() {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> list = groupAnagrams(strings);
        System.out.println("list = " + list);
    
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>(strs.length);
        Map<String, Integer> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            Integer index = map.get(Arrays.toString(chars));
            if (index == null) {
                map.put(Arrays.toString(chars), list.size());
                List<String> strings = new ArrayList<>();
                strings.add(str);
                list.add(strings);
            } else {
                List<String> strings = list.get(index);
                strings.add(str);
            }
        }
        return list;
    }
}