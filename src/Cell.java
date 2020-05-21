import javax.swing.*;

class Cell{
    private int x;
    private int y;
    private ImageIcon imageIcon;
    private boolean isMine;
    private int flag=0;// 0=empty, -1=exclamation, 1=question
    private int num=0;

    Cell(){
    }

    Cell(int x, int y, boolean isMine, int num) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
        this.num = num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getMine() {
        return isMine;
    }

    public int getFlag() {
        return flag;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public int getNum() {
        return num;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        String src = "";
        switch (flag){
            case -1 -> src = "Icons//D_FLAG.png";
            case 1 -> src = "Icons//Q_FLAG.png";
        }
        this.imageIcon = new ImageIcon(src);
    }
}