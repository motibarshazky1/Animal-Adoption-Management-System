package gui;


public class Trainer extends Person
{
private int Experience ;
private String Speciality ;
private String Address ;
private int Phone_Number ;

public Trainer(int Id,String Name,String Speciality,int Experience,String Gender,int Age,int phone,String Address)
{

	super(Name,Gender,Id,Age);
	this.Address=Address;
	this.Experience=Experience;
	this.Phone_Number=phone;
	this.Speciality=Speciality;
	this.SetAge(Age);
	this.SetName(Name);
	this.SetId(Id);
	this.SetGender(Gender);
}

public int GetPhoneNumber() 
{
return Phone_Number;
}

public String GetAddress() 
{
return Address;
}

public void SetPhoneNumber(int Phone_Number)
{
this.Phone_Number=Phone_Number;
}

public void SetAddress(String Address) 
{
this.Address=Address;
}
public int GetExperience() 
{
return Experience ;
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