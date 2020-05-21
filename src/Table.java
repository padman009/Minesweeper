import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

class Table extends JFrame implements Runnable, MouseListener, MouseMotionListener, KeyListener {
    private final int fps=60;
    private final int w;
    private final int h;
    private final int minesCount;
    private final int cellSize = 35;
    private List<List<Cell>> cells;

    private BufferedImage img;

    Table(int w, int h, int minecount){
        this.w = w;
        this.h = h;
        this.minesCount = minecount;
        img = new BufferedImage(w * cellSize, h * cellSize, BufferedImage.TYPE_INT_RGB);
        this.setSize(w * cellSize, h * cellSize );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(0, 0);
        this.add(new JLabel(new ImageIcon(img)));
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        buildGrid(w,h,minesCount);
    }

    private void buildGrid(int w, int h, int minesCount) {
        cells = new ArrayList<>();
        Random random=new Random();
        for(int i = 0; i<w;i++){
            cells.add(new ArrayList<>());
            for(int j=0; j<h;j++){
                cells.get(i).add(new Cell());
            }
        }
        for(int r = 0; r < minesCount;){
            int x = random.nextInt(w-1);
            int y = random.nextInt(h-1);
            if(!cells.get(x).get(y).getMine()){
                r++;
            }
            cells.get(x).set(y, new Cell(x,y,true,-1));
        }

    }

    @Override
    public void run() {
        while (true){
            repaint(1000/fps);
        }
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / cellSize;
        int y = e.getY() / cellSize;
        if (e.getButton()==3 && cells.get(x).get(y).getFlag()==0){
            cells.get(x).get(y).setFlag(-1);
        }else if (e.getButton()==3 && cells.get(x).get(y).getFlag()==-1){
            cells.get(x).get(y).setFlag(1);
        }else if (e.getButton()==3 && cells.get(x).get(y).getFlag()==1){
            cells.get(x).get(y).setFlag(0);
        }else if (e.getButton() ==1 && cells.get(x).get(y).getFlag()==0 ){
            cellOpen(x,y);
        }
    }

    private void cellOpen(int x, int y) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}