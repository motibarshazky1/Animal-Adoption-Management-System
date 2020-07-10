package BussinessLayer;

public class Vet extends Person
{
private int Experience;
private String Specialty;
private int phone;
private String address;

public Vet(int Id,String Name,String Gender,int Age,String specialty,int experience,int phone,String address) //constructor
{
	super(Id,Name,Gender,Age);
	this.Experience=experience;
	this.Specialty=specialty;
	this.setPhone(phone);
	this.setAddress(address);

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

//Experience Getter & Setter

public int GetExperience() 
{
return Experience ;
}

public void SetExperience(int Experience)
{
this.Experience=Experience;
}


//address Getter & Setter

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}



//phone Getter & Setter

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}
}