public class Node {
    private int _value;
    private Node _next;

    public Node(Node next,int value) {
        this._value = value;
        this._next = next;
    }

    public void set_value(int value) {
        this._value = value;
    }

    public void set_next(Node next) {
        this._next = next;
    }

    public Node get_next() {
        return this._next;
    }

    public int get_value() {
        return this._value;
    }
}