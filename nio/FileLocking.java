package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream(new File("d:\\test.txt"));
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null){
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(1000);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
