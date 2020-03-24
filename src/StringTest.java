/**
 * string 在java中的生成
 * https://www.cnblogs.com/xiaoxi/p/6036701.html
 */
public class StringTest {

    public static void main(String[] args) {

        String s1 = new String("987654321");
        String s2 = new String("987654321");
        String s3 = "987654321";
        String s4 = "987654321";

        System.out.println("s1.equals(s2) : " + s1.equals(s2));
        System.out.println("s2 == s1 : " + (s2 == s1));

        System.out.println("s3.equals(s1) : " + s3.equals(s1));
        System.out.println("s3 == s1 : " + (s3 == s1));

        System.out.println("s3 == s4 : " + (s3 == s4));

        System.out.println("===============================================");
        String str2 = new String("str")+new String("01");

        //交换下面两行代码，结果不同
        str2.intern();
        String str1 = "str01";

        System.out.println(str2 == str1);

    }

}
