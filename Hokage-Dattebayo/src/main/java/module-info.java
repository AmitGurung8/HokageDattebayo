module org.example.hokagedattebayo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires okhttp3;


    opens org.example.hokagedattebayo to javafx.fxml;
    exports org.example.hokagedattebayo;
    exports org.example.hokagedattebayo.Controllers;
    opens org.example.hokagedattebayo.Controllers to javafx.fxml;
    exports org.example.hokagedattebayo.Models;
    opens org.example.hokagedattebayo.Models to javafx.fxml;
}