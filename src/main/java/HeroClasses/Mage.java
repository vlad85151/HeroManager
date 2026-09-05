package HeroClasses;

public class Mage extends Hero {
    public Mage(String name, int hp, int attackDamage, int speed){
        super(name, hp, attackDamage, speed);
    }

    @Override
    public int takeDamage(int damage){
        int finDamage = damage-(super.getDefence() );
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
