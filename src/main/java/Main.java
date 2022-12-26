import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Main {
    private static final Dimension windowSize = new Dimension(1000, 800);

    public static void main(String[] args) {
        Panel panel = new Panel();

        JFrame frame = new JFrame("PATHFINDER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Main.windowSize);
        //frame.add(panel);
        frame.setContentPane(panel);
        frame.addMouseListener(panel);
        frame.setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //createAndShowGui();
                System.out.println("IS ON EDT: " +
                        SwingUtilities.isEventDispatchThread());
            }
        });
    }
}
