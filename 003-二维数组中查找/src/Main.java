import java.util.Scanner;

/**
 * @Author 刘俊重
 * @Date 2018/7/1
 * 思路：二维数组中最右边的数是一行中最大的数，是一列中最小的数。
 * 根据这个规律，如果要查找的数跟最右边的数相等，则查找成功；
 * 如果要查找的数比最右边的数小，那么剔除最右边数所在的列；
 * 如果要查找的数比最右边的数大，那么剔除最右边数所在的行。
 */
public class Main {

    /**
     * @param matrix 输入的二维数组
     * @param num 要查找的目标数字
     * @return 返回是否查找到，true为找到，false为未找到
     */
    public static boolean find(int[][] matrix,int num){
        //数组为空
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        //数组的行号
        int rows = matrix.length;
        //数组的列号
        int cols = matrix[0].length;

        //初始的行号和列号（即第一行最右边的数字）
        int row = 0;
        int col = cols-1;
        //确保在二维数组范围内循环
        while(row>=0 && row<rows && col>=0 && col<cols){
            if(matrix[row][col] == num){
                return true;
            }else if(matrix[row][col]>num){
                col--;
            }else if(matrix[row][col]<num){
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));    // 要查找的数在数组中
        System.out.println(find(matrix, 5));    // 要查找的数不在数组中
        System.out.println(find(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println(find(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println(find(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println(find(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println(find(null, 16));     // 健壮性测试，输入空指针

    }
}
