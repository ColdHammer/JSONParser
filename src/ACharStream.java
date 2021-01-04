import java.util.Iterator;
import java.util.function.Consumer;

public abstract class ACharStream implements Iterable<Character>{
    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            @Override
            public boolean hasNext() {
                return ACharStream.this.hasNext();
            }

            @Override
            public Character next() {
                return ACharStream.this.next();
            }
        };
    }

    public abstract boolean hasNext();
    public abstract Character next();

    @Override
    public void forEach(Consumer<? super Character> consumer) {
        while(hasNext()){
            consumer.accept(next());
        }
    }
}
