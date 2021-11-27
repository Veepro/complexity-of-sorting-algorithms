import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;

public class Graph {
    JFrame frame;
    XYChart chart;

    Graph(String seriesName, double[] xData, double[] yData) {
        chart = QuickChart.getChart("График", "n", "t", seriesName, xData, yData);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                // Create and set up the window.
                frame = new JFrame("Advanced Example");
                frame.setLayout(new BorderLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // chart
                JPanel chartPanel = new XChartPanel<XYChart>(chart);
                frame.add(chartPanel, BorderLayout.CENTER);

                // Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });

    }

    void addSeries(String seriesName, double[] xData, double[] yData) {
        this.chart.addSeries(seriesName, xData, yData);
        frame.repaint();
    }
}
