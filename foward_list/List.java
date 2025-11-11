package foward_list;
import java.util.NoSuchElementException;

public class List {
    private Node _head;
    private int _size;

    public List() {
        this._head = null;
        this._size = 0;
    }

    public int get_size() {
        return this._size;
    }

    public void list_push_front(int value) {

        this._head = new Node(this._head, value);
        this._size++;
    }

    public int list_pop_front() {
        if (this._head == null) {
            throw new NoSuchElementException("Error: popFront(): list is empty._");
        }
        int data = this._head.get_value();
        this._head = this._head.get_next();
        this._size--;

        return data;
    }

    public void list_push_back(int value) {
        this._size++;
        Node new_node = new Node(null, value);

        if (this._head == null) {
            this._head = new_node;
            return;
        }

        Node n = this._head;
        while (n.get_next() != null) {
            n = n.get_next();
        }

        n.set_next(new_node);
    }

    public int list_pop_back() {

        if (this._head == null)
            throw new NoSuchElementException("Error: popBack(): list is empty.");

        this._size--;
        if (this._head.get_next() == null) {
            int data = this._head.get_value();
            this._head = null;
            return data;
        }

        Node n = this._head;
        while (n.get_next().get_next() != null) {
            n = n.get_next();
        }

        int data = n.get_next().get_value();

        n.set_next(null);

        return data;
    }

    public void list_print() {
        Node n = this._head;

        while (n != null) {
            System.out.printf("%d\n", n.get_value());
            n = n.get_next();
        }
    }

    public List forward_list_clone() {
        List copy = new List();
        Node n = this._head;

        while (n != null) {
            copy.list_push_back(n.get_value());
            n = n.get_next();
        }

        return copy;
    }

}