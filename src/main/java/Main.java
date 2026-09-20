import java.util.Random;

public class Main {
    public static void main(String[] args){
        HeroService heroService = new HeroService();
        FileService fileService = new FileService(heroService);
        Random random = new Random();
        boolean start = true;

        System.out.println(random.nextInt(100 - 1 + 1) + 1);

        while (start == true){
            Integer  count = heroService.setCountValue();
            if (count == null){
                continue;
            }
            switch (count){
                case 0:
                    start = heroService.exitMenu();
                    break;
                case 1: // Добавить героя
                    heroService.addHero();
                    break;
                case 2: // удалить героя
                    //heroService.deleteHero();
                    break;
                case 3: // найти героя
                    //heroService.findForName();
                    break;
                case 4: // показать всех героев
                    heroService.showAllHero();
                    break;
                case 5: // сортировка
                    heroService.sortHero();
                    break;
                case 6: // показать только живых
                    heroService.showAliveHeroes();
                    break;
                case 7: // сохранение
                     fileService.saveData();
                    break;
                case 8: // загрузка
                    fileService.loadData();
                    break;
                case 9: // провести бой
                    heroService.fightStart();
                    break;
            }
        }
    }
}


//=========================
//RPG HERO MANAGER
//=========================
//
//1. Добавить героя
//2. Удалить героя
//3. Найти героя
//4. Показать всех
//5. Отсортировать
//6. Показать только живых
//7. Сохранить
//8. Загрузить
//9. Провести бой
//10. Показать статистику
//0. Выход