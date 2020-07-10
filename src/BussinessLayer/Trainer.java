package BussinessLayer;


public class Trainer extends Person
{
private int Experience ;
private String Specialty ;
private String Address ;
private int Phone_Number ;

public Trainer(int Id,String Name,String Gender,int Age,String Specialty,int Experience,int phone,String address)
{

	super(Id,Name,Gender,Age);
	this.Address=address;
	this.Experience=Experience;
	this.Phone_Number=phone;
	this.Specialty=Specialty;

}

// Phone_Number Getter & Setter

public int GetPhoneNumber() 
{
return Phone_Number;
}

public void SetPhoneNumber(int Phone_Number)
{
this.Phone_Number=Phone_Number;
}

// Address Getter & Setter

public String GetAddress() 
{
return Address;
}

public void SetAddress(String Address) 
{
this.Address=Address;
}

//Experience Getter & Setter

public int GetExperience() 
{
return Experience ;
}

public void SetExperience(int Experience)
{
this.Experience=Experience;
}

//Specialty Getter & Setter

public String GetSpecialty()
{
return Specialty;
}
public void SetSpecialty(String newspecialty)
{
this.Specialty=newspecialty;
}


}