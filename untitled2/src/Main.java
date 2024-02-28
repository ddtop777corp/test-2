import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число декабря");
        int day = scanner.nextInt();
        int remains = 31 - day;
        System.out.println("До Нового Года осталось" + remains);
    }
}