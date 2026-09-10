import HeroClasses.Hero;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AddHeroController {

    private final HeroService heroService;
    private final FileService fileService;

    public AddHeroController(HeroService heroService, FileService fileService){
        this.heroService = heroService;
        this.fileService = fileService;
    }

    @FXML
    private ListView<Hero> heroListView;
    @FXML
    private TextField nameField;
    @FXML
    private TextField hpField;
    @FXML
    private TextField damageField;
    @FXML
    private TextField speedField;
    @FXML
    private Label classLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private Button addHeroButton;
    @FXML
    private VBox paneAddHero;

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
    private void selectWarrior(){
        classLabel.setText("Warrior");
    }
    @FXML
    private void selectMage(){
        classLabel.setText("Mage");
    }
    @FXML
    private void selectAssassin(){
        classLabel.setText("Assassin");
    }

    @FXML
    private void createHero(){

            if (classLabel.getText().isEmpty()){resultLabel.setText("Выберите класс");return;}
            if(
                    nameField.getText().trim().isEmpty() ||
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

            heroService.addHero(
                    nameField.getText(),
                    Integer.parseInt(hpField.getText()),
                    Integer.parseInt(damageField.getText()),
                    Integer.parseInt(speedField.getText()),
                    classLabel.getText()
            );
            resultLabel.setText("Герой успешно добавлен!");
    }
}
