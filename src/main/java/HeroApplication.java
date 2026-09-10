import HeroClasses.Hero;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class HeroApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/Main.fxml")
        );

        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);

        stage.setScene(scene);
        stage.setTitle("RPGHeroManager");
        stage.show();
    }

//    @Override
//    public void start(Stage stage) {
//
//
//        VBox root = new VBox(20);
//        HBox buttons = new HBox(10);
//
//
//
//        root.setPadding(new Insets(20,0,0,20));
//
//        Button loadHeroesButton = new Button("Загрузить героев");
//        Button saveHeroesButton = new Button("Сохранить героев");
//        Button addHeroesButton = new Button("Добавить героя");
//        Button deleteHeroesButton = new Button("Удалить героя");
//        Button editHeroesButton = new Button("Редактировать героя");
//
//        buttons.getChildren().addAll(
//                loadHeroesButton,
//                saveHeroesButton,
//                addHeroesButton,
//                deleteHeroesButton,
//                editHeroesButton
//        );
//
//        root.getChildren().add(buttons);
//
//
//        loadHeroesButton.setOnAction(event -> {loadHero(root);});
//        addHeroesButton.setOnAction(event -> {addHeroes(root);});
//        saveHeroesButton.setOnAction(event -> {saveHeroes(root);});
//        deleteHeroesButton.setOnAction(event -> {deleteHero(root);});
//        editHeroesButton.setOnAction(event -> {editHeroes(root);});
//
//            Scene scene = new Scene(root, 800, 600);
//            stage.setScene(scene);
//            stage.setTitle("RPGHeroManager");
//            stage.show();
//
//    }

    public static void main(String[] args) {
        launch(args);
    }
