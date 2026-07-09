package HeroClasses;

public class Assassin extends Hero {
    private int bonusCritChance = 20;
    public Assassin(String name, int hp, int attackDamage, int speed){
        super(name, hp, attackDamage, speed);
        super.setCriticalChance(bonusCritChance);
    }

    @Override
    public int takeDamage(int damage){
        int finDamage = damage-(super.getDefence());
        if (finDamage <= 0){
            return 0;
        }else {
            if ((super.getHp() - finDamage) <= 0){
                super.setHp(super.getHp());
            } else super.setHp(finDamage);
            return finDamage;
        }
    }
}