package net.kyaz0x1.imageresizer.controller;

import net.kyaz0x1.imageresizer.file.FileUtils;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class ImageController {

    private static ImageController instance;

    private ImageController(){}

    public void resize(File file, int width, int height){
        try {
            final BufferedImage inputImage = ImageIO.read(file);
            final BufferedImage outputImage = new BufferedImage(width, height, inputImage.getType());

            final Graphics2D graphics = outputImage.createGraphics();
            graphics.drawImage(inputImage, 0, 0, width, height, null);
            graphics.dispose();

            final String format = FileUtils.getFormat(file);

            final String name = file.getName().replace(format, "");
            final File output = new File(file.getParent(), name + " - resized" + format);

            ImageIO.write(outputImage, format.substring(1), output);

            JOptionPane.showMessageDialog(null, String.format("A imagem teve seu tamanho alterado para %dx%d", width, height));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar a imagem! Erro: " + e.getMessage(), "ImageResizer", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ImageController getInstance(){
        if(instance == null){
            synchronized(ImageController.class){
                if(instance == null){
                    instance = new ImageController();
                }
            }
        }
        return instance;
    }

}