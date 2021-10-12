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
