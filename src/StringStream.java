public class StringStream extends ACharStream{
    int i = 0;
    char[] characters;

    public StringStream(String str){
        characters = str.toCharArray();
    }

    @Override
    public boolean hasNext() {
        if(i<characters.length)
            return true;
        return false;
    }

    @Override
    public Character next() {
        return characters[i++];
    }
}