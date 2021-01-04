import com.sun.istack.internal.NotNull;

public class SIterator {
    private static SIterator sIterator= null;
    private SIterator() {

    }

    public static SIterator getIterator() {
        if(sIterator == null){
            sIterator = new SIterator();
        }
        return sIterator;
    }

    private static ACharStream charStream = null;

    public static void setCharStream(@NotNull ACharStream aCharStream){
        charStream = aCharStream;
    }

    @NotNull
    public char next()
    {
        if(charStream == null)
            return (char) 0;
        return charStream.next();
    }

    @NotNull
    public boolean hasNext()
    {
        if(charStream == null)
            return false;
        return charStream.hasNext();
    }
}
