package uniandes.dpoo.galeria.interfaz;
import javax.swing.*;
import java.awt.*;

public class PanelComboBox extends JPanel {

    public PanelComboBox() {
        
        String[] pinturas = {
            "La Mona Lisa",
            "La Última Cena",
            "La Noche Estrellada",
            "El Grito",
            "La Persistencia de la Memoria",
            "Guernica",
            "El Nacimiento de Venus",
            "Las Meninas"
        };

        JComboBox<String> comboBox = new JComboBox<>(pinturas);
        setLayout(new BorderLayout());
        add(comboBox, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Catalogo de piezas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        PanelComboBox panelComboBox = new PanelComboBox();
        frame.add(panelComboBox);
        frame.setVisible(true);
    }
}
