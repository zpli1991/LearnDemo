package algorithm;

/**
 * @Description: 不用加减乘除做加法
 * @author: zpli
 * @Date: 2020/6/10 10:36
 */
public class Add {

    public static void main(String[] args) {
        System.out.println(add(7, 5));
    }

    /**
     * 不用加减乘除做加法
     */
    public static int add(int n1, int n2) {
        int sum, carry;
        do {
            // 利用异或，每位相加，此时不考虑进位
            // 比如1+2,0001 + 0011,0001^0011=0010，右起第一位1+1复合二进制进位要求，进位后的结果是0
            sum = n1 ^ n2;

            // 利用按位与，并左移，相当于进位
            // 0001&0011=0001，右起第一位1+1复合二进制进位要求，需向左进一位，所以需要左移
            carry = (n1 & n2) << 1;

            // 将上面的结果重复操作，因为进位后可能还需要再向前进一位
            n1 = sum;
            n2 = carry;

            // 当无需进位时，停止运算
        } while (n2 != 0);
        return sum;
    }

}






