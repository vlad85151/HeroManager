import HeroClasses.Assassin;
import HeroClasses.Hero;
import HeroClasses.Mage;
import HeroClasses.Warrior;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    private HeroService heroService;

    public FileService(HeroService heroService){
        this.heroService = heroService;
    }
    public void saveData(){
        try (FileWriter writer = new FileWriter("HeroData.txt")){
            System.out.println(heroService.getHeroes());
            for (Hero el : heroService.getHeroes()){
                writer.write(el.saveInfo());
                writer.write("\n");
            }
            System.out.println("Сохранение прошло успешно");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("HeroData.txt"));
            heroService.clearHero();
            String line;
            String[] data;
            while((line = reader.readLine()) != null){
                data = line.split(";");
                switch (data[0]){
                    case "Warrior":
                        heroService.addHeroForLoad(new Warrior(data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                        break;
                    case "Assassin":
                        heroService.addHeroForLoad(new Assassin(data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                        break;
                    case "Mage":
                        heroService.addHeroForLoad(new Mage(data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3]), Integer.parseInt(data[4])));
                        break;

                }
                //heroService.addHeroForLoad(new Hero(data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3]), Integer.parseInt(data[4])));
            }
            System.out.println("Герои успешно загружены");
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
