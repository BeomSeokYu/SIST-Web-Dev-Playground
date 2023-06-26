import java.util.Scanner;

public class Triangle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double base = sc.nextDouble();
    double height = sc.nextDouble();
    sc.close();
    double area = base * height / 2;
    System.out.println(area);
  }
}