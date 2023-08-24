import java.awt.*;

//������
public class GameUtil {
    //���׸���
    static int RAY_MAX = 10;
    static int MAP_W = 9;//��ͼ�Ŀ�
    static int MAP_H = 9;//��ͼ�ĸ�
    static int OFFSET = 30;//����ƫ����
    static int SQUARE_LENGTH = 16;//���ӵı߳�

    //������
    //����
    static int MOUSE_X;
    static int MOUSE_Y;
    //״̬
    static boolean LEFT = false;
    static boolean RIGHT = false;

    //��Ϸ״̬ 0 ��ʾ��Ϸ�� 2 ʤ�� 3 ʧ��
    static  int state = 0;
    //�ײ�Ԫ�� -1 �� 0 �� 1-8 ����
    static int[][] DATA_BOTTOM =new int[MAP_W+2][MAP_H+2];

    //����Ԫ�� -1 �޸��� 0 ���� 1 ���� 2 �����
    static int[][] DATA_TOP=new int[MAP_W+2][MAP_H+2];


    //����ͼƬ
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
