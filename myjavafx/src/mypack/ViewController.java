package mypack;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtcpp;
    
    @FXML
    private TextField txtjava;

    @FXML
    private TextField txtdsa;
    
    @FXML
    private Button btnper;

    @FXML
    private TextField txttotal;

    @FXML
    void doSum(ActionEvent event) {
    	int c = Integer.parseInt(txtcpp.getText());
    	int d = Integer.parseInt(txtdsa.getText());
    	
    	int sum = c+d;
    	txttotal.setText(String.valueOf(sum));
    	
    	btnper.setDisable(false);
    }

    @FXML
    void initialize() {
        assert txtcpp != null : "fx:id=\"txtcpp\" was not injected: check your FXML file 'View.fxml'.";
        assert txtdsa != null : "fx:id=\"txtdsa\" was not injected: check your FXML file 'View.fxml'.";
        assert txttotal != null : "fx:id=\"txttotal\" was not injected: check your FXML file 'View.fxml'.";

    }

}
