package algorithm;

/**
 * @Description: 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
 * @author: zpli
 * @Date: 2020/6/12 15:43
 */
public class OneToNNumber {

    public static void main(String[] args) {
        printOneToN(3);
    }

    private static void printOneToN(int number) {
        int i = 0, num = 1;
        while (i < number) {
            num *= 10;
            i++;
        }

        for (int j = 1; j < num; j++) {
            System.out.print(j + " ");
            if (j % 10 == 0)
                System.out.println();
        }
    }
}
