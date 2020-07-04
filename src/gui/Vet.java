package gui;

public class Vet extends Person
{
private int Experience;
private String Speciality;

public Vet(String Name,String Gender,int Id,int Age) //constructor
{
	super(Name,Gender,Id,Age);

}
public int GetExperience() 
{
return Experience;
}

public String GetSpeciality() 
{
return Speciality;
}

public void SetExperience(int Experience)
{
this.Experience=Experience;
}
}