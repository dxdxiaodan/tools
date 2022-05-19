import utils.UuidUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SerialFileGenerate {
    public static void main(String[] args) {
        //int max = 2000000;
        try{
            long l = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis());
            int max = 1000000;
            String pre="207-R02-";
            testCreateFile(max, "."+File.separator+"serial number1.txt",pre);
            long l1 = System.currentTimeMillis();
            System.out.println(l1-l);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    static void testCreateFile(int max,String FILE_NAME,String pre) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
        FileChannel channel = fos.getChannel();
        StringBuffer content = new StringBuffer();
        while(max > 0) {
            String uuid = pre + UuidUtil.generateShortUuid();
            content.append(uuid).append("\r\n");
            content.append(uuid).append("\r\n");
            max --;
        }
        ByteBuffer buf = ByteBuffer.wrap(content.toString().getBytes());
        buf.put(content.toString().getBytes());
        buf.flip();
        channel.write(buf);
        channel.close();
        fos.close();
    }
}
