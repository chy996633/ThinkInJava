package sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array, int p, int r){
        if (p < r){
            int q = (r + p) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q+1, r);
            merge(array, p,q,r);
        }
    }

    public static void merge(int[] array, int p, int q, int r){
        int m = q-p+1;
        int n = r-q;
        int[] leftArray = new int[m+1];
        int[] rightArray = new int[n+1];
        for (int i = 0;i < m;i++){
            leftArray[i] = array[p+i];
        }
        for (int j = 0;j < n;j++){
            rightArray[j] = array[q+j+1];
        }
        leftArray[m] = 99999999;
        rightArray[n] = 99999999;
        int i=0;
        int j=0;
        for (int k=p; k<=r;k++){
            if (leftArray[i] < rightArray[j]){
                array[k] = leftArray[i];
                i++;
            }else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,7,2,6,4};
        MergeSort.mergeSort(array,0,6);
        System.out.println(Arrays.toString(array));
    }

}
