import HeroClasses.Hero;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {

    private final HeroService heroService = new HeroService();
    private final FileService fileService = new FileService(heroService);

    @FXML
    private StackPane contentPane;



    @FXML
    private void showAddHero() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("AddHero.fxml"));

        loader.setControllerFactory(controllerClass -> {
            if (controllerClass == AddHeroController.class) {
                return new AddHeroController(heroService, fileService);
            }

            return null;
        });

        Parent view = loader.load();

        contentPane.getChildren().setAll(view);
    }


    @FXML
    private void showLoadHeroes() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("LoadHeroes.fxml"));

        loader.setControllerFactory(controllerClass -> {
            if (controllerClass == LoadController.class) {
                return new LoadController(heroService, fileService);
            }

            return null;
        });

        Parent view = loader.load();

        contentPane.getChildren().setAll(view);
    }

    @FXML
    private void showSaveHeroes() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("SaveHeroes.fxml"));

        loader.setControllerFactory(controllerClass -> {
            if (controllerClass == SaveController.class) {
                return new SaveController(heroService, fileService);
            }

            return null;
        });

        Parent view = loader.load();

        contentPane.getChildren().setAll(view);
    }


    @FXML
    private void showDeleteHero() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("DeleteHero.fxml"));

        loader.setControllerFactory(controllerClass -> {
            if (controllerClass == DeleteController.class) {
                return new DeleteController(heroService, fileService);
            }

            return null;
        });

        Parent view = loader.load();

        contentPane.getChildren().setAll(view);
    }

    @FXML
    private void showEditHero() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("EditHeroes.fxml"));

        loader.setControllerFactory(controllerClass -> {
            if (controllerClass == EditHeroesController.class) {
                return new EditHeroesController(heroService, fileService);
            }

            return null;
        });

        Parent view = loader.load();

        contentPane.getChildren().setAll(view);
    }

    @FXML
    private void showFindHero() throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("FindHero.fxml"));

        loader.setControllerFactory(controllerClass -> {
            if (controllerClass == FindHeroController.class) {
                return new FindHeroController(heroService);
            }

            return null;
        });

        Parent view = loader.load();

        contentPane.getChildren().setAll(view);
    }

}
