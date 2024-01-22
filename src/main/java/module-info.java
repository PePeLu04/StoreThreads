module org.joseluis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens org.joseluis to javafx.fxml;
    exports org.joseluis;
    opens org.joseluis.Controller to javafx.fxml;
    opens org.joseluis.domain to java.xml.bind;
}