//
//    private void loadHero(VBox root){
//        root.getChildren().removeIf(grid -> grid instanceof GridPane);
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        root.getChildren().add(grid);
//        fileService.loadData();
//
//        List<String> heroesList = heroService.showAllHero();
//        ListView<String> heroListView = new ListView<>();
//
//        heroListView.getItems().addAll(heroesList);
//        grid.add(heroListView, 0, 0);
//    }
//    private void addHeroes(VBox root){
//        root.getChildren().removeIf(grid -> grid instanceof GridPane);
//
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        root.getChildren().add(grid);
//
//
//        TextField nameField = new TextField("");
//        grid.add(new Label("Имя: "), 0, 0);
//        grid.add(nameField, 1, 0, 4, 1);
//
//        TextField hpField = new TextField();
//        grid.add(new Label("Здоровье: "), 0, 1);
//        grid.add(hpField, 1, 1, 4, 1);
//
//        TextField damageField = new TextField();
//        grid.add(new Label("Урон: "), 0, 2);
//        grid.add(damageField, 1, 2, 4, 1);
//
//        TextField speedField = new TextField();
//        grid.add(new Label("Скорость: "), 0, 3);
//        grid.add(speedField, 1, 3, 4, 1);
//
//        Label classLabel = new Label("Класс: ");
//        Button warriorButton = new Button("Воин");
//        Button assasinButton = new Button("Убийца");
//        Button mageButton = new Button("Маг");
//        grid.add(classLabel, 0, 4);
//        grid.add(warriorButton, 1, 4);
//        grid.add(assasinButton, 2, 4);
//        grid.add(mageButton, 3, 4);
//
//        Button buttonCreate = new Button("Создать");
//        grid.add(buttonCreate, 0, 5);
//
//        Label chooseClass = new Label();
//        Label resultLabel = new Label();
//
//        grid.add(resultLabel, 0, 6, 4,1);
//
//        warriorButton.setOnAction(event1 -> chooseClass.setText("Warrior"));
//        assasinButton.setOnAction(event2 -> chooseClass.setText("Assassin"));
//        mageButton.setOnAction(event3 -> chooseClass.setText("Mage"));
//
//        buttonCreate.setOnAction(event4 -> {
//            if (chooseClass.getText().isEmpty()){resultLabel.setText("Выберите класс");return;}
//            if(
//                    nameField.getText().trim().isEmpty() ||
//                            hpField.getText().trim().isEmpty() ||
//                            damageField.getText().trim().isEmpty() ||
//                            speedField.getText().trim().isEmpty()
//            ){resultLabel.setText("Заполните все поля"); return;}
//
//            try{
//                Integer.parseInt(hpField.getText());
//                Integer.parseInt(damageField.getText());
//                Integer.parseInt(speedField.getText());
//            } catch (Exception e){
//                resultLabel.setText("В полях характеристик должны быть числа");
//                return;
//            }
//
//            if(
//                    Integer.parseInt(hpField.getText()) < 1 ||
//                            Integer.parseInt(damageField.getText()) < 0 ||
//                            Integer.parseInt(speedField.getText()) < 0
//            ) {resultLabel.setText("Недопустимые значения характеристик");return;}
//
//            heroService.addHero(
//                    nameField.getText(),
//                    Integer.parseInt(hpField.getText()),
//                    Integer.parseInt(damageField.getText()),
//                    Integer.parseInt(speedField.getText()),
//                    chooseClass.getText()
//            );
//            resultLabel.setText("Герой успешно добавлен!");
//        });
//    }
//    private void saveHeroes(VBox root){
//        root.getChildren().removeIf(grid -> grid instanceof GridPane);
//        GridPane grid = new GridPane();
//        grid.setVgap(10);
//        grid.setHgap(10);
//        grid.add(new Label("Герои успешно сохранены"), 0, 0);
//        root.getChildren().add(grid);
//        fileService.saveData();
//    }
//    private void deleteHero(VBox root){
//        root.getChildren().removeIf(grid -> grid instanceof GridPane);
//        GridPane grid = new GridPane();
//        grid.setVgap(10);
//        grid.setHgap(10);
//        root.getChildren().add(grid);
//
//        ListView<Hero> heroListView = new ListView<>();
//        heroListView.setItems(heroService.getHeroes());
//
//        heroListView.setCellFactory(listView -> new ListCell<Hero>()
//        {
//            @Override
//            protected void updateItem(Hero hero, boolean empty){
//                super.updateItem(hero, empty);
//
//                if (empty || hero == null){
//                    setText(null);
//                } else {
//                    setText(hero.getName() + " | " + hero.getClassName() + "\n" +
//                            "Здоровье: " + hero.getHp() +
//                            " | Урон: " + hero.getAttackDamage() +
//                            " | Скорость: " + hero.getSpeed());
//                }
//
//            }
//        });
//
//
//        grid.add(heroListView, 0,0, 1, 5);
//
//        Label deleteInfoLabel = new Label("Выберите героя для удаления");
//        Label confirmDeleteHero = new Label();
//        Button confirmDeleteButton = new Button("Удалить");
//
//        Button yesDeleteButton = new Button("Да");
//        Button noDeleteButton = new Button("Нет");
//
//        grid.add(deleteInfoLabel, 1, 0, 1, 1);
//        grid.add(confirmDeleteButton, 1, 1);
//
//        HBox deleteButtons = new HBox(5);
//        deleteButtons.getChildren().add(confirmDeleteHero);
//        grid.add(deleteButtons, 1, 3);
//
//        confirmDeleteButton.setOnAction(event1 -> {
//            Hero heroesSelected = heroListView.getSelectionModel().getSelectedItem();
//            if(heroListView.getSelectionModel().getSelectedItems().isEmpty()){
//                confirmDeleteHero.setText("Вы должны выбрать героя");
//                return;
//            }
//            confirmDeleteHero.setText("Удалить выбранного героя?");
//            deleteButtons.getChildren().add(yesDeleteButton);
//            deleteButtons.getChildren().add(noDeleteButton);
//
//            noDeleteButton.setOnAction(event2 -> {
//                deleteInfoLabel.setText("Выберите героя для удаления");
//                confirmDeleteHero.setText("");
//                deleteButtons.getChildren().removeIf(button -> button instanceof Button);
//            });
//            yesDeleteButton.setOnAction(event2 -> {
//                heroService.deleteHero(heroesSelected);
//                confirmDeleteHero.setText("Герой удалён.");
//                deleteButtons.getChildren().removeIf(button -> button instanceof Button);
//
//            });
//        });
//    }
//    private void editHeroes(VBox root){
//        root.getChildren().removeIf(grid -> grid instanceof GridPane);
//
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        root.getChildren().add(grid);
//
//        ListView<Hero> heroListView = new ListView<>();
//        heroListView.setItems(heroService.getHeroes());
//
//        heroListView.setCellFactory(listView -> new ListCell<Hero>()
//        {
//            @Override
//            protected void updateItem(Hero hero, boolean empty){
//                super.updateItem(hero, empty);
//
//                if (empty || hero == null){
//                    setText(null);
//                } else {
//                    setText(hero.getName() + " | " + hero.getClassName() + "\n" +
//                            "Здоровье: " + hero.getHp() +
//                            " | Урон: " + hero.getAttackDamage() +
//                            " | Скорость: " + hero.getSpeed());
//                }
//            }
//        });
//
//        grid.add(heroListView, 0,0, 1, 9);
//
//        Label infoLabel = new Label("Выберите героя для редактирвоания");
//        grid.add(infoLabel, 1, 0);
//
//        Button startEdit = new Button("Редактировать");
//        Button stopEdit = new Button("Отменить");
//        Button confirmEdit = new Button("Применить");
//
//        HBox editBoxOne = new HBox(10);
//        editBoxOne.getChildren().addAll(startEdit, stopEdit);
//        grid.add(editBoxOne, 1, 1);
//
//        startEdit.setOnAction(event -> {
//            Hero heroSelect = heroListView.getSelectionModel().getSelectedItem();
//            grid.getChildren().removeIf(child -> child instanceof HBox || GridPane.getRowIndex(child) > 2);
//            if (heroListView.getSelectionModel().getSelectedItem() == null){
//                infoLabel.setText("Герой не выбран");
//            } else {
//                heroListView.setDisable(true);
//                startEdit.setDisable(true);
//                confirmEdit.setDisable(false);
//                HBox hpBox = new HBox(5);
//                TextField hpHero = new TextField(Integer.toString(heroSelect.getHp()));
//                hpBox.getChildren().addAll(new Label("Здоровье"), hpHero);
//                grid.add(hpBox, 1, 2);
//
//                HBox damageBox = new HBox(5);
//                TextField damageHero = new TextField(Integer.toString(heroSelect.getAttackDamage()));
//                damageBox.getChildren().addAll(new Label("Урон"), damageHero);
//                grid.add(damageBox, 1, 3);
//
//                HBox speedBox = new HBox(5);
//                TextField speedHero = new TextField(Integer.toString(heroSelect.getSpeed()));
//                speedBox.getChildren().addAll(new Label("Скорость"), speedHero);
//                grid.add(speedBox, 1, 4);
//
//                HBox confirmBox = new HBox(10);
//                Label infoConformLabel = new Label("");
//                confirmBox.getChildren().addAll(confirmEdit,infoConformLabel);
//                grid.add(confirmBox, 1, 5);
//
//                stopEdit.setOnAction(event1 -> {
//                    startEdit.setDisable(false);
//                    heroListView.setDisable(false);
//                    grid.getChildren().removeIf(child -> child instanceof HBox || GridPane.getRowIndex(child) > 2);
//                });
//
//                confirmEdit.setOnAction(event1 -> {
//                    if(
//                            hpHero.getText().trim().isEmpty() ||
//                            damageHero.getText().trim().isEmpty() ||
//                            speedHero.getText().trim().isEmpty()
//                    ){infoConformLabel.setText("Заполните все поля"); return;}
//
//                    try{
//                        Integer.parseInt(hpHero.getText());
//                        Integer.parseInt(damageHero.getText());
//                        Integer.parseInt(speedHero.getText());
//                    } catch (Exception e){
//                        infoConformLabel.setText("В полях характеристик должны быть числа");
//                        return;
//                    }
//                    if(
//                            Integer.parseInt(hpHero.getText()) < 1 ||
//                            Integer.parseInt(damageHero.getText()) < 0 ||
//                            Integer.parseInt(speedHero.getText()) < 0
//                    ) {infoConformLabel.setText("Недопустимые значения характеристик");return;}
//
//                    heroSelect.setHp(Integer.parseInt(hpHero.getText()));
//                    heroSelect.setAttackDamage(Integer.parseInt(damageHero.getText()));
//                    heroSelect.setSpeed(Integer.parseInt(speedHero.getText()));
//                    infoConformLabel.setText("Герой успешно отредактирвоан!");
//
//                    hpHero.setText("");
//                    damageHero.setText("");
//                    speedHero.setText("");
//                    startEdit.setDisable(false);
//                    heroListView.setDisable(false);
//                    confirmEdit.setDisable(true);
//                    heroListView.refresh();
//
//                });
//
//            }
//        });
//
//
//
////        TextField nameField = new TextField("");
////        grid.add(new Label("Имя: "), 0, 0);
////        grid.add(nameField, 1, 0, 4, 1);
////
////        TextField hpField = new TextField();
////        grid.add(new Label("Здоровье: "), 0, 1);
////        grid.add(hpField, 1, 1, 4, 1);
////
////        TextField damageField = new TextField();
////        grid.add(new Label("Урон: "), 0, 2);
////
////        TextField speedField = new TextField();
////        grid.add(new Label("Скорость: "), 0, 3);
////
////
////        Button buttonCreate = new Button("Создать");
////        grid.add(buttonCreate, 0, 5);
////
////        Label resultLabel = new Label();
////
////        grid.add(resultLabel, 0, 6, 4,1);
////
////
////        buttonCreate.setOnAction(event4 -> {
////            if (chooseClass.getText().isEmpty()){resultLabel.setText("Выберите класс");return;}
////            if(
////                    nameField.getText().trim().isEmpty() ||
////                            hpField.getText().trim().isEmpty() ||
////                            damageField.getText().trim().isEmpty() ||
////                            speedField.getText().trim().isEmpty()
////            ){resultLabel.setText("Заполните все поля"); return;}
////
////            try{
////                Integer.parseInt(hpField.getText());
////                Integer.parseInt(damageField.getText());
////                Integer.parseInt(speedField.getText());
////            } catch (Exception e){
////                resultLabel.setText("В полях характеристик должны быть числа");
////                return;
////            }
////
////            if(
////                    Integer.parseInt(hpField.getText()) < 1 ||
////                            Integer.parseInt(damageField.getText()) < 0 ||
////                            Integer.parseInt(speedField.getText()) < 0
////            ) {resultLabel.setText("Недопустимые значения характеристик");return;}
////
////            heroService.addHero(
////                    nameField.getText(),
////                    Integer.parseInt(hpField.getText()),
////                    Integer.parseInt(damageField.getText()),
////                    Integer.parseInt(speedField.getText()),
////                    chooseClass.getText()
////            );
////            resultLabel.setText("Герой успешно добавлен!");
////        });
//    }
}