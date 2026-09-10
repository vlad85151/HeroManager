import HeroClasses.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class DeleteController {

    private final HeroService heroService;
    private final FileService fileService;

    public DeleteController(HeroService heroService, FileService fileService){
        this.heroService = heroService;
        this.fileService = fileService;
    }


    @FXML
    private ListView<Hero> heroListView;

    @FXML
    private Label labelDeleteInfo;

    @FXML
    private HBox boxButtons;


    @FXML
    public void initialize() {

        heroListView.setItems(heroService.getHeroes());

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

    @FXML
    private void startDelete(){
        Hero seletedHero = heroListView.getSelectionModel().getSelectedItem();
        if (seletedHero != null)
        {
            labelDeleteInfo.setVisible(true);
            boxButtons.setVisible(true);
        }
    }

    @FXML
    private void YesDelete(){
        Hero seletedHero = heroListView.getSelectionModel().getSelectedItem();
        heroService.deleteHero(seletedHero);
        labelDeleteInfo.setVisible(false);
        boxButtons.setVisible(false);
    }

    @FXML
    private void NoDelete(){
        labelDeleteInfo.setVisible(false);
        boxButtons.setVisible(false);
    }


}
