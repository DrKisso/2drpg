package bin;


import entity.Hero;
import entity.Monster;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Map {
    private Hero hero = new Hero();

    //主菜单
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("1、开始游戏");
            System.out.println("2、继续游戏");
            System.out.println("3、退出游戏");
            String choose = scanner.next();
            if (choose.equals("1")) {
                hero.setHp(1000);
                hero.setMaxHp(1000);
                hero.setAttack(100);
                hero.setDefense(10);
                hero.setMoney(100);
                System.out.println("请输入您的名字");
                String name = scanner.next();
                hero.setName(name);
                Game.map = 2;
                break;
            } else if (choose.equals("3")) {
                Game.map = 0;
                break;
            } else if (choose.equals("2")) {
                String path = "game.txt";
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader(path);
                    br = new BufferedReader(fr);
                    String heroInfo = "";
                    if ((heroInfo = br.readLine()) != null) {
                        String[] hl = heroInfo.split(" ");
                        hero.setName(hl[0]);
                        hero.setMaxHp(Integer.parseInt(hl[1]));
                        hero.setHp(Integer.parseInt(hl[2]));
                        hero.setAttack(Integer.parseInt(hl[3]));
                        hero.setDefense(Integer.parseInt(hl[4]));
                        hero.setMoney(Integer.parseInt(hl[5]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                        if (fr != null) {
                            fr.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Game.map =2;
                break;
            }
        }
    }

    //新手村
    int i = 0;

    public void noviceVillage() {
        if (i == 0) {
            System.out.println("欢迎" + hero.getName() + "进入新手村");
        }
        i += 1;
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("1、查看状态");
            System.out.println("2、旅店");
            System.out.println("3、训练场");
            System.out.println("4、新手村郊区");
            System.out.println("5、存档 退出游戏");
            String choose = scanner.next();
            if (choose.equals("4")) {
                Game.map = 3;
                break;
            } else if (choose.equals("2")) {
                Game.map = 4;
                break;
            } else if (choose.equals("1")) {
                Game.map = 5;
                break;
            } else if (choose.equals("3")) {
                Game.map = 6;
                break;
            } else if (choose.equals("5")) {
                saveHero(hero);
                Game.map = 0;
                break;
            }
        }
    }

    //存档
    public void saveHero(Hero hero) {
        String path = "game.txt";
        FileWriter fw = null;
        BufferedWriter bw = null;
        String heroInfo = hero.getName() + " " + hero.getMaxHp() + " " + hero.getHp() + " " + hero.getAttack() + " " + hero.getDefense() + " " + hero.getMoney();
        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            bw.write(heroInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //一级怪物
    public ArrayList<Monster> noviceKiller() {
        Monster monster = new Monster();
        monster.setName("史莱姆");
        monster.setHp(500);
        monster.setAttack(100);
        monster.setDefense(10);
        monster.setMoney(10);

        Monster monster1 = new Monster();
        monster1.setName("哥布林");
        monster1.setHp(800);
        monster1.setAttack(100);
        monster1.setDefense(10);
        monster1.setMoney(20);

        Monster monster2 = new Monster();
        monster2.setName("哥布林射手");
        monster2.setHp(1200);
        monster2.setAttack(120);
        monster2.setDefense(50);
        monster2.setMoney(100);

        Monster monster3 = new Monster();
        monster3.setName("哥布林头目");
        monster3.setHp(2400);
        monster3.setAttack(240);
        monster3.setDefense(100);
        monster3.setMoney(1000);

        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(monster);
        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);
        return monsters;
    }

    //二级怪物
    public ArrayList<Monster> barbaricGoblin() {
        Monster monster0 = new Monster();
        monster0.setName("哥布林武士");
        monster0.setHp(2500);
        monster0.setAttack(300);
        monster0.setDefense(80);
        monster0.setMoney(900);
        Monster monster1 = new Monster();
        monster1.setName("哥布林狂战士");
        monster1.setHp(5000);
        monster1.setAttack(400);
        monster1.setDefense(50);
        monster1.setMoney(1300);
        Monster monster2 = new Monster();
        monster2.setName("铁甲哥布林");
        monster2.setHp(4000);
        monster2.setAttack(350);
        monster2.setDefense(300);
        monster2.setMoney(1800);
        Monster monster3 = new Monster();
        monster3.setName("哥布林酋长");
        monster3.setHp(8000);
        monster3.setAttack(650);
        monster3.setDefense(500);
        monster3.setMoney(4000);
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(monster0);
        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);
        return monsters;
    }

    //三级怪物
    public ArrayList<Monster> royalGoblin() {
        Monster monster0 = new Monster();
        monster0.setName("重装哥布林");
        monster0.setHp(6000);
        monster0.setAttack(2000);
        monster0.setDefense(1500);
        monster0.setMoney(5000);
        Monster monster1 = new Monster();
        monster1.setName("哥布林机甲");
        monster1.setHp(9000);
        monster1.setAttack(3000);
        monster1.setDefense(2500);
        monster1.setMoney(8000);
        Monster monster2 = new Monster();
        monster2.setName("哥布林将军");
        monster2.setHp(12000);
        monster2.setAttack(5000);
        monster2.setDefense(4000);
        monster2.setMoney(10000);
        Monster monster3 = new Monster();
        monster3.setName("变形哥布林国王机甲");
        monster3.setHp(150000);
        monster3.setAttack(22000);
        monster3.setDefense(6000);
        monster3.setMoney(100000);
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(monster0);
        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);
        return monsters;
    }

    //战斗动作
    public void suburbs() {
        Scanner scanner = new Scanner(System.in);
        boolean frist = true;
        for (; frist; ) {
            ArrayList<Monster> monsters = noviceKiller();
            System.out.println("1、砍怪");
            System.out.println("2、查看状态");
            System.out.println("3、哥布林山洞");
            System.out.println("4、回城");
            String choose = scanner.next();
            if (choose.equals("1")) {
                boolean second = true;
                Random random = new Random();
                int index = random.nextInt(4);
                for (; second; ) {
                    System.out.println("1、查看怪物");
                    System.out.println("2、砍他");
                    System.out.println("3、逃跑");
                    String s = scanner.next();
                    if (s.equals("1")) {
                        System.out.println("你遇到的怪物是:" + monsters.get(index).getName());
                    } else if (s.equals("2")) {
                        for (; ; ) {
                            System.out.println(hero.getName() + "砍到了" + monsters.get(index).getName());
                            int kill = hero.getAttack() - monsters.get(index).getDefense();
                            if (kill <= 0) {
                                kill = 1;
                            }
                            monsters.get(index).setHp(monsters.get(index).getHp() - kill);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(monsters.get(index).getName() + "损失了" + kill + "hp 剩余hp" + monsters.get(index).getHp());
                            System.out.println(monsters.get(index).getName() + "发起反击,砍到了" + hero.getName());
                            int lost = monsters.get(index).getAttack() - hero.getDefense();
                            if (lost <= 0) {
                                lost = 1;
                            }
                            hero.setHp(hero.getHp() - lost);
                            System.out.println(hero.getName() + "损失了" + lost + "hp 剩余hp" + hero.getHp());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (hero.getHp() <= 0) {
                                System.out.println("大侠请重新来过");
                                System.out.println("GAME OVER");
                                second = false;
                                frist = false;
                                Game.map = 1;
                                break;
                            }
                            if (monsters.get(index).getHp() <= 0) {
                                System.out.println(hero.getName() + "获得了胜利");
                                hero.setMoney(hero.getMoney() + monsters.get(index).getMoney());
                                second = false;
                                break;
                            }
                        }
                    } else if (s.equals("3")) {
                        break;
                    }
                }
            } else if (choose.equals("2")) {
                System.out.println("剩余生命力:" + hero.getHp() + "/" + hero.getMaxHp());
                System.out.println("钱包:" + hero.getMoney());
            } else if (choose.equals("3")) {
                Game.map = 7;
                break;
            } else if (choose.equals("4")) {
                Game.map = 2;
                break;
            }
        }
    }

    //哥布林山洞
    public void GoblinCave() {
        Scanner input = new Scanner(System.in);
        boolean first = true;
        for (; first; ) {
            ArrayList<Monster> monsters = barbaricGoblin();
            System.out.println("1、砍怪");
            System.out.println("2、查看状态");
            System.out.println("3、哥布林地下城");
            System.out.println("4、回城");
            String choose = input.next();
            if (choose.equals("1")) {
                boolean second = true;
                Random random = new Random();
                int index = random.nextInt(4);
                for (; second; ) {
                    System.out.println("1、查看怪物");
                    System.out.println("2、砍他");
                    System.out.println("3、逃跑");
                    String s = input.next();
                    if (s.equals("1")) {
                        System.out.println("你遇到的怪物是:" + monsters.get(index).getName());
                    } else if (s.equals("2")) {
                        for (; ; ) {
                            System.out.println(hero.getName() + "砍到了" + monsters.get(index).getName());
                            int kill = hero.getAttack() - monsters.get(index).getDefense();
                            if (kill <= 0) {
                                kill = 1;
                            }
                            monsters.get(index).setHp(monsters.get(index).getHp() - kill);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(monsters.get(index).getName() + "损失了" + kill + "hp 剩余hp" + monsters.get(index).getHp());
                            System.out.println(monsters.get(index).getName() + "发起反击,砍到了" + hero.getName());
                            int lost = monsters.get(index).getAttack() - hero.getDefense();
                            if (lost <= 0) {
                                lost = 1;
                            }
                            hero.setHp(hero.getHp() - lost);
                            System.out.println(hero.getName() + "损失了" + lost + "hp 剩余hp" + hero.getHp());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (hero.getHp() <= 0) {
                                System.out.println("大侠请重新来过");
                                System.out.println("GAME OVER");
                                second = false;
                                first = false;
                                Game.map = 1;
                                break;
                            }
                            if (monsters.get(index).getHp() <= 0) {
                                System.out.println(hero.getName() + "获得了胜利");
                                hero.setMoney(hero.getMoney() + monsters.get(index).getMoney());
                                second = false;
                                break;
                            }
                        }
                    } else if (s.equals("3")) {
                        break;
                    }
                }
            } else if (choose.equals("2")) {
                System.out.println("剩余生命力:" + hero.getHp() + "/" + hero.getMaxHp());
                System.out.println("钱包:" + hero.getMoney());
            } else if (choose.equals("3")) {
                Game.map = 8;
                break;
            } else if (choose.equals("4")) {
                Game.map = 2;
                break;
            }
        }
    }

    //哥布林地下城
    public void goblinPalace() {
        Scanner input = new Scanner(System.in);
        boolean first = true;
        for (; first; ) {
            ArrayList<Monster> monsters = royalGoblin();
            System.out.println("1、砍怪");
            System.out.println("2、查看状态");
            System.out.println("3、哥布林地下城");
            System.out.println("4、回城");
            String choose = input.next();
            if (choose.equals("1")) {
                boolean second = true;
                Random random = new Random();
                int index = random.nextInt(4);
                for (; second; ) {
                    System.out.println("1、查看怪物");
                    System.out.println("2、砍他");
                    System.out.println("3、逃跑");
                    String s = input.next();
                    if (s.equals("1")) {
                        System.out.println("你遇到的怪物是:" + monsters.get(index).getName());
                    } else if (s.equals("2")) {
                        for (; ; ) {
                            System.out.println(hero.getName() + "砍到了" + monsters.get(index).getName());
                            int kill = hero.getAttack() - monsters.get(index).getDefense();
                            if (kill <= 0) {
                                kill = 1;
                            }
                            monsters.get(index).setHp(monsters.get(index).getHp() - kill);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(monsters.get(index).getName() + "损失了" + kill + "hp 剩余hp" + monsters.get(index).getHp());
                            System.out.println(monsters.get(index).getName() + "发起反击,砍到了" + hero.getName());
                            int lost = monsters.get(index).getAttack() - hero.getDefense();
                            if (lost <= 0) {
                                lost = 1;
                            }
                            hero.setHp(hero.getHp() - lost);
                            System.out.println(hero.getName() + "损失了" + lost + "hp 剩余hp" + hero.getHp());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (hero.getHp() <= 0) {
                                System.out.println("大侠请重新来过");
                                System.out.println("GAME OVER");
                                second = false;
                                first = false;
                                Game.map = 1;
                                break;
                            }
                            if (monsters.get(index).getHp() <= 0) {
                                System.out.println(hero.getName() + "获得了胜利");
                                hero.setMoney(hero.getMoney() + monsters.get(index).getMoney());
                                second = false;
                                break;
                            }
                        }
                    } else if (s.equals("3")) {
                        break;
                    }
                }
            } else if (choose.equals("2")) {
                System.out.println("剩余生命力:" + hero.getHp() + "/" + hero.getMaxHp());
                System.out.println("钱包:" + hero.getMoney());
            } else if (choose.equals("3")) {
                System.out.println("未完成");
            } else if (choose.equals("4")) {
                Game.map = 2;
                break;
            }
        }
    }

    //查看状态动作
    public void showState() {
        System.out.println("最大血量：" + hero.getMaxHp());
        System.out.println("当前血量：" + hero.getHp());
        System.out.println("攻击力：" + hero.getAttack());
        System.out.println("防御力：" + hero.getDefense());
        System.out.println("钱包：" + hero.getMoney());
        Game.map = 2;
    }

    //回旅馆事件
    public void hotel() {
        System.out.println("进入旅馆，花费五元，血量回满");
        hero.setHp(hero.getMaxHp());
        hero.setMoney(hero.getMoney() - 5);
        Game.map = 2;
    }

    //训练场事件
    public void train() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1.提升最大血量 2.提升攻击力 3.提升防御力 4.退出");
            String opt = input.next();
            switch (opt) {
                case "1":
                    if (hero.getMoney() >= 20) {
                        hero.setMaxHp(hero.getMaxHp() + 50);
                        hero.setMoney(hero.getMoney() - 20);
                        System.out.println("花费20元,提升50点最大血量");
                    } else {
                        System.out.println("买不起");
                    }
                    break;
                case "2":
                    if (hero.getMoney() >= 10) {
                        hero.setAttack(hero.getAttack() + 10);
                        hero.setMoney(hero.getMoney() - 10);
                        System.out.println("花费10元，提升10点攻击力");
                    } else {
                        System.out.println("买不起");
                    }
                    break;
                case "3":
                    if (hero.getMoney() >= 10) {
                        hero.setDefense(hero.getDefense() + 5);
                        hero.setMoney(hero.getMoney() - 10);
                        System.out.println("花费10元,提升5点防御力");
                    } else {
                        System.out.println("买不起");
                    }
                    break;
                case "4":
                    flag = false;
                    Game.map = 2;
                    break;
            }
        }
    }
}
