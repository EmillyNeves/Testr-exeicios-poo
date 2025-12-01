public class BtNode {
    private int _value;
    private BtNode _left;
    private BtNode _right;

    public BtNode(int value, BtNode l, BtNode r) {
        this._value = value;
        this._right = r;
        this._left = l;
    }

    public int get_value() {
        return this._value;
    }

    public BtNode get_right() {
        return this._right;
    }

    public BtNode get_left() {
        return this._left;
    }

    public void set_left(BtNode node) {
        this._left = node;
    }

    public void set_right(BtNode node) {
        this._right = node;
    }

}
