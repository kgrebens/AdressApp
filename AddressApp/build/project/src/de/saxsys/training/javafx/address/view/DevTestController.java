package de.saxsys.training.javafx.address.view;

import org.controlsfx.control.CheckComboBox;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class DevTestController {
    @FXML
    private CheckComboBox<String> box;
    @FXML
    private Label label;
    @FXML
    private Slider slider;
    
    public void initialize() {
    	try {
        	box.getItems().add("a");
        	box.getItems().add("b");
        	box.getItems().add("c");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	label.textProperty().bind(slider.valueProperty().asString());
	}
}
