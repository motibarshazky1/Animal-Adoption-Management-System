package BussinessLayer;


public class Adopter extends Person
{
	String Occupation;
	String Address;
	int Phone_Number;
	String Mail;


public Adopter(int Id,String Name,String Gender,int Age,String Occupation, int phone, String address,String mail) //constructor
{
	super(Id,Name,Gender,Age);
	this.Address=address;
	this.Occupation=Occupation;
	this.Phone_Number=phone;
	this.Mail=mail;
}

//Occupation Getter & Setter

public String GetOccupation()
{
return this.Occupation;
}
public void SetOccupation(String newoccupation)
{
this.Occupation=newoccupation;
}


//Phone_Number Getter & Setter

public int GetPhoneNumber()
{
return this.Phone_Number;
}

public void SetPhoneNumber(int phone)
{
this.Phone_Number=phone;
}


//Address Getter & Setter

public String GetAddress()
{
return this.Address;
}

public void SetAddress(String Address1)
{
this.Address=Address1;
}



//Mail Getter & Setter

public String GetMail()
{
return this.Mail;
}
public void SetMail(String newmail)
{
this.Mail=newmail;
}



}


	
