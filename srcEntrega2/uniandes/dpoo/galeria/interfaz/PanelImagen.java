package uniandes.dpoo.galeria.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelImagen extends JPanel {

    private BufferedImage image;
    private String title;
    private String value;

    public PanelImagen(String imagePath, String title, String value) {
        this.title = title;
        this.value = value;

        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        
        setPreferredSize(new Dimension(50, 100)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calcular el tamaño y la posición de la imagen
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            int imageX = (panelWidth - imageWidth) / 2;
            int imageY = 10; // Margen superior

            g2d.drawImage(image, imageX, imageY, this);

            // Posicionar el título debajo de la imagen
            if (title != null) {
                FontMetrics titleMetrics = g2d.getFontMetrics();
                int titleWidth = titleMetrics.stringWidth(title);
                int titleX = (panelWidth - titleWidth) / 2;
                int titleY = imageY + imageHeight + 30; // Espacio entre la imagen y el título
                g2d.setFont(new Font("Arial", Font.BOLD, 16));
                g2d.drawString(title, titleX, titleY);
            }

            // Posicionar el valor debajo del título
            if (value != null) {
                FontMetrics valueMetrics = g2d.getFontMetrics();
                int valueWidth = valueMetrics.stringWidth(value);
                int valueX = (panelWidth - valueWidth) / 2;
                int valueY = imageY + imageHeight + 50; // Espacio entre el título y el valor
                g2d.setFont(new Font("Arial", Font.PLAIN, 14));
                g2d.drawString(value, valueX, valueY);
            }
        }
    }
}