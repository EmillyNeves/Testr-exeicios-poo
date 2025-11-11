package foward_list;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int qtd_num = sc.nextInt();
        List l = new List();

        for (int value, i = 0; i < qtd_num; i++) {
            value = sc.nextInt();
            l.list_push_front(value);
        }

        List clone = l.forward_list_clone();

        while (0 < clone.get_size()) {
            
            System.out.println(clone.list_pop_front());
        }
        sc.close();
    }
}