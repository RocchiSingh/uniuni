package gui;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.*;
import javafx.scene.control.*;

public class LoginController {
    @FXML private Label lblerr;
    @FXML private Button btnlogin;
    @FXML private TextField txtusrname;


    @FXML protected void handleLoginButtonClick(ActionEvent event){

       String username= txtusrname.getText().toString();


    }


	
}
