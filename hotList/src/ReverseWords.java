import java.util.*;

/*
* https://leetcode.cn/problems/reverse-words-in-a-string/
* */
public class ReverseWords {
    public String reverseWords(String s) {
        String trimed = s.trim();
        List<String> strings = Arrays.asList(trimed.split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }
}
