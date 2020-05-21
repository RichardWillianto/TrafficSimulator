package Model;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class Main
{
    private static final int WIDTH = 1440;
    private static final int HEIGHT = 900;
    private static EditorPanel editorPanel = new EditorPanel();
    private static SimulationPanel simulationPanel = new SimulationPanel();
    private static final int SCALE = 8;

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Traffic Simulator");
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 0));
        bottom.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        JLabel mode = new JLabel("Mode: ");
        bottom.add(mode);
        JLabel status = new JLabel("Status: ");
        bottom.add(status);
        window.add(bottom, BorderLayout.SOUTH);
        JMenuBar menuBar = new JMenuBar();
        window.add(menuBar, BorderLayout.NORTH);
        JMenu editor = new JMenu("City Editor");
        MenuListener city = new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent e)
            {
                mode.setText("Mode: Editor");
                window.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e)
            {

            }

            @Override
            public void menuCanceled(MenuEvent e)
            {

            }
        };
        editor.addMenuListener(city);
        menuBar.add(editor);
        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e ->
        {
            simulationPanel.setVisible(false);
            window.remove(editorPanel);
            editorPanel = new EditorPanel();
            editorPanel.map();
            editorPanel.setScale(SCALE);
            window.add(editorPanel);
            editorPanel.setVisible(true);
            status.setText("Status: New Map");
            window.validate();
            window.repaint();
        });
        editor.add(newItem);
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(e ->
        {

        });
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(e ->
        {

        });
        editor.add(save);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        editor.add(exit);
        JMenu simulation = new JMenu("Simulation");
        MenuListener simulator = new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent e)
            {
                mode.setText("Mode: Simulation");
                window.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e)
            {

            }

            @Override
            public void menuCanceled(MenuEvent e)
            {

            }
        };
        simulation.addMenuListener(simulator);
        JMenuItem load = new JMenuItem("Load Map");
        simulation.add(load);
        JMenuItem addVehicles = new JMenuItem("Add Vehicles");
        addVehicles.setEnabled(false);
        simulation.add(addVehicles);
        JMenuItem start = new JMenuItem("Start");
        start.setEnabled(false);
        start.addActionListener(e ->
        {
            simulationPanel.simulate();
            status.setText("Status: Simulation Started");
            simulationPanel.setStop(false);
            window.validate();
            window.repaint();
        });
        simulation.add(start);
        addVehicles.addActionListener(e ->
        {
            String input = JOptionPane.showInputDialog("Vehicles spawn: ");
            int spawn = Integer.parseInt(input);
            simulationPanel.setIncomingVehicles(spawn);
            String rate = JOptionPane.showInputDialog("Simulation tics between spawns: ");
            int spawnRate = Integer.parseInt(rate);
            simulationPanel.setIncomingVehiclesRate(spawnRate);
        });
        JMenuItem stop = new JMenuItem("Stop");
        stop.setEnabled(false);
        stop.addActionListener(e ->
        {
            simulationPanel.setStop(true);
            status.setText("Status: Simulation Stopped");
            window.validate();
            window.repaint();
        });
        simulation.add(stop);
        load.addActionListener(e ->
        {
            status.setText("Status: Map Loaded");
            editorPanel.setVisible(false);
            simulationPanel = new SimulationPanel();
            simulationPanel.setScale(SCALE);
            simulationPanel.map(editorPanel.getRoads(), editorPanel.getLights());
            window.add(simulationPanel);
            start.setEnabled(true);
            addVehicles.setEnabled(true);
            stop.setEnabled(true);
            window.repaint();
        });
        JMenuItem update = new JMenuItem("Update Rate");
        update.addActionListener(e ->
        {
            String updateInput = JOptionPane.showInputDialog("Update Rate: ");
            int updateRate = Integer.parseInt(updateInput);
            simulationPanel.setUpdateRate(updateRate);
            status.setText("Status: Update rate set to " + updateRate);
            window.validate();
            window.repaint();
        });
        simulation.add(update);
        menuBar.add(simulation);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
