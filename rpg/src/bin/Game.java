package bin;

public class Game {

    public static int map = 1;//1 进入游戏选择界面

    public static void main(String[] args) {
        Map m=new Map();
        for (;;) {
            if (map == 1) {
                //1 进入游戏选择界面
                m.mainMenu();
            } else if(map== 2){
                //2 进入新手村
                m.noviceVillage();
            } else if(map==3){
                //3 进入新手1野外
                m.suburbs();
            }else if(map==4) {
                //旅馆回复血量
                m.hotel();
            }else if(map==5){
                // 查看状态
                m.showState();
            }else if(map==6){
                //训练场
                m.train();
            }else if(map==7){
                //哥布林山洞
                m.GoblinCave();
            }else if(map==8){
                //哥布林地下城
                m.goblinPalace();
            }else if(map==0){
                break;
            }
        }
    }
}
