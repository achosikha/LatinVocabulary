module com.example.latinvocabulary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    opens com.example.latinvocabulary to javafx.fxml;
    exports com.example.latinvocabulary;
}