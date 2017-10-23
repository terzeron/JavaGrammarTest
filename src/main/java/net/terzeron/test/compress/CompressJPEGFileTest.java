package net.terzeron.test.compress;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.ImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/**
 * Created by terzeron on 2016. 8. 23..
 */
public class CompressJPEGFileTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File imageFile = new File("desert.jpg");
        File compressedImageFile = new File("compressed_file.jpg");

        InputStream is = new FileInputStream(imageFile);
        OutputStream os = new FileOutputStream(compressedImageFile);

        float imageQuality = 0.3f;
        // 버퍼드 이미지 생성
        BufferedImage bufferedImage = ImageIO.read(is);
        // image writers 생성
        Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("jpg");
        if (!imageWriters.hasNext()) {
            throw new IllegalStateException("Writers Not Found");
        }

        ImageWriter imageWriter = (ImageWriter) imageWriters.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        imageWriter.setOutput(ios);
        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();

        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(imageQuality);

        // created image
        imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);

        // close all streams
        is.close();
        os.close();
        ios.close();
        imageWriter.dispose();
    }
}
