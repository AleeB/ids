package com.example.visualizzatore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class visualizzatore extends Application {
    private double scale = 1.0;
    private double translateX = 0;
    private double translateY = 0;
    private double lastX, lastY;
    private double realWidth, realHeight;
    private Pane root;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        String fileName = "parete_300x250.jpg"; // Simulazione del file
        extractRealDimensions(fileName);

        Image image = new Image("file:" + fileName);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);

        // Gestione del pan
        imageView.setOnMousePressed(event -> {
            lastX = event.getSceneX();
            lastY = event.getSceneY();
        });

        imageView.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - lastX;
            double deltaY = event.getSceneY() - lastY;
            translateX += deltaX;
            translateY += deltaY;
            imageView.setTranslateX(translateX);
            imageView.setTranslateY(translateY);
            lastX = event.getSceneX();
            lastY = event.getSceneY();
        });

        // Gestione dello zoom
        imageView.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = (event.getDeltaY() > 0) ? 1.1 : 0.9;
            scale *= zoomFactor;
            imageView.setScaleX(scale);
            imageView.setScaleY(scale);
        });

        // Trova coordinate
        imageView.setOnMouseClicked(this::findCoordinates);

        // Inserisci coordinate (test con valori di esempio)
        insertCoordinates(50, 100); // Distanza da sinistra e dal pavimento in cm

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Visualizzatore Immagini");
        primaryStage.show();
    }

    private void extractRealDimensions(String fileName) {
        Pattern pattern = Pattern.compile(".*_(\\d+)x(\\d+)\\.jpg");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.matches()) {
            realWidth = Double.parseDouble(matcher.group(1));
            realHeight = Double.parseDouble(matcher.group(2));
        } else {
            System.out.println("Formato nome file non valido.");
        }
    }

    private void findCoordinates(MouseEvent event) {
        double imgX = event.getX() / scale;
        double imgY = event.getY() / scale;
        double leftDist = imgX * (realWidth / 800);
        double topDist = imgY * (realHeight / 600);
        double rightDist = realWidth - leftDist;
        double bottomDist = realHeight - topDist;

        System.out.println("Coordinate: L:" + leftDist + "cm, R:" + rightDist + "cm, T:" + topDist + "cm, B:" + bottomDist + "cm");
    }

    private void insertCoordinates(double leftDist, double bottomDist) {
        double imgX = (leftDist / realWidth) * 800 * scale;
        double imgY = (1 - (bottomDist / realHeight)) * 600 * scale;

        Circle marker = new Circle(imgX, imgY, 5, Color.RED);
        root.getChildren().add(marker);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
