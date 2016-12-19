package chapter18;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrew on 2016/1/12.
 */
public class Practise7 {

    public static void main(String[] args) {
//      Practise7.practise_9();
        Practise7.practise_10("java");

    }

    public void practise_7(){
        File file = new File("./.project");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            LinkedList<String> list = new LinkedList<>();
            String str;
            while((str = br.readLine() )!= null){
                list.push(str);
            }
            while((str = list.poll()) != null ){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not fount");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void practise_8(String[] args){
        if(args.length != 0 && args[0] != null){
            File file = new File(args[0]);
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                LinkedList<String> list = new LinkedList<>();
                String str;
                while((str = br.readLine() )!= null){
                    list.push(str);
                }
                while((str = list.poll()) != null ){
                    System.out.println(str);
                }

            } catch (FileNotFoundException e) {
                System.out.println("file not fount");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("please enter the file name through args");
        }
    }

    public static void practise_9(){
        File file = new File("./.project");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            LinkedList<String> list = new LinkedList<>();
            String str;
            while((str = br.readLine() )!= null){
                list.push(str.toUpperCase());
            }
            while((str = list.poll()) != null ){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not fount");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void practise_10(String filterWord){
        File file = new File("./.project");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            LinkedList<String> list = new LinkedList<>();
            String str;
            while((str = br.readLine() )!= null){
                list.push(str);
            }
            while((str = list.poll()) != null ){
                if(str.contains(filterWord))
                    System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not fount");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
