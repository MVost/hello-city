import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cityName = null;
        System.out.print("По возможности, введите идентификатор часового пояса (например, Europe/Kiev или Asia/Tbilisi)\n" +
                "иначе, введите оригинальное название города на английском языке (Kiev, Tbilisi): ");
        cityName = sc.next();

        HelloCity helloCity = new HelloCity(cityName);
        System.out.println(helloCity.getHello());
    }
}
