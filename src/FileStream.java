import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileStream extends ACharStream{
    FileInputStream inputStream;
    public FileStream(String path) throws FileNotFoundException
    {
        File file = new File(path);
        if (!file.exists()) throw new FileNotFoundException(String.format("The file %0$s doesn't exist.", path));
        inputStream = new FileInputStream(file);
    }
    @Override
    public boolean hasNext() {
        try {
            return inputStream.available() >= 1;
        }catch (IOException e)
        {
            return false;
        }
    }

    byte[] buffer = new byte[1];
    @Override
    public Character next() {
        try {
            inputStream.read(buffer);
            return (new String(buffer, StandardCharsets.UTF_8)).toCharArray()[0];
        }catch(IOException e)
        {
            return 0;
        }
    }

    public void close()
    {
        try {
            inputStream.close();
        } catch (IOException e) {

        }
    }
}
