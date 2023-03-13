module com.example.labsignin {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.labsignin to javafx.fxml;
    exports com.example.labsignin;
}