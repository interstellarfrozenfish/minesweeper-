
import java.awt.*;

/*
�����ͼ��
���ƶ������
�ж��߼�
 */
public class MapTop {

    //����λ��
    int temp_x;
    int temp_y;

    //������Ϸ
    void reGame(){
        for (int i = 1; i <= GameUtil.MAP_W;i++){
            for (int j =1 ; j<= GameUtil.MAP_H;j++){
                GameUtil.DATA_TOP[i][j]=0;
            }
        }
    }
    //�ж��߼�
    void logic() {

        temp_x = 0;
        temp_y = 0;
        if (GameUtil.MOUSE_X > GameUtil.OFFSET && GameUtil.MOUSE_Y > 3 * GameUtil.OFFSET) {
            temp_x = (GameUtil.MOUSE_X - GameUtil.OFFSET) / GameUtil.SQUARE_LENGTH + 1;
            temp_y = (GameUtil.MOUSE_Y - GameUtil.OFFSET) / GameUtil.SQUARE_LENGTH - 3;
        }
        if (temp_x >= 1 && temp_x <= GameUtil.MAP_W
                && temp_y >= 1 && temp_y <= GameUtil.MAP_H) {

        if (GameUtil.LEFT) {
            //���ǣ��򷭿�
            if (GameUtil.DATA_TOP[temp_x][temp_y] == 0) {
                GameUtil.DATA_TOP[temp_x][temp_y] = -1;
            }
            spaceOpen(temp_x, temp_y);
            GameUtil.LEFT = false;
        }
        if (GameUtil.RIGHT) {
            //���������
            if (GameUtil.DATA_TOP[temp_x][temp_y] == 0) {
                GameUtil.DATA_TOP[temp_x][temp_y] = 1;
            }
            //������ȡ��
            else if (GameUtil.DATA_TOP[temp_x][temp_y] == 1) {
                GameUtil.DATA_TOP[temp_x][temp_y] = 0;
            } else if (GameUtil.DATA_TOP[temp_x][temp_y] == -1) {
                numOpen(temp_x, temp_y);
            }
            GameUtil.RIGHT = false;

            }
        }
        boom();
        victory();
        click();
    }

    //���ַ���
    void numOpen(int x,int y){
        //��¼����
        int count = 0;
        if(GameUtil.DATA_BOTTOM[x][y]>0){
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                if(GameUtil.DATA_TOP[i][j]==1){
                    count++;
                    }
                }
            }
            if (count == GameUtil.DATA_BOTTOM[x][y]){
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (GameUtil.DATA_TOP[i][j]!=1) {
                            GameUtil.DATA_TOP[i][j] = -1;
                        }
                        //������������
                        if (i >= 1&&j >=1 && i<= GameUtil.MAP_W && j<= GameUtil.MAP_H){
                            spaceOpen(i, j);
                        }
                    }

                }
            }
        }
    }
    //ʧ���ж� t ��ʾʧ�� f ��ʾδʧ��
    boolean boom(){
        for (int i =1; i<=GameUtil.MAP_W; i++ ){
            for (int j = 1; j <= GameUtil.MAP_H;j++){
                if (GameUtil.DATA_BOTTOM[i][j]==-1&&GameUtil.DATA_TOP[i][j]==-1){
                    GameUtil.state =2;
                    seeBoom();
                    return true;
                }
            }
        }
        return false;
    }
    //ʧ����ʾ
    void seeBoom(){
        for (int i =1; i<=GameUtil.MAP_W; i++ ){
            for (int j = 1; j <= GameUtil.MAP_H;j++) {
                //�ײ����׵ף����㲻���죬��ʾ
                if(GameUtil.DATA_BOTTOM[i][j]==-1&&GameUtil.DATA_TOP[i][j]!=1){
                    GameUtil.DATA_TOP[i][j]=-1;
                }
                //�ײ㲻���ף����������ӣ���ʾ�����
                if(GameUtil.DATA_BOTTOM[i][j]!=-1&&GameUtil.DATA_TOP[i][j]==1){
                    GameUtil.DATA_TOP[i][j]=2;
                }
            }
        }
    }
    //ʤ���ж� t ��ʾʤ�� f ��ʾδʤ��
    boolean victory(){
        //ͳ��δ�򿪸�����
        int count =0;
        for (int i =1; i<=GameUtil.MAP_W; i++ ){
            for (int j = 1; j <= GameUtil.MAP_H;j++) {
            if(GameUtil.DATA_TOP[i][j]!=-1){
                count++;
                }
            }
        }
        if (count==GameUtil.RAY_MAX){
            GameUtil.state = 1;
            for (int i =1; i<=GameUtil.MAP_W; i++ ){
                for (int j = 1; j <= GameUtil.MAP_H;j++) {
                    //δ�����������
                    if (GameUtil.DATA_TOP[i][j]==0){
                    GameUtil.DATA_TOP[i][j]=1;
                    }
                }
            }
            return true;
        }
        return false;
    }
    void click(){
        if (temp_x >= 1 && temp_x <= GameUtil.MAP_W
                && temp_y >= 1 && temp_y <= GameUtil.MAP_H) {

            if (GameUtil.LEFT) {
                GameUtil.state =3;
                }
                spaceOpen(temp_x, temp_y);
                GameUtil.LEFT = false;
            }
    }
    //�򿪿ո�
    void spaceOpen(int x, int y) {
        if (GameUtil.DATA_BOTTOM[x][y] == 0) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    //����,�ŵݹ�
                    if (GameUtil.DATA_TOP[i][j] != -1) {
                        GameUtil.DATA_TOP[i][j] = -1;
                        //������������
                        if (i >= 1&&j >=1 && i<= GameUtil.MAP_W && j<= GameUtil.MAP_H){
                        spaceOpen(i, j);
                        }
                    }
                }
            }
        }
    }

    //���Ʒ���
    void paintSelf(Graphics g) {
        logic();
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                //����
                if (GameUtil.DATA_TOP[i][j] == 0) {
                    g.drawImage(GameUtil.top,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                }
                //����
                if (GameUtil.DATA_TOP[i][j] == 1) {
                    g.drawImage(GameUtil.flag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                }
                //�����
                if (GameUtil.DATA_TOP[i][j] == 2) {
                    g.drawImage(GameUtil.noflag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                }


            }
        }
    }
}


