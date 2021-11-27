import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUI implements ActionListener {
    JFrame f;
    JComboBox cb_chooseSort;
    JButton b_plot;
    JTextField tf_start;
    JTextField tf_step;
    JTextField tf_ending;

    String[] sorting = {
            "Сортировка вставками",
            "Пузырьковая сортировка",
            "Быстрая сортировка",
            "Сортировка выбором",
            "Сортировка с помощью кучи"
    };

    Graph graph;
    boolean existGraph = false;

    GUI() {
        f = new JFrame("Сортировки");

        JLabel l1 = new JLabel("Выберите сортировку:");
        l1.setBounds(10, 5, 200, 50);
        f.add(l1);
        cb_chooseSort = new JComboBox(sorting);
        cb_chooseSort.setBounds(210, 5, 500, 50);
        f.add(cb_chooseSort);

        JLabel l2 = new JLabel("Начальный размер массива:");
        l2.setBounds(10, 55, 200, 50);
        f.add(l2);
        tf_start = new JTextField();
        tf_start.setBounds(210, 55, 200, 50);
        f.add(tf_start);

        JLabel l3 = new JLabel("Выберите шаг:");
        l3.setBounds(10, 105, 200, 50);
        f.add(l3);
        tf_step = new JTextField();
        tf_step.setBounds(210, 105, 200, 50);
        f.add(tf_step);

        JLabel l4 = new JLabel("Конечный размер массива:");
        l4.setBounds(10, 155, 200, 50);
        f.add(l4);
        tf_ending = new JTextField();
        tf_ending.setBounds(210, 155, 200, 50);
        f.add(tf_ending);

        b_plot = new JButton("Посторить график");
        b_plot.setBounds(10, 205, 710, 100);
        b_plot.addActionListener(this);
        f.add(b_plot);

        f.setLayout(null);
        f.setSize(1000, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        double[][] dataForGraph;
        if (!existGraph) {
            try {
                dataForGraph = Run.getDataForGraph(cb_chooseSort.getSelectedIndex(),
                        Integer.parseInt(tf_start.getText()),
                        Integer.parseInt(tf_step.getText()),
                        Integer.parseInt(tf_ending.getText()));
                graph = new Graph(sorting[cb_chooseSort.getSelectedIndex()] ,dataForGraph[0], dataForGraph[1]);
                existGraph = true;
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        } else {
            try {
                dataForGraph = Run.getDataForGraph(cb_chooseSort.getSelectedIndex(),
                        Integer.parseInt(tf_start.getText()),
                        Integer.parseInt(tf_step.getText()),
                        Integer.parseInt(tf_ending.getText()));
                graph.addSeries(sorting[cb_chooseSort.getSelectedIndex()] ,dataForGraph[0], dataForGraph[1]);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }

    }
}
