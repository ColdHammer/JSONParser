public class IntNode implements VariableNode<Integer>{
    int value;
    public IntNode(int value) {
        super();
        this.value = value;
    }

    @Override
    public boolean push(char character) {
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public void set(Integer value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }
}
