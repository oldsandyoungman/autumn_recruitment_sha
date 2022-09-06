package com.shasha.s20220720;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author ShaLuwei
 * @create 2022-07-20 20:58
 */
public class Test_URL_download {

    @Test
    public void download() throws IOException {

//        https://c-ssl.duitang.com/uploads/item/201710/21/20171021211119_x2wWB.jpeg

        URL url = new URL("https://c-ssl.duitang.com/uploads/item/201710/21/20171021211119_x2wWB.jpeg");

        HttpURLConnection uc = (HttpURLConnection) url.openConnection();

        uc.connect();

        InputStream is = uc.getInputStream();

        FileOutputStream fos = new FileOutputStream("ppig.jpeg");

        int len = 0;
        byte[] buffer = new byte[5];
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        fos.close();
        is.close();
        uc.disconnect();

    }

}
