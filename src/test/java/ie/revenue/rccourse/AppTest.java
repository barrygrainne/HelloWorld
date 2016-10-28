package ie.revenue.rccourse;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest { // when the automated routine test executed by maven it will look for 

@Before

public void setup(){
	// this function sets things up for the test
	System.out.println("#########setup() method called");
}
@After

public void tearDown(){
	// this function restores things to the way they
	//were before the tests were run
	System.out.println("##########tearDown() method called");
}

@Test

	public void testJsonStuff(){
	
	App app = new App("Grainne", "secret");
	System.out.println(app.toJson());
}
    @Test
    public void testMonths(){
    	App app = new App();
    	ArrayList<String>months= app.getMonths();
    	
    	assertTrue(months.contains("Jan"));
    }
    @Test
    public void testApp() // actual test
    {
    	App app = new App("Grainne", "pwd");
 
        assertTrue( app.getName() != null );
        
        App app2 = new App();

        assertTrue( app2.getName() != null );
        
        ArrayList<String> months = app.getMonths();
        
        assertTrue(months.size() == 12);
        
        assertTrue(app2.getMonths().size() == 12);
        
        app2.populateMonths();
        assertTrue(app2.getMonths().size() == 12);
    }
}
