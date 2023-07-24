package marks;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class marks1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtcpp;

    @FXML
    private TextField txtdsa;

    @FXML
    private TextField txtjava;

    @FXML
    private TextField txtper;

    @FXML
    private TextField txtres;

    @FXML
    private TextField txttotal;

    @FXML
    private Button btnper;
    @FXML
    void doper(ActionEvent event)
    {
       int tot=Integer.parseInt(txttotal.getText());
       float per=tot/3;
       txtper.setText(String.valueOf(per));
    }

    @FXML
    void dores(ActionEvent event) 
    {
    	float net=Float.parseFloat(txtper.getText());
    	if(net>33)
    	{
    		txtres.setText(" Congratulations U are Pass");
    	}
    	else
    	{
    		txtres.setText("Thankyou Better lucck next time!!!");
    	}

    }

    @FXML
    void dosum(ActionEvent event)
    {
    	int a=Integer.parseInt(txtcpp.getText());
    	int b=Integer.parseInt(txtjava.getText());
    	int c=Integer.parseInt(txtdsa.getText());
    	int sum=a+b+c;
    	txttotal.setText(String.valueOf(sum));
    	btnper.setDisable(false);
    }

    @FXML
    void initialize() {
        assert txtcpp != null : "fx:id=\"txtcpp\" was not injected: check your FXML file 'marks1.fxml'.";
        assert txtdsa != null : "fx:id=\"txtdsa\" was not injected: check your FXML file 'marks1.fxml'.";
        assert txtjava != null : "fx:id=\"txtjava\" was not injected: check your FXML file 'marks1.fxml'.";
        assert txtper != null : "fx:id=\"txtper\" was not injected: check your FXML file 'marks1.fxml'.";
        assert txtres != null : "fx:id=\"txtres\" was not injected: check your FXML file 'marks1.fxml'.";
        assert txttotal != null : "fx:id=\"txttotal\" was not injected: check your FXML file 'marks1.fxml'.";

    }

}

