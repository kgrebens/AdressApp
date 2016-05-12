package de.saxsys.training.javafx.adress.test;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.service.support.CaptureSupport;

import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static org.testfx.api.FxService.serviceContext;
import de.saxsys.training.javafx.address.MainApp;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import org.testfx.framework.junit.ApplicationTest;

public class Test_AndereControls_IT extends FxRobot  {

    
    private static final CaptureSupport captureSupport = serviceContext().getCaptureSupport();
    
       
	@Before
    public void setup() throws Exception {
		FxToolkit.registerPrimaryStage();
		FxToolkit.setupApplication(MainApp.class);
		FxToolkit.showStage();	
	}
	
	public static File captureScreenshot(String text) {
        Path captureFile = Paths.get("screenshot_" + text + "_" + new Date().getTime() + ".png");
        Image captureImage = captureSupport.captureRegion(Screen.getPrimary().getBounds());
        captureSupport.saveImage(captureImage, captureFile);
        return captureFile.toFile();
    }
	
	
    @Test
    public void arbeite_mit_Controls() {
        // when: 
    	
    	clickOn("Help");
    	clickOn("Dev Test");
    	
    	final Slider slidy = lookup("#slider").query();
    	    	
    	Point2D punkt1 = new Point2D(slidy.getScaleX(),slidy.getScaleY());
    	Point2D punkt2 = new Point2D(slidy.getScaleX()+150,slidy.getScaleY());
    	    	
    	final Point2D s_punkt1 = slidy.localToScreen(punkt1);
    	final Point2D s_punkt2 = slidy.localToScreen(punkt2);
 
    	System.out.println(s_punkt1);
    	System.out.println(s_punkt2);
    	
    	this.drag(s_punkt1);
    	this.dropTo(s_punkt2);   
    	
        Test_Beispiel_IT.captureScreenshot("arbeite_mit_Controls()");
    	
        // then:
        FxAssert.verifyThat("#label", LabeledMatchers.hasText("100.0"));
    }
     
    
    
    @After
    public void cleanStage() throws Exception {    
        FxToolkit.cleanupStages();        
    }
    

    
    
    

    
    

}
