package algorithm;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/11 10:20
 */
public class Str2Int {

    public static void main(String[] args) {
        System.out.println(str2Int("-1205"));
    }

    public static int str2Int(String str) {
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        int flag = 0;

        if (str.charAt(0) == '+')
            flag = 1;
        if (str.charAt(0) == '-')
            flag = 2;
        int start = flag > 0 ? 1 : 0;
        int res = 0;
        while (start < str.length()) {
            if (str.charAt(start) < '0' || str.charAt(start) > '9') {
                return 0;
            }
            res = res * 10 + (str.charAt(start) - '0');
            start++;
        }
        return flag == 2 ? -res : res;
    }
}
