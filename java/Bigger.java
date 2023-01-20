import java.util.Scanner;

public class Bigger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if(num1 > num2) {
            System.out.println("num1 (" + num1 + ")이 더 큼");
        } else if(num2 > num1) {
            System.out.println("num2 (" + num2 + ")이 더 큼");
        } else {
            System.out.println("두 수가 같음");
        }
    }
}
