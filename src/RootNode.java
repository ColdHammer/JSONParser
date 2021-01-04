public class RootNode implements Node{
    ObjectNode objectNode;
    private RootNode() {
        super();
    }

    public static ObjectNode GetNode(ACharStream charStream)
    {
        SIterator.setCharStream(charStream);
        RootNode node = new RootNode();
        Node.setNode(node);
        return node.objectNode;
    }

    @Override
    public boolean push(char character) {
        switch (character){
            case '{':
                objectNode = new ObjectNode();
                Node.setNode(objectNode);

                return true;
            default:
                return false;
        }
    }

    public ObjectNode getRootNode()
    {
        return objectNode;
    }

    @Override
    public String toString() {
        return objectNode.toString();
    }
}
