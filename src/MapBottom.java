import java.awt.*;
/*
���Ƶ�ͼ
������Ϸ������
 */
public class MapBottom {

    BottomRay bottomRay = new BottomRay();
    BottomNum bottomNum = new BottomNum();
    {
        bottomRay.newRay();
        bottomNum.newNum();
    }

    //������Ϸ
    void reGame(){
        for (int i = 1; i <= GameUtil.MAP_W;i++){
            for (int j =1 ; j<= GameUtil.MAP_H;j++){
                GameUtil.DATA_BOTTOM[i][j]=0;
            }
        }
        bottomRay.newRay();
        bottomNum.newNum();
    }
    //���Ʒ���
    void paintSelf(Graphics g) {

        g.setColor(Color.GRAY);

        //������
        for (int i = 0; i <= GameUtil.MAP_W; i++) {
            g.drawLine(GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET,
                    GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH);
        }
        //������
        for (int i = 0; i <= GameUtil.MAP_H; i++) {
            g.drawLine(GameUtil.OFFSET,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET + GameUtil.MAP_W * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH);
        }
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                //��
                if (GameUtil.DATA_BOTTOM[i][j] == -1) {
                    g.drawImage(GameUtil.lei,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            GameUtil.SQUARE_LENGTH,
                            null);
                }
                //����
                if (GameUtil.DATA_BOTTOM[i][j] >= 0) {
                    g.drawImage(GameUtil.images[GameUtil.DATA_BOTTOM[i][j]],
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH,
                            null);
                }
            }
        }
        switch (GameUtil.state){
            case 0:
            g.drawImage(GameUtil.face,
                    GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                    GameUtil.OFFSET,
                    null);
                break;
            case 1:
                g.drawImage(GameUtil.win,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        null);
                break;
            case 2:
                g.drawImage(GameUtil.over,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        null);
                break;
            case 3:
                g.drawImage(GameUtil.click,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        null);
        }


    }
}
