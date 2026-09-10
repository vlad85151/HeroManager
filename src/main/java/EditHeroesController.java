import HeroClasses.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class EditHeroesController {
    private final HeroService heroService;
    private final FileService fileService;

    public EditHeroesController(HeroService heroService, FileService fileService){
        this.heroService = heroService;
        this.fileService = fileService;
    }

    @FXML
    private ListView<Hero> heroListView;
    @FXML
    private Button startEdit;
    @FXML
    private Button stopEdit;
    @FXML
    private TextField hpField;
    @FXML
    private TextField damageField;
    @FXML
    private TextField speedField;
    @FXML
    private Label resultLabel;
    @FXML
    private GridPane paneEdit;
    @FXML
    private VBox finalElements;

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
    private void startEdit(){
        Hero heroSelected = heroListView.getSelectionModel().getSelectedItem();
        if (heroSelected != null){

            paneEdit.setVisible(true);
            finalElements.setVisible(true);
            heroListView.setDisable(true);
            startEdit.setDisable(true);
            stopEdit.setDisable(false);
            hpField.setText(Integer.toString(heroSelected.getHp()));
            damageField.setText(Integer.toString(heroSelected.getAttackDamage()));
            speedField.setText(Integer.toString(heroSelected.getSpeed()));
        }

    }

    @FXML
    private void stopEdit(){
        paneEdit.setVisible(false);
        finalElements.setVisible(false);
        heroListView.setDisable(false);
        startEdit.setDisable(false);
        stopEdit.setDisable(true);
    }

    @FXML
    private void confirmEdit(){
        if(
                hpField.getText().trim().isEmpty() ||
                damageField.getText().trim().isEmpty() ||
                speedField.getText().trim().isEmpty()
        ){resultLabel.setText("Заполните все поля"); return;}

        try{
            Integer.parseInt(hpField.getText());
            Integer.parseInt(damageField.getText());
            Integer.parseInt(speedField.getText());
        } catch (Exception e){
            resultLabel.setText("В полях характеристик должны быть числа");
            return;
        }

        if(
                Integer.parseInt(hpField.getText()) < 1 ||
                Integer.parseInt(damageField.getText()) < 0 ||
                Integer.parseInt(speedField.getText()) < 0
        ) {resultLabel.setText("Недопустимые значения характеристик");return;}

        Hero heroSelected = heroListView.getSelectionModel().getSelectedItem();
        heroSelected.setHp(Integer.parseInt(hpField.getText()));
        heroSelected.setAttackDamage(Integer.parseInt(damageField.getText()));
        heroSelected.setSpeed(Integer.parseInt(speedField.getText()));

        paneEdit.setVisible(false);
        finalElements.setVisible(false);
        heroListView.setDisable(false);
        startEdit.setDisable(false);
        stopEdit.setDisable(true);
        heroListView.refresh();
    }
}
