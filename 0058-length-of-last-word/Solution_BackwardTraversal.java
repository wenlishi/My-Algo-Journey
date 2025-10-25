public class BackwardTraversal {
    public int lengthOfLastWord (string s) {
        int wordLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                wordLength++;
            }
            if (wordLength != 0 && s.charAt(i) == ' ') {
                break;
            }
        }
        return wordLength;
    }
}