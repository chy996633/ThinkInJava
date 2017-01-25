package sort;

import java.util.Arrays;

/**
 * Created by Andrew on 2017/1/25.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{2,8,7,1,3,5,6,4};
        QuickSort qsort = new QuickSort();
        qsort.sort(a,0,a.length-1);

    }

    public void sort(int[] array,int p, int r){
        if (p<r) {
            int q = partition(array,p,r);

            System.out.println("a:"+ Arrays.toString(array) +" q:"+q);

            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }

    private int partition(int[] array, int p, int r) {
        int x = array[r];
        int i= p-1;
        for (int j=p;j<=r-1;j++){
            if (array[j] <= x ){
                i ++ ;
                exchange(array,i,j);
            }
        }
        exchange(array,i+1,r);

        return i+1;
    }

    private void exchange(int[] array, int i, int j) {
        int temp =array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
