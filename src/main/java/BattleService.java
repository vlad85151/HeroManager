import HeroClasses.Hero;

public class BattleService {
    public void attackHero(Hero hero1, Hero hero2){
        if (hero1.getSpeed() < hero2.getSpeed()){
            startFight(hero2, hero1);
        } else startFight(hero1, hero2);
    }

    public void startFight(Hero hero1, Hero hero2){
        while (hero1.getHp() != 0 && hero2.getHp() != 0){
            attackHeroes(hero1, hero2);
            if(hero2.isAlive()){
                attackHeroes(hero2, hero1);
            }
        }
    }

    public void attackHeroes(Hero hero1, Hero hero2){
        if(hero1.isAlive()) {
            if(hero2.evadeAttack()){
                System.out.println(hero2.getName() + " уклонился от атаки героя " + hero1.getName());
            } else{
                System.out.println("Герой " + hero1.getName() + " атакует героя " + hero2.getName()
                        + " и наносит " + hero2.takeDamage(hero1.calculateDamage())
                        + " урона " + '[' + hero2.getHp()  + ']');
            }
            delayFight();
        } else System.out.println(hero1.getName() + " погиб.");
    }

    public void delayFight(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
