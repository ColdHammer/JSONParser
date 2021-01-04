public class NumberNode implements VariableNode<Float>{
    float number;
    public NumberNode(float value) {
        super();
        number = value;
    }

    @Override
    public boolean push(char character) {
        return false;
    }

    public float getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public void set(Float value) {
        this.number = value;
    }

    @Override
    public Float get() {
        return number;
    }
}

