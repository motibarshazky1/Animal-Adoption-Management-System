package gui;

import userInterface.Person;

public class Volunteer extends Person 
{
private int Experience;

public Volunteer(String Name,String Gender,int Id,int Age) //constructor
{
	super(Name,Gender,Id,Age);

}
public int GetExperience()
{
return this.Experience;
}

public void SetExperience(int Experience)
{
this.Experience=Experience;
}
}