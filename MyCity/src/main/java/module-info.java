module grupo6.mycity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens grupo6.mycity to javafx.fxml;
    exports grupo6.mycity;
}
