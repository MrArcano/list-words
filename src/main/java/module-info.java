module com.exercises.listwords {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.exercises.listwords to javafx.fxml;
    exports com.exercises.listwords;
}