package holding;

import java.util.*;

/**
 * Created by Andrew on 2016/2/19.
 */
public class P22 {

    public static void main(String[] args) {
        ArrayList<String> list = new TextFile("E:\\My_code\\Java\\ThinkInJava\\src\\holding\\P22.java", "\\W+");
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        Set<WordAndTimes> set = new HashSet<>();
        for (String s: list){
            Iterator<WordAndTimes> itr = set.iterator();
            int i=0;
            while(itr.hasNext()){
                WordAndTimes wat = itr.next();
                if(wat.getWord().equals(s))
                    i++;
            }
            if (i==0){
                WordAndTimes wat = new WordAndTimes();
                wat.setWord(s);
                wat.setTimes(1);
                set.add(wat);
            }else{
                Iterator<WordAndTimes> itrtemp = set.iterator();
                while(itrtemp.hasNext()){
                    WordAndTimes wat = itrtemp.next();
                    if(wat.getWord().equals(s))
                        wat.setTimes(wat.getTimes()+1);
                }
            }
        }
        System.out.println(set);

    }

}

class WordAndTimes{
    private String word;
    private Integer times;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return word +":"+times;
    }
}