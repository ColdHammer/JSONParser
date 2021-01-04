import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;

public class ObjectNode extends HashMap<String, Node> implements Node{
    public ObjectNode() {
        super();
    }

    private boolean isString = false;
    private String str = "";

    private boolean isValue = false;
    private String var_name = "";
    private String var_value = "";
    @Override
    public boolean push(char character) {
        //Returns true while the variable has next
        if(character == '\"'){
            isString = !isString;
            return true;
        }

        if(isString){
            if(isValue) {
                var_value += character;
            }else{
                var_name += character;
            }
            return true;
        }

        if (character == ' ' || character == '\t' || character == '\n'){
            return true;
        }

        switch(character){
            case '}':
                if(var_name != "" && var_value != ""){
                    put(var_name, Node.getNode(var_value));
                    var_name = "";
                    var_value = "";
                    isValue = false;
                }
                return false;
            case '{':
                ObjectNode node = new ObjectNode();
                Node.setNode(node);
                put(var_name, node);

                var_name = "";
                isValue = false;
                break;
            case '[':
                ArrayNode arrayNode = new ArrayNode();
                Node.setNode(arrayNode);
                put(var_name, arrayNode);
                var_name = "";
                isValue = false;
                break;
            case ',':
                if(var_name != "" && var_value != ""){
                    put(var_name, Node.getNode(var_value));
                    var_name = "";
                    var_value = "";
                    isValue = false;
                }
                break;
            case ':':
                isValue = true;
                break;
            default:
                if(isValue)
                {
                    var_value += character;
                }else{
                    var_name += character;
                }
                break;
        }
        return true;
    }

    @Override
    public String toString() {
        String text = "{";
        boolean first = true;
        for (String str : keySet()){
            if(first)
            {
                text += concatenate("\"", str, "\""," : ", get(str).toString());
                first = false;
            }else{
                text += concatenate(",\"", str, "\""," : ", get(str).toString());
            }
        }
        text += "}";
        return text;
    }

    private String concatenate(String... values)
    {
        String str = "";
        for(String string : values)
        {
            str += string;
        }
        return str;
    }
}
