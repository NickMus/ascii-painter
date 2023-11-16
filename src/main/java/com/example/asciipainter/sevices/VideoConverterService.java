package com.example.asciipainter.sevices;

import com.github.sarxos.webcam.Webcam;
import org.springframework.stereotype.Service;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 26.10.2023
 */
@Service
public class VideoConverterService implements Convertable {

    public String convertVideo() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        return convertImageToAscii(webcam.getImage());
    }
}

