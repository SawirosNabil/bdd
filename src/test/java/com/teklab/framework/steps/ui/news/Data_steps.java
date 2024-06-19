package com.teklab.framework.steps.ui.news;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Data_steps {


	@Given("User chose city as {string} and state as {string}")
	public void user_chose_city_as_and_state_as(String arg1, String arg2) {
		System.out.println("User chosen the city as "+ arg1 + " and the state as " +  arg2);
	}

	@When("add {int} to {int}")
	public void add_to(Integer int1, Integer int2) {
		System.out.println(" adding " + int1 + " to the second number" + int2);
	}


@When("walk {double} mile")
	public void walk_mile(Double double1) {
		 System.out.println("User walked " + double1 + " mile");
	}

@Then("user should say hello")
	public void user_should_say_hello() {
		System.out.println("Hey, user said 'hello!'");
	}

@Given("User is {string} level")
public void user_is_level(String arg) {
	 System.out.println("Hey, this user is at " + arg + " level");
}



@Then("User should be able to {string}")
public void user_should_be_able_to(String arg) {
	 System.out.println("This user could do " + arg);
}

@Given("I have following grade")
public void i_have_following_grade(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	
	List<   List<String>   >		mydata		= dataTable.asList(List.class);
	
	String subject = mydata.get(1).get(0); //Math
	String grade = mydata.get(1).get(1); //B
	System.out.println("For subject "+ subject + " I have the grade of " + grade);
}


@Then("I am happy")
public void i_am_happy() {
	 System.out.println("Then I am happy");




























}

}







