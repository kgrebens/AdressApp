package de.saxsys.training.javafx.adress.test;

import org.junit.*;
import org.testfx.api.*;
import javafx.scene.control.*;
import de.saxsys.training.javafx.address.MainApp;
import org.testfx.matcher.control.*;
import javafx.geometry.Point2D;


// import static org.testfx.api.FxAssert.verifyThat;
// import static org.testfx.service.query.impl.NodeQueryUtils.hasText;

public class Test_AndereControls_IT extends FxRobot  {
	   
	@Before
    public void setup() throws Exception {
		FxToolkit.registerPrimaryStage();
		FxToolkit.setupApplication(MainApp.class);
		FxToolkit.showStage();		
	}
	
	
		
	/*
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
    	
        // then:
        FxAssert.verifyThat("#label", LabeledMatchers.hasText("100.0"));
    } 
    */  
    
    /*
    @After
    public void cleanStage() throws Exception {    
        FxToolkit.cleanupStages();        
    }
    */
    

    
    

}
