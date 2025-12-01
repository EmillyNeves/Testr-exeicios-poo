import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        Dobro d = new Dobro(sc.nextInt());
        System.out.println(d.calculaDobro());

        sc.close();
    }
}
