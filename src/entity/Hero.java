package entity;

public class Hero {

    private String name;

    private int maxHp;

    private int hp;

    private int attack;

    private int defense;

    private int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if(money<0){
            System.out.println("买不起");
        }else {
            this.money = money;
        }
    }
}
