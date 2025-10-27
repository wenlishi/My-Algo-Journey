import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {
    public boolean wordPattern(String pattern, String s) {
        // 创建两个映射表，分别用于字符到字符串和字符串到字符的映射
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();
        // 初始化索引和单词计数器
        int index = 0;
        int wordCount = 0;
        // 遍历模式字符串的每个字符
        for (int i = 0; i < pattern.length(); i++) {
            // 获取当前字符
            char cur = pattern.charAt(i);
            // 提取当前字符对应的单词
            StringBuilder word = new StringBuilder();
            // 使用while循环从字符串s中提取单词，直到遇到空格或字符串末尾
            while (index < s.length()) { 
                if (s.charAt(index) != ' ') {
                    word.append(s.charAt(index));
                    index++;
                } else {
                    index++;
                    break;
                }
            }
            // 增加单词计数器
            wordCount++;
            // 检查模式和字符串长度是否匹配,不匹配直接返回false
            if (index == s.length() && i != pattern.length() - 1 || wordCount == pattern.length() && index != s.length()) {
                return false;
            } 
            // 检查当前单词和字符的映射是否一致
            if (strToChar.containsKey(word.toString()) && strToChar.get(word.toString()) != cur) {
                return false;
            }
            // 检查当前字符和单词的映射是否一致
            if (charToStr.containsKey(cur) && !charToStr.get(cur).equals(word.toString())) {
                return false;
            }
            // 如果当前单词和字符没有映射关系，则建立新的映射。这一步if语句是多余的，因为前面的检查已经确保了映射关系的一致性。
            // if (!strToChar.containsKey(word.toString())) {
            //     strToChar.put(word.toString(), cur);
            //     charToStr.put(cur, word.toString());
            // }

            // 只有通过了以上检查，才会执行下面的put操作。
            // 由于之前的检查已经确保新旧值完全相同，所以这次覆盖是​​幂等​​的（即结果不变），不会影响映射的正确性。
            strToChar.put(word.toString(), cur);
            charToStr.put(cur, word.toString());
        }
        return true;
    }
}
