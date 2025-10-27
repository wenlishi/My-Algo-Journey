public class Solution_MyMethod {
    public int numberOfBeams(String[] bank) {
        // 存储结果和前一行的激光数
        int res = 0;
        int before = 0;
        // 遍历每一行
        for (int i = 0; i < bank.length; i++) {
            // 计算当前行的激光数
            int laser = 0;
            // 统计当前行中的'1',即激光
            for (char num :bank[i].toCharArray()) {
                if (num == '1') {
                    laser++;
                }
            }
            // 如果当前行有激光，则计算与前一行的激光数的乘积，并更新前一行的激光数
            if (laser != 0) {
                res += laser * before;
                before = laser;
            }
        }
        return res;
    }
}