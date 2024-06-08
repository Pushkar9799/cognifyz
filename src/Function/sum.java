package Function;

import java.util.Scanner;

public class sum {
    public static int cal(int a, int b, int c) {
        int sum = a + b + c;
        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int sum = cal(a, b, c);
        System.out.println(sum);
    }
}
