import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    int width = 2 * GameUtil.OFFSET + GameUtil.MAP_W * GameUtil.SQUARE_LENGTH;
    int height = 4 * GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH;

    Image offScreenImage = null;
    MapBottom mapBottom = new MapBottom();
    MapTop mapTop = new MapTop();
    public MyFrame () {
        //设定界面
        setSize(width, height);
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        Image image = Toolkit.getDefaultToolkit().getImage("Image/icon.png"); //设置图标
        setIconImage(image);
        //鼠标事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (GameUtil.state){
                    case 0:
                        if (e.getButton()==1){
                        GameUtil.MOUSE_X = e.getX();
                        GameUtil.MOUSE_Y = e.getY();
                        GameUtil.LEFT = true;
                    }
                        if (e.getButton()==3){
                            GameUtil.MOUSE_X = e.getX();
                            GameUtil.MOUSE_Y = e.getY();
                            GameUtil.RIGHT = true;
                        }

                    case 1:
                    case 2:
                        if (e.getButton()==1){
                            if (e.getX()>GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2)
                                    && e.getX()< GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2) + GameUtil.SQUARE_LENGTH
                                    && e.getY()>GameUtil.OFFSET
                                    && e.getY()<GameUtil.OFFSET+GameUtil.SQUARE_LENGTH){
                                mapBottom.reGame();
                                mapTop.reGame();
                                GameUtil.state = 0;
                            }
                        }
                        break;
                    case 3:
                        if (e.getButton()==1){
                            GameUtil.MOUSE_X = e.getX();
                            GameUtil.MOUSE_Y = e.getY();
                            GameUtil.LEFT = true;
                        }
                    default:
                }

            }
        });
        while(true){
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //绘制网格
    public void paint(Graphics g) {
        offScreenImage = this.createImage(width,height);
        Graphics gImage = offScreenImage.getGraphics();
        gImage.setColor(Color.LIGHT_GRAY);
        gImage.fillRect(0,0,width,height);
        mapBottom.paintSelf(gImage);
        mapTop.paintSelf(gImage);
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) {
        new MyFrame ();
    }
}
