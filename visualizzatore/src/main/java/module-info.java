module com.example.visualizzatore {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.visualizzatore to javafx.fxml;
    exports com.example.visualizzatore;
}