import HeroClasses.Hero;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Optional;


public class FindHeroController
{
    private final HeroService heroService;

    public FindHeroController(HeroService heroService ){
        this.heroService = heroService;
    }


    @FXML
    private ListView<Hero> heroListView;

    @FXML
    private TextField textFindField;

    @FXML
    private Label labelFindInfo;

    @FXML
    private void startFind(){
        if (textFindField.getText().trim().isEmpty()){
            labelFindInfo.setText("заполните поле!");
            return;
        }
        Optional<Hero> result = heroService.findHero(textFindField.getText());

        Hero hero = result.orElseThrow(() ->
                new RuntimeException("Герой не найден")
        );
    }
}
