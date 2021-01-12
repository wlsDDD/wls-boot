package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1370 {
    
    @Test
    public void test01() {
        String s = sortString("fgpsuwxpo");
        System.out.println("s = " + s);
    }
    
    public String sortString(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<Character> list = new ArrayList<>(s.length());
        for (char aChar : chars) {
            list.add(aChar);
        }
        while (list.size() > 0) {
            ans.append(list.get(0));
            list.remove(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > ans.charAt(ans.length() - 1)) {
                    ans.append(list.get(i));
                    list.remove(i);
                    i = -1;
                }
            }
            if (list.size() == 0) {
                break;
            }
            ans.append(list.get(list.size() - 1));
            list.remove(list.size() - 1);
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) < ans.charAt(ans.length() - 1)) {
                    ans.append(list.get(i));
                    list.remove(i);
                    i = list.size();
                }
            }
        }
        return ans.toString();
    }
    
}