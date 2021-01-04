import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayNode extends ArrayList<Node> implements Node{
    public ArrayNode() {
        super();
    }
    String text = "";
    boolean isText = false;
    @Override
    public boolean push(char character) {
        if(character == '\"')
        {
            isText = !isText;
            return true;
        }
        if(isText)
        {
            text += character;
            return true;
        }
        if(character == ' ' || character == '\n' || character == '\t') return true;
        switch (character)
        {
            case ']':
                if(text != "") {
                    add(Node.getNode(text));
                    text = "";
                }
                return false;
            case ',':
                if(text != "") {
                    add(Node.getNode(text));
                    text = "";
                }
                break;
            case '{':
                ObjectNode objectNode = new ObjectNode();
                Node.setNode(objectNode);
                add(objectNode);
                break;
            case '[':
                ArrayNode arrayNode = new ArrayNode();
                Node.setNode(arrayNode);
                add(arrayNode);
                break;
            default:
                text += character;
        }
        return true;
    }

    @Override
    public String toString() {
        String text = "[";
        boolean first = true;
        for(Node node : this)
        {
            if(first)
            {
                text += node.toString();
                first = false;
            }else{
                text += ", " + node.toString();
            }
        }
        text += ']';
        return text;
    }
}
