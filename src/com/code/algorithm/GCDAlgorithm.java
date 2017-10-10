package com.code.algorithm;

public class GCDAlgorithm {

    public static int euclid(int a, int b){
        if (a % b == 0){
            return b;
        }else if (b % a == 0){
            return a;
        }
        return a > b ? euclid(a % b , b) : euclid(b % a, a);
    }

    public static int chineseEuclid(int a, int b){
        if (a % b == 0){
            return b;
        }else if (b % a == 0){
            return a;
        }
        return a > b ? chineseEuclid(b, a-b) : chineseEuclid(a, b - a);
    }

    public static int anotherVersion(int a, int b){
        if (b > a){
            return anotherVersion(b, a);
        }
        if (a % b == 0){
            return b;
        }
        if (!isOdd(a) && !isOdd(b)){
            return euclid(a >> 1, b >> 1) << 1;
        }else if (!isOdd(a) && isOdd(b)){
            return euclid(a >> 1, b);
        }else if (isOdd(a) && !isOdd(b)){
            return euclid(a, b >> 1);
        }else {
            return euclid(b, a-b);
        }
    }

    public static boolean isOdd(int i){
        return (i & 1) != 0;
    }


    public static void main(String[] args) {
        System.out.println(GCDAlgorithm.euclid(30,25));
        System.out.println(GCDAlgorithm.chineseEuclid(30,25));
        System.out.println(GCDAlgorithm.anotherVersion(30,25));
        System.out.println(GCDAlgorithm.euclid(30,23));
        System.out.println(GCDAlgorithm.chineseEuclid(30,23));
        System.out.println(GCDAlgorithm.anotherVersion(30,23));
        System.out.println(GCDAlgorithm.euclid(30,20));
        System.out.println(GCDAlgorithm.chineseEuclid(30,20));
        System.out.println(GCDAlgorithm.anotherVersion(30,20));
        System.out.println(GCDAlgorithm.euclid(20,30));
        System.out.println(GCDAlgorithm.chineseEuclid(20,30));
        System.out.println(GCDAlgorithm.anotherVersion(20,30));
        System.out.println(GCDAlgorithm.euclid(1,30));
        System.out.println(GCDAlgorithm.chineseEuclid(1,30));
        System.out.println(GCDAlgorithm.anotherVersion(1,30));
    }


}
