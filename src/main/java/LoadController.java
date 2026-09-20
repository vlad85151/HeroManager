import HeroClasses.Hero;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Optional;


public class LoadController
{
    private final HeroService heroService;
    private final FileService fileService;

    public LoadController(HeroService heroService, FileService fileService){
        this.heroService = heroService;
        this.fileService = fileService;
    }


    @FXML
    private ListView<Hero> heroListView;

    @FXML
    private Label labelInfo;


    @FXML
    public void initialize() {

        labelInfo.setText(tryLoadHeroes());
        heroListView.setCellFactory(listView -> new ListCell<Hero>() {
            @Override
            protected void updateItem(Hero hero, boolean empty) {
                super.updateItem(hero, empty);

                if (empty || hero == null) {
                    setText(null);
                } else {
                    setText(
                            hero.getName() + " | " + hero.getClassName() + "\n" +
                                    "Здоровье: " + hero.getHp() +
                                    " | Урон: " + hero.getAttackDamage() +
                                    " | Скорость: " + hero.getSpeed()
                    );
                }
            }
        });
    }

    private String tryLoadHeroes(){
        fileService.loadData();
        heroListView.setItems(heroService.getHeroes());

        //System.out.println(heroService.findHero("Vlad"));

        return "Загрузка прошла успешно";
    }
}
