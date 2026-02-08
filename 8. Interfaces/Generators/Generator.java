public interface Generator<T> {
    void reset();
    boolean is_over();
    T next();
}