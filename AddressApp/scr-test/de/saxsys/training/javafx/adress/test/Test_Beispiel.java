package de.saxsys.training.javafx.adress.test;

import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import de.saxsys.training.javafx.address.MainApp;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;


public class Test_Beispiel extends FxRobot  {
		
	@Before
    public void setup() throws Exception {
		FxToolkit.registerPrimaryStage();
		FxToolkit.setupApplication(MainApp.class);
		FxToolkit.showStage();				
    }

	@Test
    public void new_Entry() {
	    // when:
	    
	    FxAssert.verifyThat("#New", NodeMatchers.isNotNull());
        final Button button_new = lookup("#New").queryFirst();
        clickOn(button_new);
	    
	    // Vorname eintragen
	    final TextField test_firstNameField = lookup("#firstNameField").queryFirst();
	    doubleClickOn(test_firstNameField).write("Kay");
	    
	    // Nachname nachtragen
        final TextField test_lastNameField = lookup("#lastNameField").queryFirst();
        doubleClickOn(test_lastNameField).write("Grebenstein");
	    
        // Strasse eintragen
        final TextField test_streetField = lookup("#streetField").queryFirst();
        doubleClickOn(test_streetField).eraseText(0);
        doubleClickOn(test_streetField).write("Fritz-Foerster-Platz 2");
        
        // TextField postalCodeField;
        
        
        //  TextField cityField;
        
        // DatePicker birthdayField;
        
        final Button button_Ok = lookup("#Ok").queryFirst();
        clickOn(button_Ok);
        
        // then:
        FxAssert.verifyThat("Kay", LabeledMatchers.hasText("Kay"));
        FxAssert.verifyThat("Grebenstein", LabeledMatchers.hasText("Grebenstein"));
        
	}

	
    @Test
    public void click_Edit() {
        // when:    	 	    	
   	    FxAssert.verifyThat("Meier", NodeMatchers.isNotNull());
    	final TableCell test_cell = lookup("Meier").queryFirst();
    	clickOn(test_cell);

    	FxAssert.verifyThat("#Edit", NodeMatchers.isNotNull());
    	final Button button_edit = lookup("#Edit").queryFirst();
    	clickOn(button_edit);
    	
    	FxAssert.verifyThat("#lastNameField", NodeMatchers.isNotNull());
    	final TextField tf_Nachname = lookup("#lastNameField").queryFirst();
    	doubleClickOn(tf_Nachname).write("Müller");
    	
    	final Button button_Ok = lookup("#Ok").queryFirst();
    	clickOn(button_Ok);
    	               
        // then:
        FxAssert.verifyThat("Müller", LabeledMatchers.hasText("Müller"));
    }

    @Test
    public void loesche_Eintrag() {
        FxAssert.verifyThat("Kunz", NodeMatchers.isNotNull());
        final TableCell test_cell_Kunz = lookup("Kunz").queryFirst();
        clickOn(test_cell_Kunz);
        
        FxAssert.verifyThat("#Delete", NodeMatchers.isNotNull());
        final Button button_delete = lookup("#Delete").queryFirst();
        clickOn(button_delete);
    }
}
