package string;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Andrew on 2016/1/23.
 */
public class StringTest {

    public void stringToUpperCaseLocal(){
        System.out.println("title".toUpperCase(Locale.ROOT));
    }


    public void regExpUsedInFile(File file){

        String pattern = ".*feature.*";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while((str = br.readLine())!= null ){
                if (str.matches(pattern)){
                    System.out.println(str);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = new String("hello");
        System.err.println(str1 == str2);

        StringTest st = new StringTest();

        int b = 20;
        st.changeInt(b);
        System.out.println("b="+b);

        // recursion error using this
        ArrayList<InfiniteRecursionError> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(new InfiniteRecursionError());
        }
        System.out.println(arrayList);

        //use regExp in file
        st.regExpUsedInFile(new File("C:\\Python34\\NEWS.txt"));

        String a = new String("abc");
        st.change(a);
        System.out.println(a);

    }

    public void change(String a){
        a = "change";
    }

    public void changeInt(int a){a = 0;}

}

class InfiniteRecursionError{

    @Override
    public String toString() {
//        right way
        return "infiniteRecursion address: "+super.toString() +"\n";
//        return "infiniteRecursion address: "+this  +"\n";
    }
}