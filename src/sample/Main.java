package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    public static List<String> readFileInList(String fileName) {
        List<String> lines = List.of();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        Button button = new Button("Show random number");
        Label label = new Label("");
        Random random = new Random();
        String file = "D:/test/woj.txt";
        List<String> lista = readFileInList(file);

        button.setOnAction(event -> label.setText(lista.get(random.nextInt(lista.size()))));
        root.getChildren().addAll(button, label);
        primaryStage.setTitle("Java Button");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}