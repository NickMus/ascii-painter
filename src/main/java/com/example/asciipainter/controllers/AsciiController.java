package com.example.asciipainter.controllers;

import com.example.asciipainter.sevices.VideoConverterService;
import com.example.asciipainter.sevices.ImageConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 31.10.2023
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class AsciiController {
    private final VideoConverterService videoConverter;
    private final ImageConverterService imageConverterService;

    @GetMapping("/get-video")
    public String asciiVideo(Model model) {
        model.addAttribute("video", videoConverter.convertVideo());
        return "video";
    }

    @GetMapping("/upload-image")
    public String userImageLoad() throws IOException {
        return "image";
    }

    @PostMapping("/upload-image")
    public String userImageLoad(RedirectAttributes attributes, @RequestParam("image") MultipartFile image) throws IOException {
        attributes.addFlashAttribute("image", imageConverterService.convertUserImage(image));
        return "redirect:/user_file";
    }

    @GetMapping("/user_file")
    public String getUserImage(@ModelAttribute String image, Model model) {
        model.addAttribute("image");
        return "user_file";
    }
}
