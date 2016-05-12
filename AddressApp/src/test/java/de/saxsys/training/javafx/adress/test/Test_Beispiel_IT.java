package de.saxsys.training.javafx.adress.test;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.service.support.CaptureSupport;

import java.io.File;
import java.util.Date;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import org.testfx.util.WaitForAsyncUtils;
import static org.testfx.api.FxService.serviceContext;
import de.saxsys.training.javafx.address.MainApp;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

public class Test_Beispiel_IT extends FxRobot  {
		
    private static final CaptureSupport captureSupport = serviceContext().getCaptureSupport();
    
	@Before
    public void setup() throws Exception {
	    Stage stage = FxToolkit.registerPrimaryStage();
		FxToolkit.setupApplication(MainApp.class);
		FxToolkit.showStage();
		// stage.showAndWait();
    } 
	
	public static File captureScreenshot(String text) {
        Path captureFile = Paths.get("screenshot_" + text + "_" + new Date().getTime() + ".png");
        Image captureImage = captureSupport.captureRegion(Screen.getPrimary().getBounds());
        captureSupport.saveImage(captureImage, captureFile);
        return captureFile.toFile();
    }

	@Test
    public void new_Entry() {
	    // when:	    
	    FxAssert.verifyThat("#New", NodeMatchers.isNotNull());
        clickOn("#New");	    
	    doubleClickOn("#firstNameField").write("Kay");
	    doubleClickOn("#lastNameField").write("Grebenstein");
	    doubleClickOn("#streetField").eraseText(0);
        doubleClickOn("#streetField").write("Fritz-Foerster-Platz 2");    
        clickOn("#Ok");
        
        Test_Beispiel_IT.captureScreenshot("new_Entry");
        
        WaitForAsyncUtils.waitForFxEvents();
        
        Test_Beispiel_IT.captureScreenshot("new_Entry");
                
        // then:
        FxAssert.verifyThat("Kay", LabeledMatchers.hasText("Kay"));
        FxAssert.verifyThat("Grebenstein", LabeledMatchers.hasText("Grebenstein"));
        
	}

	
    @Test
    public void click_Edit() {
        // when:    	 	    	
   	    FxAssert.verifyThat("Meier", NodeMatchers.isNotNull());
    	final TableCell test_cell = lookup("Meier").query();
    	clickOn(test_cell);

    	FxAssert.verifyThat("#Edit", NodeMatchers.isNotNull());
    	final Button button_edit = lookup("#Edit").query();
    	clickOn(button_edit);
    	
    	FxAssert.verifyThat("#lastNameField", NodeMatchers.isNotNull());
    	final TextField tf_Nachname = lookup("#lastNameField").query();
    	doubleClickOn(tf_Nachname).write("Müller");
    	
    	final Button button_Ok = lookup("#Ok").query();
    	clickOn(button_Ok);
    	
        Test_Beispiel_IT.captureScreenshot("click_Edit");

    	WaitForAsyncUtils.waitForFxEvents();
    	
    	Test_Beispiel_IT.captureScreenshot("click_Edit");
    	               
        // then:
        FxAssert.verifyThat("Müller", LabeledMatchers.hasText("Müller"));
    }

    @Test
    public void loesche_Eintrag() {
        FxAssert.verifyThat("Kunz", NodeMatchers.isNotNull());
        final TableCell test_cell_Kunz = lookup("Kunz").query();
        clickOn(test_cell_Kunz);
        
        Test_Beispiel_IT.captureScreenshot("loesche_Eintrag");
        
        FxAssert.verifyThat("#Delete", NodeMatchers.isNotNull());
        final Button button_delete = lookup("#Delete").query();
        clickOn(button_delete);
    }
    
    
    @After
    public void cleanStage() throws Exception {               
        
        FxToolkit.cleanupStages();
        
    }
}

