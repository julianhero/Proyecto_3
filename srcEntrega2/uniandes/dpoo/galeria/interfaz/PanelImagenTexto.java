package uniandes.dpoo.galeria.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelImagenTexto extends JPanel {

    private BufferedImage image;
    private JLabel labelTitle;
    private JLabel labelValue;
    private JLabel labelPrice;
    private JPanel imagePanel;
    private JPanel textPanel;
    private JComboBox<String> comboBox; // Añadir JComboBox para seleccionar imágenes

    // Rutas de las imágenes
    private String[] imagePaths = {
            "src\\IMG\\Mona_Lisa11.jpg",
            "src\\IMG\\OIP.jpg",
            "src\\IMG\\img2.jpg",
            "src\\IMG\\R.jpg",
            "src\\IMG\\img3.jpg",
            "src\\IMG\\img4.jpg",
            "src\\IMG\\img6.jpg",
            "src\\IMG\\img5.jpg"
    };

    // Títulos de las pinturas
    private String[] titles = {
            "La Mona Lisa",
            "La Última Cena",
            "La Noche Estrellada",
            "El Grito",
            "La Persistencia de la Memoria",
            "Guernica",
            "impression sunrise",
            "Las Meninas"
    };

    // Autores de las pinturas
    private String[] values = {
            "Leonardo da Vinci",
            "Leonardo da Vinci",
            "Vincent van Gogh",
            "Edvard Munch",
            "Salvador Dalí",
            "Pablo Picasso",
            "Claude Monet",
            "Diego Velázquez"
    };

    // Precios de las pinturas
    private String[] precios = {
            "10000000",
            "20000000",
            "30000000",
            "40000000",
            "50000000",
            "60000000",
            "70000000",
            "80000000"
    };

    public PanelImagenTexto() {
        setLayout(new BorderLayout());

        
        comboBox = new JComboBox<>(titles);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarImagenYTextos(comboBox.getSelectedIndex());
            }
        });

        
        add(comboBox, BorderLayout.NORTH);

        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    int panelWidth = getWidth();
                    int panelHeight = getHeight() - 90; // Restar espacio para los textos

                    
                    double imageAspect = (double) image.getWidth() / image.getHeight();
                    int imageWidth = panelWidth;
                    int imageHeight = (int) (panelWidth / imageAspect);
                    if (imageHeight > panelHeight) {
                        imageHeight = panelHeight;
                        imageWidth = (int) (panelHeight * imageAspect);
                    }
                    int imageX = (panelWidth - imageWidth) / 2;
                    int imageY = (panelHeight - imageHeight) / 2;

                    g.drawImage(image, imageX, imageY, imageWidth, imageHeight, this);
                }
            }
        };

        
        textPanel = new JPanel(new GridLayout(3, 1));
        labelTitle = new JLabel("", SwingConstants.CENTER);
        labelValue = new JLabel("", SwingConstants.CENTER);
        labelPrice = new JLabel("", SwingConstants.CENTER);

      
        Font font = new Font("Arial", Font.BOLD, 20); // Por ejemplo, Arial en negrita, tamaño 20
        labelTitle.setFont(font);
        labelValue.setFont(font);
        labelPrice.setFont(font);

        textPanel.add(labelTitle);
        textPanel.add(labelValue);
        textPanel.add(labelPrice);

        add(imagePanel, BorderLayout.CENTER);
        add(textPanel, BorderLayout.SOUTH);
        add(imagePanel, BorderLayout.CENTER);
        add(textPanel, BorderLayout.SOUTH);

        cargarImagenYTextos(0);
    }

    public void cargarImagenYTextos(int index) {
        try {
            image = ImageIO.read(new File(imagePaths[index]));
            labelTitle.setText(titles[index]);
            labelValue.setText(values[index]);
            labelPrice.setText("Precio: $" + precios[index]);
            repaint();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}