package HeroClasses;

import java.time.LocalDateTime;
import java.util.Random;

public abstract class Hero {
    Random random = new Random();

    private String name;
    private int hp;
    private int attackDamage;
    private int defence;
    private int criticalChance;
    private int evasion;
    private int speed;
    private LocalDateTime timeCreate;
    String className;

    public Hero(String name, int hp, int attackDamage, int speed){
        this.name = name;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.defence = 2;
        this.criticalChance = 15;
        this.evasion = 10;
        this.speed = speed;
        timeCreate = LocalDateTime.now();
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int finDamage){
        hp -= finDamage;
    }
    public String getName() {
        return name;
    }
    public int getAttackDamage(){
        return attackDamage;
    }
    public int getSpeed(){
        return speed;
    }
    public int getDefence(){
        return defence;
    }
    public void setDefence(int bonusDefence){
        defence += bonusDefence;
    }
    public void setCriticalChance(int bonusCriticalChance){
        criticalChance += bonusCriticalChance;
    }
    public abstract int takeDamage(int damage);

    public int calculateDamage(){
        int min = -3;
        int max = 3;
        int chanceDouble = random.nextInt(100 - 1 + 1) + 1 ;
        int finallyDamage = random.nextInt((attackDamage + max) - (attackDamage - min) + 1) + (attackDamage - min);
        if (chanceDouble <= criticalChance){
            System.out.println("Сработал критический урон");
            return (finallyDamage*2) ;
        } return finallyDamage ;
    };
    public boolean evadeAttack(){
        int evasionChance = random.nextInt(100-1+1)+1;
        if (evasionChance <= evasion){return true;} else return false;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    @Override
    public String toString(){
        return "Класс: " + this.getClass().getSimpleName()
                + ", Имя: " + name
                + ", здоровье: " + hp
                + ", урон: " + attackDamage
                + ", защита: " + defence
                + ", скорость: " + speed
                + ", дата создания: " + timeCreate;
    }
    public String saveInfo(){
        return this.getClass().getSimpleName() + ";" + name + ";" + hp + ";" + attackDamage + ";" + speed + ";" + timeCreate;
    }

    public String getClassName(){
        return this.getClass().getSimpleName();
    }

    public int getCriticalChance() {
        return criticalChance;
    }
}
