package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/16 18:14
 */
public class AllPLDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Random random = new Random();

        String str = "ABC";
        StringBuilder sb;
        for (int i = 0, len = str.length(); i < str.length(); i++) {
            sb = new StringBuilder();
            String c = String.valueOf(str.charAt(random.nextInt(len)));
            if (sb.indexOf(c) != -1) {

            }
        }
    }
}
