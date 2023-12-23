package de.ALB654.games.chess.render.sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    private BufferedImage originalImage;
    private BufferedImage resizedImage;

    public Sprite(String src, int xSize, int ySize) {
        try {
            originalImage = ImageIO.read(new File(src));
            resize(xSize, ySize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sprite(String sheetSrc, int xPos, int yPos, int xSize, int ySize, int scaleX, int scaleY) {
        try {
            BufferedImage sheet = ImageIO.read(new File(sheetSrc));
            originalImage = sheet.getSubimage(xPos, yPos, xSize, ySize);

            resize(scaleX, scaleY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resize(int targetWidth, int targetHeight) {
        resizedImage = resizeImage(originalImage, targetWidth, targetHeight);
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, new Color(0, 0, 0, 0), null);
        return outputImage;
    }

    public BufferedImage getImage() {
        return resizedImage;
    }

    public int getWidth() {
        return resizedImage.getWidth();
    }

    public int getHeight() {
        return resizedImage.getHeight();
    }

}
