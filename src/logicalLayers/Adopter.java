package logicalLayers;

import userInterface.Person;

public class Adopter extends Person
{
	String Occupation;
	String Adress;
	int Phone_Number;

	//String Favoroite_Animals_Type;

public Adopter(int Id,String Name,String Gender,int Age,String Occupation, int phone, String address) //constructor
{
	super(Name,Gender,Id,Age);
	this.Adress=address;
	this.Occupation=Occupation;
	this.Phone_Number=phone;

}
public int GetPhoneNumber()
{
return this.Phone_Number;
}

public String GetAdress()
{
return this.Adress;
}

public void SetPhoneNumber(int phone)
{
this.Phone_Number=phone;
}

public void SetAdress(String Address1)
{
this.Adress=Address1;
}

public String GetOccupation()
{
return this.Occupation;
}

public String GetAdopterName()
{
return this.GetName();
}
public int GetAdopterID()
{
return this.GetId();
}
}


	
