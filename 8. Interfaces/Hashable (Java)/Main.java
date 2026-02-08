import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Point2D, String> map = new HashMap<>();
        double x;
        double y;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            String value = sc.next();
            Point2D point = new Point2D(x, y);
            map.put(point, value);
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            Point2D point = new Point2D(x, y);
            String result = map.get(point);

            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("NAO_EXISTE");
            }
        }

        sc.close();
    }
}