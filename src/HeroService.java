import HeroClasses.Assassin;
import HeroClasses.Hero;
import HeroClasses.Mage;
import HeroClasses.Warrior;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class HeroService {
    private Scanner scan = new Scanner(System.in);
    private List<Hero> heroes = new ArrayList<>();
    private List<Hero> aliveHeroes = new ArrayList<>();
    private FileService fileService = new FileService(this);
    private BattleService battleService = new BattleService();
    private InputService inputService = new InputService();



    public void addHero(){
        System.out.println("Выберите класс героя:\n1. Воин.\n2. Убийца.\n3. Маг.");
        int valueClass = inputService.readIntUntilCorrect();
        if (valueClass > 0 && valueClass <= 3){
            System.out.println("Введите имя, хп, урон, скорость");
            String name = inputService.readStringUntilCorrect();
            int hp = inputService.readIntUntilCorrect();
            int attackDamage = inputService.readIntUntilCorrect();
            int speed = inputService.readIntUntilCorrect();
            switch (valueClass){
                case 1:
                    heroes.add(new Warrior(name, hp, attackDamage, speed));
                    break;
                case 2:
                    heroes.add(new Assassin(name, hp, attackDamage, speed));
                    break;
                case 3:
                    heroes.add(new Mage(name, hp, attackDamage, speed));
                    break;
            }
            System.out.println("Герой успешно добавлен");
        }
    }
    public void clearHero(){
        heroes.clear();
    }
    public void addHeroForLoad(Hero hero){
        heroes.add(hero);
    }
    public List<Hero> getHeroes(){
        return heroes;
    }
    public void showAllHero(){
        int heroIndex = 1;
        System.out.println("---------------------------");
        for(Hero el : heroes){
            System.out.println(heroIndex + ". " + el.toString());
            heroIndex++;
        }
        System.out.println("---------------------------");
    }
    public Integer setCountValue(){
        showTextMenu();
            Integer count = inputService.readIntUntilCorrect();
            if (count > 10 || count < 0) {
                System.out.println("Такого варианта не существует");
                return null;
            }
            return count;
    }
    public void showTextMenu(){
        System.out.println("---------------------------\n" +
                "1. Добавить героя\n" +
                "2. Удалить героя\n" +
                "3. Найти героя\n" +
                "4. Показать всех героев\n" +
                "5. Отсортировать\n" +
                "6. Показать только живых\n" +
                "7. Сохранить\n" +
                "8. Загрузить\n" +
                "9. Провести бой\n" +
                "10. Показать статистику\n" +
                "0. Выход\n" +
                "---------------------------\n");
    }
    public void findForName(){
        String findName = scan.next();
        heroes.stream()
                .filter(hero -> hero.getName().equals(findName))
                .forEach(System.out::println);
    }
    public void showAliveHeroes(){
        int heroIndex = 1;
        aliveHeroes = new ArrayList<>(heroes.stream()
                .filter(hero -> hero.getHp() > 0)
                .toList());
        System.out.println("Список живых героев:");
        System.out.println("---------------------------");
        for (Hero el : aliveHeroes){
            System.out.println(heroIndex + ". " + el);
            heroIndex++;
        }
        System.out.println("---------------------------");
    }
    public void deleteHero() {
        System.out.println("Выберите героя для удаления");
        showAllHero();
        Integer deleteIndex = inputService.readIntUntilCorrect();
        if (deleteIndex < 1 || deleteIndex > heroes.size()) {
            System.out.println("Такого варианта не существует");}
        else {
            heroes.remove(deleteIndex - 1);
            System.out.println("Герой успешно удалён");
            showAllHero();
        }
    }
    public void sortHero(){
         heroes.sort((hero1,hero2) -> hero1.getName().compareTo(hero2.getName()));
         System.out.println("Отсортированный вид героев");
         showAllHero();
    }
    public boolean exitMenu(){
        return false;
    }
    public void fightStart(){
        Hero hero1 = chooseHero("Выберите первого бойца для сражения");
        Hero hero2 = chooseHero("Выберите второго бойца для сражения");
        if (hero1.getName().equals(hero2.getName())){
            System.out.println("Боец не может сражаться сам с собой");
        } else battleService.attackHero(hero1, hero2);
    }
    public Hero chooseHero(String info){
        System.out.println(info);
        showAliveHeroes();
        Integer index = null;
        while (true){
            index = inputService.readIntUntilCorrect();
            if (index <= 0 || index > aliveHeroes.size()){
                System.out.println("Недопустимое значение");
            } else return aliveHeroes.get(index - 1);
        }
    }
}
