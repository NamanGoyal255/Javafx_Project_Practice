package pic;
import java.io.FileInputStream;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;


public class spgController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> coboroll;

    @FXML
    private DatePicker dob;
    
    @FXML
    private TextField txtname;

    @FXML
    private Label lblResp;

    @FXML
    private Label lblpath;

    @FXML
    private ImageView picPrev;

    @FXML
    private TextField txtPer;
    Connection con;
    PreparedStatement pst;
    @FXML
    void doShowall(ActionEvent event)
    {

    	try{
			pst=con.prepareStatement("select * from markssheet");
		ResultSet table=pst.executeQuery(); //array of objects
		while(table.next())
		{
			int roll=table.getInt("roll");//use table wale col ka name
			String sname=table.getString("sname");
			float per=table.getFloat("per");
			java.sql.Date dob= table.getDate("date");
			String picPath= table.getString("picpath");
			System.out.println(roll+"\t"+sname+"\t"+per+"\t"+dob.toString() +"\t"+picPath);
			
		}
		
		}	
		catch(Exception exp)
		{
			System.out.println(exp);
		}
    }

    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doDelete(ActionEvent event) 
    {

    	try{
        	int roll= Integer.parseInt(coboroll.getSelectionModel().getSelectedItem());
        	pst=con.prepareStatement("delete from markssheet where roll=?");
        	pst.setInt(1, roll);
        		int count=pst.executeUpdate();
        	if(count!=0)
        		lblResp.setText(count+ " Records Deleted");
        	else
        		lblResp.setText("Invalid ID");
        	}
        	catch(Exception exp)
        	{
        		System.out.println(exp.toString());
        	}
    }

    @FXML
    void doSave(ActionEvent event) {

    	int roll= Integer.parseInt(coboroll.getSelectionModel().getSelectedItem());
    	float per= Float.parseFloat(txtPer.getText());
    	LocalDate ld= dob.getValue();
    	java.sql.Date dt=java.sql.Date.valueOf(ld);
    															//in parameters
    	try {
				pst=con.prepareStatement("insert into markssheet values(?,?,?,?,?)");
				pst.setInt(1, roll);
				pst.setString(2, txtname.getText());
				pst.setFloat(3, per);
				pst.setDate(4, dt);
				pst.setString(5, lblpath.getText());
				pst.executeUpdate();
				lblResp.setText("Record Saved........");
				
			} 
    	catch (SQLException e) 
    		{
			  e.printStackTrace();
			}
    }

    @FXML
    void doSearch(ActionEvent event) 
    {
    	try{
			pst=con.prepareStatement("select * from markssheet where roll=?");
			int roll= Integer.parseInt(coboroll.getSelectionModel().getSelectedItem());
			pst.setInt(1, roll);
			
			
		ResultSet table=pst.executeQuery(); //array of objects
		while(table.next())
		{
			String sname=table.getString("sname");
			float per=table.getFloat("per");
			java.sql.Date dobb= table.getDate("date");
			String picPath= table.getString("picpath");
			
			txtname.setText(sname);
			txtPer.setText(String.valueOf(per));
			lblpath.setText(picPath);
						
			dob.setValue(dobb.toLocalDate());
			picPrev.setImage(new Image(new FileInputStream(picPath)));
			
			System.out.println(roll+"\t"+sname+"\t"+per+"\t"+dob.toString() +"\t"+picPath);
			
		}
		
		}	
		catch(Exception exp)
		{
			System.out.println(exp);
		}

    }

    @FXML
    void doSelectpic(ActionEvent event) 
    {

    	FileChooser fileChooser = new FileChooser();
   	 fileChooser.setTitle("Open Resource File");
   	 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif") );
   	 File selectedFile = fileChooser.showOpenDialog(null);
   	 
   	 if (selectedFile != null) {
   	    lblpath.setText(selectedFile.getPath());
   	    Image img=new Image(selectedFile.toURI().toString());
   	    System.out.println(selectedFile.toURI().toString());
   	   // picPrev.setImage(new Image(new FileInputStream(selectedFile)));
   	    picPrev.setImage(img);
   	 }
   	 else
   	 {
   		 lblpath.setText("nopic.jpg");
   	 }
    }

    @FXML
    void doUpdate(ActionEvent event)
    {

    	int roll= Integer.parseInt(coboroll.getSelectionModel().getSelectedItem());
    	float per= Float.parseFloat(txtPer.getText());
    	LocalDate ld= dob.getValue();
    	java.sql.Date dt=java.sql.Date.valueOf(ld);
    															//in parameters
    	try {
				pst=con.prepareStatement("update markssheet set  sname=?,per=?,date=?, picpath=? where roll=?");
				
				pst.setString(1, txtname.getText());
				pst.setFloat(2, per);
				pst.setDate(3, dt);
				pst.setString(4, lblpath.getText());
				pst.setInt(5, roll);
				
				int count=pst.executeUpdate();
				
				lblResp.setText(count+" Records Updated........");
				
			} 
    	catch (SQLException e) 
    		{
			  e.printStackTrace();
			}
    }
    void doFillRolls()
    {
    	try{
			pst=con.prepareStatement("select distinct roll from markssheet");
		ResultSet table=pst.executeQuery(); //array of objects
		while(table.next())
		{
			int roll=table.getInt("roll");//use table wale col ka name
			System.out.println(roll);
			coboroll.getItems().add(String.valueOf(roll));
		}
		
		}	
		catch(Exception exp)
		{
			System.out.println(exp);
		}
    }
    @FXML
    void initialize()
    {
    	lblpath.setText("nopic.jpg");
    	con=MysqlConnector.doConnect();
    	if(con==null)
    			System.out.println("Connection Problem");
    	else
    		System.out.println("Connected");

    	doFillRolls();
    }

    

   

}
