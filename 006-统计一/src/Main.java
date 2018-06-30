import java.util.Scanner;

/**
 * Author: 王俊超
 * Time: 2016-05-07 12:14
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
//            System.out.println(countOne(n));
//            System.out.println(countOne2(n));
            System.out.println(countOne3(n));
        }

        scanner.close();
    }

    /**
     * 统计1出现的次数
     * 见word解法一
     *
     * @param n 最大的数字
     * @return 1出现的次数
     */
    private static long countOne(long n) {
        long count = 0;
        for (int i = 0, j; i <= n; i++) {
            j = i;
            while (j != 0) {
                if (j % 10 == 1) {
                    count++;
                }
                j = j / 10;
            }
        }
        return count;
    }

    /**
     * 统计1出现的次数
     * 见word解法二
     *
     * @param n 最大的数字
     * @return 1出现的次数
     */
    private static long countOne2(long n) {
        if (n <= 0) {
            return 0;
        } else if (n < 10) {
            return 1;
        } else {
            long count = 0;

            // 最高位的数字
            long highest = n;
            // 数据位数-1
            int bit = 0;
            //代表最高位的权重，即最高位一个1代表的大小
            int power10 = 1;
            while (highest >= 10) {
                highest /= 10;
                bit++;
                power10 *= 10;
            }

            if (highest == 1) {
                count = countOne(power10 - 1)
                        + countOne(n - power10)
                        + n - power10 + 1;
            } else {
                count = highest * countOne(power10 - 1)
                        + countOne(n - highest * power10)
                        + power10;
            }
            return count;
        }
    }

    /**
     * 【最佳解法】
     * 统计1出现的次数
     * 见word解法三
     *
     * @param n 最大的数字
     * @return 1出现的次数
     */
    private static long countOne3(long n) {
        long count = 0;
        long i = 1;
        long current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;

            if (current > 1) {
                count = count + (before + 1) * i;
            } else if (current == 0) {
                count = count + before * i;
            } else if (current == 1) {
                count = count + before * i + after + 1;
            }
            i *= 10;
        }
        return count;
    }
}
