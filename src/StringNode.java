public class StringNode implements VariableNode<String>{
    String value;
    public StringNode(String value) {
        super();
        this.value = value;
    }

    @Override
    public boolean push(char character) {
        return false;
    }

    @Override
    public String toString() {
        return '\"' + value + '\"';
    }

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}
