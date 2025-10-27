public class Solution_FluentAPI​​ {
    public int numberOfBeams(String[] bank) {
        int res = 0, before = 0;
        for (String row : bank) {
            // 下面这一行使用了Java的流式API来计算当前行中'1'的数量chars()返回一个IntStream，filter()用于过滤出等于'1'的字符，最后count()计算数量
            int laser = (int) row.chars().filter(c -> c == '1').count();
            if (laser != 0) {
                res += laser * before;
                before = laser;
            }
        }
        return res;
    }
}