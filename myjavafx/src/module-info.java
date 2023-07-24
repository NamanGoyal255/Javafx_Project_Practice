module myjavafx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens mypack to javafx.graphics, javafx.fxml;
	opens marks to javafx.graphics, javafx.fxml;
	opens bill to javafx.graphics, javafx.fxml;
	opens food to javafx.graphics, javafx.fxml;
	opens pic to javafx.graphics, javafx.fxml;
}
