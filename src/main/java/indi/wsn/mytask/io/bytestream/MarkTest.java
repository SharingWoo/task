package indi.wsn.mytask.io.bytestream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileName: MarkTest.java
 * 类的详细说明
 *
 * @author SharingWoo
 * @version 1.00
 * @Date 2017/4/13
 */
public class MarkTest {

    public static void main(String[] args) throws IOException {
        String string = "1234567890qwe";
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());

        int chara;
        boolean isContinued = false;

        while ((chara = inputStream.read()) != -1) {
            System.out.print((char) chara);
            if (((char) chara == '9') && !isContinued) {
                inputStream.mark(string.length());
                isContinued = true;
            }
            if (((char) chara == 'w') && isContinued) {
                inputStream.reset();
                isContinued = false;
            }
        }
    }
}
