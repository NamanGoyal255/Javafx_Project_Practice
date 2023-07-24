package bill;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ngController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnbill;

    @FXML
    private CheckBox chkall;

    @FXML
    private CheckBox chkbag;

    @FXML
    private CheckBox chkbook;

    @FXML
    private CheckBox chkpen;

    @FXML
    private TextField txtitems;

    @FXML
    private TextField txtprices;

    @FXML
    private TextField txttot;
    
    @FXML
    private ToggleGroup kuch;

    @FXML
    private RadioButton rad10;

    @FXML
    private RadioButton rad20;

    @FXML
    private TextField txtdisc;
    
    @FXML
    private TextField txtnb;

    @FXML
    void dobill(ActionEvent event)
    {
    	String res1=""; 
    	String res2=""; 
    	int res3=0; 
    	if(chkpen.isSelected())
    	{
    		res1+="Pen,";
    		res2+="Rs20,";
    		res3+=20;
    	}
    	if(chkbag.isSelected())
    	{
    		res1+="Bag,";
    		res2+="Rs900,";
    		res3+=900;
    	}
    	if(chkbook.isSelected())
    	{
    		res1+="Book,";
    		res2+="Rs200,";
    		res3+=200;
    	}
    	res1=res1.substring(0, res1.length()-1);
    	res2=res2.substring(0, res2.length()-1);
    	txttot.setText(String.valueOf(res3));
    	txtitems.setText(res1);
    	txtprices.setText(res2);

    }

    @FXML
    void docheckall(ActionEvent event) 
    {
    	chkbag.setSelected(chkall.isSelected());
    	chkpen.setSelected(chkall.isSelected());
    	chkbook.setSelected(chkall.isSelected());

    }

    @FXML
    void doend(ActionEvent event)
    {
    	float nt=0,tt=0;
    	if(rad10.isSelected())
    	{
    	txtdisc.setText("10%");
    	tt=Integer.parseInt(txttot.getText());
    	nt=(tt*10)/100;
    	tt=tt-nt;
    	txtnb.setText(String.valueOf(tt));
    	
    	}
    	
    	else if(rad20.isSelected())
        	{
        	txtdisc.setText("20%");
        	tt=Integer.parseInt(txttot.getText());
        	nt=(tt*20)/100;
        	tt=tt-nt;
        	txtnb.setText(String.valueOf(tt));
        	
        	}
    	
    	

    }
    @FXML
    void initialize() {
        assert btnbill != null : "fx:id=\"btnbill\" was not injected: check your FXML file 'ng.fxml'.";
        assert chkall != null : "fx:id=\"chkall\" was not injected: check your FXML file 'ng.fxml'.";
        assert chkbag != null : "fx:id=\"chkbag\" was not injected: check your FXML file 'ng.fxml'.";
        assert chkbook != null : "fx:id=\"chkbook\" was not injected: check your FXML file 'ng.fxml'.";
        assert chkpen != null : "fx:id=\"chkpen\" was not injected: check your FXML file 'ng.fxml'.";
        assert txtitems != null : "fx:id=\"txtitems\" was not injected: check your FXML file 'ng.fxml'.";
        assert txtprices != null : "fx:id=\"txtprices\" was not injected: check your FXML file 'ng.fxml'.";
        assert txttot != null : "fx:id=\"txttot\" was not injected: check your FXML file 'ng.fxml'.";

    }

}
