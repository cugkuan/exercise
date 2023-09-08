package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Test2 {

    public static int getNum(String s) {
        if (Objects.equals(s, "J")) {
            return 10;
        } else if (Objects.equals(s, "Q")) {
            return 11;
        } else if (Objects.equals(s, "K")) {
            return 12;
        } else if (Objects.equals(s, "A")) {
            return 13;
        } else {
            return Integer.parseInt(s);
        }
    }

    public static int[] exe(String input) {
        int[] cards = new int[13];
        Arrays.fill(cards, 0);
        String[] strings = input.split(",");

        int[] current = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int num = getNum(s.substring(1, 2));
            cards[num - 2] += 1;
            current[i] = num;
        }

        int c = 0;
        int j = current.length - 1;

        while (j > 0) {
            if (current[j] < current[j - 1]) {
                c++;
            }
        }


        return cards;

    }

    public static String ex(String input) {
        String[] strings = input.split(",");
        if (strings.length < 2) {
            return "Y";
        }
        int[] current = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int num = getNum(s.substring(1, 2));
            current[i] = num;
        }
        int c = 0;
        int j = current.length - 1;
        while (j > 0) {
            if (current[j] <= current[j - 1]) {
                c++;
            }
            j--;
        }
        return c % 2 == 1 ? "Y" : "N";
    }

    public static String ex2(String input) {
        String[] strings = input.split(",");
        if (strings.length < 2) {
            return "Y";
        }
        int[] current = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int num = getNum(s.substring(1, 2));
            current[i] = num;
        }
        int i = 0;
        int j = 1;
        int n = current.length;
        int count = 0;
        while (j < n) {
            if (current[i] >= current[j]) {
                j++;
                count++;
            } else {
                i = j;
                j = j + 1;
            }
        }
        return count % 2 == 1 ? "Y" : "N";
    }


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();
        System.out.println(ex2(first));
        System.out.println(ex2(second));

    }
}
