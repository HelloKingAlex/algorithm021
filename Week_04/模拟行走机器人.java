// LeetCode 874
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int x = 0, y = 0, direction = 0;
        int[][] directions = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}};

        // 用 set 存储障碍物的坐标
        Set<String> obstaclesSet = new HashSet<String>();
        for (int[] obs : obstacles) {
            obstaclesSet.add(obs[0] + "," + obs[1]);
        }

        // 0,1,2,3
        // N,E,S,W
        //   N
        // W   E
        //   S
        //////////
        //   0
        // 3   1
        //   2
        for (int command : commands) {
            if (command == -2) {
                // <-
                direction = (direction == 0) ? 3 : direction - 1;
            } else if (command == -1) {
                // ->
                direction = (direction == 3) ? 0 : direction + 1;
            } else {
                // 小坑点
                // 忘记用括号区分要加在一起的字符串了
                while (command-- > 0
                        && !obstaclesSet.contains(
                        (x + directions[direction][0])
                                + ","
                                + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                }
                // 更新最大距离
                result = Math.max(result, x * x + y * y);
            }
        }
        return result;
    }
}