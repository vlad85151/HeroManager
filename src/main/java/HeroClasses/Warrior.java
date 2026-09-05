package HeroClasses;
import java.util.Random;
public class Warrior extends Hero {
    Random random = new Random();
    private int bonusDefence = 3;
    public Warrior(String name, int hp, int attackDamage, int speed){
        super(name, hp, attackDamage, speed);
        super.setDefence(bonusDefence);
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
