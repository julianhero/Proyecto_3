package uniandes.dpoo.galeria.interfaz;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class TableroActividad extends JPanel {
    private static final int CELL_SIZE = 15;
    private static final int CELL_GAP = 5;
    private Map<LocalDate, Integer> activityData;

    public TableroActividad(Map<LocalDate, Integer> activityData) {
        this.activityData = activityData;
        setPreferredSize(new Dimension(800, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        LocalDate startDate = LocalDate.of(2023, Month.APRIL, 1);
        LocalDate endDate = LocalDate.of(2024, Month.APRIL, 1);
        LocalDate currentDate = startDate;

        int x = 0;
        int y = 0;

        while (!currentDate.isAfter(endDate)) {
            int activity = activityData.getOrDefault(currentDate, 0);
            Color color = getColorForActivity(activity);
            g2d.setColor(color);
            g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);

            currentDate = currentDate.plusDays(1);
            x += CELL_SIZE + CELL_GAP;
            if (currentDate.getDayOfWeek().getValue() == 1) {
                x = 0;
                y += CELL_SIZE + CELL_GAP;
            }
        }
    }

    private Color getColorForActivity(int activity) {
        if (activity > 10) return new Color(0, 100, 0);
        else if (activity > 5) return new Color(50, 150, 50);
        else if (activity > 0) return new Color(100, 200, 100);
        else return new Color(200, 200, 200);
    }

    public static void main(String[] args) {
        Map<LocalDate, Integer> activityData = new HashMap<>();
        for (int i = 0; i < 365; i++) {
            activityData.put(LocalDate.of(2023, Month.APRIL, 1).plusDays(i), (int) (Math.random() * 15));
        }

        JFrame frame = new JFrame("Activity Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TableroActividad(activityData));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}