package algorithm;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/11 10:36
 */
public class ReplaceBlankStr {

    public static void main(String[] args) {
        System.out.println(replaceBlankStr("We Are Happy"));
    }

    private static String replaceBlankStr(String str){
        StringBuffer sb = new StringBuffer();
        for (int i=0,len=str.length();i<len;i++){
            if(str.charAt(i)==' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
