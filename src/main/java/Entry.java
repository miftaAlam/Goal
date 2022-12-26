import java.awt.*;
import java.util.ArrayList;

public class Entry {
    ///////////////
    public Rectangle hitbox;
    public int xPos;
    public int yPos;
    ///////////////
    private final int width = 500;
    private final int height = 40;
    ///////////////
    private Color inner = Color.CYAN;
    private Color outer = Color.BLACK;
    /////////////// [sub-entries of this entry]
    public ArrayList<Entry> children = new ArrayList<>();
    ///////////////
    private int xOffset = 40;
    private int yOffset = 40;

    //public String info ...

    Entry() {} /// [not used]
    Entry(int xPos, int yPos) {
        ///////////////
        this.xPos = xPos;
        this.yPos = yPos;
        ///////////////
        this.hitbox = new Rectangle(this.xPos, this.yPos, this.width, this.height);
    }
    public void paint(Graphics g) {
        /////////////// [fill rect]
        g.setColor(this.inner);
        g.fillRect(this.xPos, this.yPos, this.width, this.height);
        /////////////// [outline rect]
        g.setColor(this.outer);
        g.drawRect(this.xPos, this.yPos, this.width, this.height);
        /////////////// [paint each child]
        for (Entry e : children) { e.paint(g); }
    }
    public void highlight(Point mousePos) {
        /////////////// [outside the frame]
        if (mousePos == null) { return; }
        /////////////// [check each child]
        for (Entry e : children) { e.highlight(mousePos); }
        /////////////// [highlight]
        if (this.hitbox.contains(mousePos)) {
            this.inner = Color.BLUE;
            return;
        }
        this.inner = Color.CYAN;
    }
    public void add(Point mousePos, ArrayList<Entry> upperLevel) { // [add new child]
        /////////////// [check each child]
        for (Entry e : children) { e.add(mousePos, this.children); }
        if (this.hitbox.contains(mousePos)) {
            if (this.children.size() == 0) {
                /////////////// [based on this entry]
                pushDown(upperLevel);
                this.children.add(new Entry(this.xPos + this.xOffset,
                        this.yPos + this.yOffset));
            } else {
                /////////////// [based on child]
                pushDown(upperLevel);
                this.children.add(new Entry(this.xPos + this.xOffset,
                        this.children.get(this.children.size()-1).yPos + yOffset));
            }
        }
    }
    public void pushDown(ArrayList<Entry> upperLevel) {
        int index = upperLevel.indexOf(this);
        for (int i = index + 1; i < upperLevel.size(); i++) {
            upperLevel.get(i).yPos += this.yOffset;
            upperLevel.get(i).hitbox.y += this.yOffset;
        }
    }

}
