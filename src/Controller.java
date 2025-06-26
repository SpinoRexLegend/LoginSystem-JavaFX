import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button login, reset;
    @FXML
    private Label registerId, headerLabel;
    @FXML
    private PasswordField password;
    @FXML
    private TextField userName;

    String user, pass;
    Database database = new Database();

    public void submit(ActionEvent event)
    {
        user = userName.getText();
        pass = password.getText();
        if(database.checkUserPassword(user,pass))
        {
            headerLabel.setText("Welcome "+user);
            registerId.setText("");
        }
        else
        {
            password.setText("");
            registerId.setText("Incorrect Id/Password");
        }
    }
    public void reset(ActionEvent event)
    {
        password.setText("");
        userName.setText("");
    }
    public void resetPassword(ActionEvent event) throws IOException {
        Parent newNode = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newNode);
        stage.setScene(newScene);
        stage.show();
    }

    public void register(ActionEvent event) throws IOException {
        Parent newNode = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newNode);
        stage.setScene(newScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
