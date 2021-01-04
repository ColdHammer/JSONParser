public interface VariableNode<T> extends Node {
    void set(T value);
    T get();
}
