package food;

import java.net.URL;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class mgController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboitems;
    
    @FXML
    private ListView<String> listitems1;

    @FXML
    private ListView<Integer> listitems2;
    
    @FXML
    private ListView<String> listitem3;

    @FXML
    private ListView<Integer> listitem4;
int count=0;
    @FXML
    void ComboOnselect(ActionEvent event) 
    {

    	String item=comboitems.getSelectionModel().getSelectedItem();
		if(item.equals("Burger"))
		{
			listitems1.getItems().clear();
			listitems2.getItems().clear();
			ArrayList<String> itemb=new ArrayList<String>(Arrays.asList("Cheese","Aloo Tikki","Veg Burger"));
			ArrayList<Integer> itembp=new ArrayList<Integer>(Arrays.asList(80,40,50));
			listitems1.getItems().addAll(itemb);
			listitems2.getItems().addAll(itembp);
		}
		else
		{
			listitems2.getItems().clear();
			listitems1.getItems().clear();
			ArrayList<String> itemp=new ArrayList<String>(Arrays.asList("Onion","Corn","Paneer"));
			ArrayList<Integer> itempp=new ArrayList<Integer>(Arrays.asList(180,240,350));
			listitems1.getItems().addAll(itemp);
			listitems2.getItems().addAll(itempp);
		}

    }
    @FXML
    void donext(MouseEvent event) 
    {
    	count+=1;
    	ObservableList<String> selItems=listitems1.getSelectionModel().getSelectedItems();
    	listitem3.getItems().addAll(selItems);
    	int index=listitems1.getSelectionModel().getSelectedIndex();
    	listitem4.getItems().add(listitems2.getItems().get(index));
    }
    
    @FXML
    void dodelete(MouseEvent event) 
    {
    	count-=1;

    	int index=listitem3.getSelectionModel().getSelectedIndex();
    	ObservableList<String> selItems=listitem3.getSelectionModel().getSelectedItems();
    	listitem3.getItems().removeAll(selItems);
    	listitem4.getItems().remove(index);
    }

    @FXML
    private TextField txtcal;

   

    @FXML
    void docalc(ActionEvent event)
    {
    	int res=0;
    	for(int i=0;i<count;i++)
    	{
    		res+=listitem4.getItems().get(i);
    	}
    	txtcal.setText(String.valueOf(res));
    }

    @FXML
    void initialize() {
    	ArrayList<String> items=new ArrayList<String>(Arrays.asList("Pizza","Burger"));
    	
    	comboitems.getItems().addAll(items);
    

    }

}
