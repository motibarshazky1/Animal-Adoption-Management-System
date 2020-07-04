package userInterface;


public class Trainer extends Person
{
private int Experience ;
private String Speciality ;
private String Address ;
private int Phone_Number ;

public Trainer(String Name,String Gender,int Id,int Age)
{
	super(Name,Gender,Id,Age);

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