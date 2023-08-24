import java.awt.*;

//工具类
public class GameUtil {
    //地雷个数
    static int RAY_MAX = 10;
    static int MAP_W = 9;//地图的宽
    static int MAP_H = 9;//地图的高
    static int OFFSET = 30;//雷区偏移量
    static int SQUARE_LENGTH = 16;//格子的边长

    //鼠标相关
    //坐标
    static int MOUSE_X;
    static int MOUSE_Y;
    //状态
    static boolean LEFT = false;
    static boolean RIGHT = false;

    //游戏状态 0 表示游戏中 2 胜利 3 失败
    static  int state = 0;
    //底层元素 -1 雷 0 空 1-8 数字
    static int[][] DATA_BOTTOM =new int[MAP_W+2][MAP_H+2];

    //顶层元素 -1 无覆盖 0 覆盖 1 插旗 2 插错旗
    static int[][] DATA_TOP=new int[MAP_W+2][MAP_H+2];


    //载入图片
    static Image lei = Toolkit.getDefaultToolkit().createImage("Image/9.png");
    static Image top = Toolkit.getDefaultToolkit().createImage("Image/blank.gif");
    static Image flag = Toolkit.getDefaultToolkit().createImage("Image/flag.gif");
    static Image  noflag= Toolkit.getDefaultToolkit().createImage("Image/12.png");

    static Image face = Toolkit.getDefaultToolkit().createImage("Image/face0.gif");
    static Image over = Toolkit.getDefaultToolkit().createImage("Image/face2.gif");
    static Image win = Toolkit.getDefaultToolkit().createImage("Image/face3.gif");
    static Image click = Toolkit.getDefaultToolkit().createImage("Image/face1.gif");
    static Image[] images = new Image[9];
    static {
        for (int i = 1; i <= 8 ; i++) {
            images[i] = Toolkit.getDefaultToolkit().getImage("Image/"+ i +".png" );

        }
    }
}
