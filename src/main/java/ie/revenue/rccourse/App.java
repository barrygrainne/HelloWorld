package ie.revenue.rccourse;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Hello world!
 *
 */
public class App implements Displayable
{ 
	public static String Organisation = "Revenue Commissioners";
	
	public static void displayOrganisation(){ // have static member variable
		System.out.println(Organisation); // have access to static member function
	}
	// properties
	protected String name ="";
	
	protected String password = "";
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	protected ArrayList<String> months = new ArrayList<>();
	// get & set methods
    public String getName() {
		return name;
	}
    public void setName(String name) {
		this.name = name;
	}
    // constructors
    public App(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		
		
		populateMonths();		

		
	}
	public App(){
		populateMonths();
	}
	public String toJson() {
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			json = objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json = "{}";
		}
		return json;
	}
	public void populateMonths(){
		
		// clear the list
		months.clear();
		months.add("Jan");
		months.add("Feb");
		months.add("Mar");
		months.add("Apr");
		months.add("May");
		months.add("Jun");
		months.add("Jul");
		months.add("Aug");
		months.add("Sep");
		months.add("Oct");
		months.add("Nov");
		months.add("Dec");
	}
	public ArrayList<String> getMonths() {
		return months;
	}
	public void setMonths(ArrayList<String> months) {
		this.months = months;
		
	}
	
	public static void main(String[] args){
		
		App app = new App("Grainne", "secret");
		System.out.println(app.toJson());
		
		System.out.println(App.Organisation); // App as in the name of the class itself
		
		App.displayOrganisation(); // member function
		
		// System.out.println(app.Organisation); // we don't do this way anymore
		
		System.out.println(Math.PI); // everything in the math class is static , never create an instance of the math class
		
		System.out.println(Math.random());
		
		app.display();
		
		Displayable d = app; // creating an object of type displayable, assign displayable is equal to app
		
		d.display(); // display the exact same object
		
		
		
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(toJson());
		
	}

/*	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ArrayList<String>months= new ArrayList<>();

        months.add("January");
        months.add("February");
        months.add("March");

        ObjectMapper objectMapper = new ObjectMapper();
        String json;

        try {

        json = objectMapper.writeValueAsString(months);
      } catch (JsonProcessingException e) {
  		json = "{}";
    
      }
        System.out.println(json);
    } */

	
}
