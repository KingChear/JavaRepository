public class Algorithm {

    private static Algorithm instance = new Algorithm();

    private Algorithm() {

    }

    public static Algorithm getInstance() {
        return instance;
    }

    /**
     * 给定一个n * m的矩阵，从此矩阵的左下角走到右上角，只能往右与往上，有多少种走法
     *
     * 每个小矩阵的值为相邻的两个矩阵的值相加，如果m或n其中一个为1，则其值就为1,
     * 例如3 * 4，相邻的矩阵为3 * 3和2 * 4，则n * m，相邻的矩阵为(n - 1) * m和n * (m - 1)
     * 则3 * 4的结果值就为3 * 3 + 2 * 4，继续展开2 * 3 + 3 * 2 + 1 * 4 + 2 * 3，继续展开…………
     * 采用递归的思想来解
     *
     * @param n
     * @param m
     * @return
     */
    public int leftBottomToRightTop(int n, int m) {

        if (n == 1 || m == 1) {
            return 1;
        } else {
            return (leftBottomToRightTop(n -1, m) + leftBottomToRightTop(n, m - 1));
        }
    }

    /**
     * 爬楼梯算法：已知一个楼梯有n个台阶，每次可以选择迈上一个或者两个台阶，求走完一共有多少种不同的走法
     * @param n
     * @return
     */
    public int climbFloor(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbFloor(n - 1) + climbFloor(n - 2);
    }

    /**
     * 给出一个正整数n，这个正整数可以由若干个数按照一定的顺序相加得到，求有多少种一定顺序的若干个数相加而得到n的情况
     * 举例：正整数4
     * 1、1 + 1 + 1 + 1
     * 2、1 + 3
     * 3、3 + 1
     * 4、1 + 2 + 1
     * 5、1 + 1 + 2
     * 6、2 + 1 + 1
     * 7、4
     * 8、2 + 2
     * 综上例子，正整数n如果是4的话，则有8种情况
     *
     * @param n
     * @return
     */
    public int addNumber(int n) {
        int result = 0;  // 最后的结果
        if (n == 0) {
            return 1;
        }
        // 从1开始循环递减，直到0
        for (int i = 1; i <= n; i++) {
            result += addNumber(n - i);
        }
        return result;
    }

}
