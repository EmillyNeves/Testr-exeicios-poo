import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n, value;
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            value = sc.nextInt();
            bt.binary_tree_add(value);
        }

        System.out.printf("%d\n", bt.binary_tree_min());
        System.out.printf("%d\n", bt.binary_tree_max());

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            value = sc.nextInt();
            if (bt.binary_tree_exists(value) == 1)
                System.out.printf("EXISTE\n");
            else
                System.out.printf("NAO EXISTE\n");
        }
        sc.close();
    }
}