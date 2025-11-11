package bt;
import java.util.NoSuchElementException;

public class BinaryTree {
    private BtNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void binary_tree_add(int value) {
        BtNode novo_n = new BtNode(value, null, null);

        if (this.root == null) {
            this.root = novo_n;
        } else {
            BtNode node = this.root;

            while (node != null) {
                if (value == node.get_value()) {
                    break;
                } else if (value < node.get_value()) {
                    if (node.get_left() == null) {
                        node.set_left(novo_n);
                        break;
                    } else
                        node = node.get_left();
                } else {
                    if (node.get_right() == null) {
                        node.set_right(novo_n);
                        return;
                    } else
                        node = node.get_right();

                }
            }
        }
    }

    public int binary_tree_exists(int val) {
        BtNode n = this.root;

        while (n != null) {
            if (val == n.get_value())
                return 1;
            else if (val < n.get_value())
                n = n.get_left();
            else
                n = n.get_right();
        }

        return 0;
    }

    public int binary_tree_min() {
        if (this.root == null)
            throw new NoSuchElementException("Error: empty tree\n");

        BtNode n = this.root;

        while (n.get_left() != null)
            n = n.get_left();

        return n.get_value();
    }

    public int binary_tree_max() {
        if (this.root == null)
            throw new NoSuchElementException("Error: empty tree\n");

        BtNode n = this.root;

        while (n.get_right() != null)
            n = n.get_right();

        return n.get_value();
    }

}