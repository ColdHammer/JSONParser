import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;

public interface Node {
    boolean push(char character);

    static void setNode(@NotNull Node node)
    {
        SIterator sIterator = SIterator.getIterator();
        while(sIterator.hasNext())
        {
            char next = sIterator.next();
            if(!node.push(next)){
                break;
            }
        }
    }

    static @NotNull
    Node getNode(@NotNull String value)
    {
        try{
            IntNode intNode = new IntNode(Integer.valueOf(value));
            return intNode;
        }catch (Exception e){}
        try{
            NumberNode numberNode = new NumberNode(Float.parseFloat(value));
            return numberNode;
        }catch (Exception e) {}
        return new StringNode(value);
    }
}
