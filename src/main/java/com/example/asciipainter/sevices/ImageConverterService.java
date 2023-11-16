package com.example.asciipainter.sevices;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 16.11.2023
 */

@Component
public class ImageConverterService implements Convertable {

    public String convertUserImage(MultipartFile image) throws IOException {
        File input = new File("src/main/resources/images/" + image.getName() + ".jpg");
        OutputStream os = new FileOutputStream(input);
        os.write(image.getBytes());
        BufferedImage bufferedImage = ImageIO.read(input);
        return convertImageToAscii(bufferedImage);
    }

}
