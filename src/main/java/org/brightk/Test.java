package org.brightk;

public class Test {

    public void print(){

    }
    public int print2(){

        return  0;
    }

    public void print3(int a,String b){

    }

    public static void main(String[] args){

        byte a  = 127;
        byte b = (byte) 1;
        int c  =  ((a+b) & 0xff);

        System.out.println(a);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);
        System.out.println((++a & 0xff)%5);

        while (true) {
            System.out.println((++a & 0xff) % 5);
        }

    }
}
