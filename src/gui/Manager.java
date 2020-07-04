package gui;

public class Manager extends Person
{
	
private int Management_Experience;

public Manager(String Name,String Gender,int Id,int Age) //constructor
{
	super(Name,Gender,Id,Age);

}


public int GetManagementExperience()
{
return this.Management_Experience;
}

public void SetManagementExperience(int Experience)
{
this.Management_Experience=Experience ;
}
}