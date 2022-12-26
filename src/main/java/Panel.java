import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Panel extends JPanel implements MouseListener {
    public ArrayList<Entry> list = new ArrayList<>();
    private Entry entry = new Entry(0, 0);
    Panel() {
        this.list.add(this.entry);
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawString("Hello, World!", 10, 20);
        this.entry.paint(g);
        this.entry.highlight(this.getMousePosition());
        this.repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //this.entry.add(this.getMousePosition());
    }

    /////////////// [not used]
    @Override
    public void mousePressed(MouseEvent e) {
        this.entry.add(this.getMousePosition(), this.list);
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    ///////////////
}
