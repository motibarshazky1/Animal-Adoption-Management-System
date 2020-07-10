package BussinessLayer;


public class PotentialAdopter extends Person
{

	String Mail;
	int phone;
	String Animal_type;
	String Animal_Gender;
	String Ages;

	public PotentialAdopter(int Id,String Name,int phone,String mail,String Animal_type,String Animal_Gender,String Ages) { //constructor
	super(Id,Name);
	this.Mail=mail;
	this.phone=phone;
	this.Animal_type=Animal_type;
	this.Animal_Gender=Animal_Gender;
	this.Ages=Ages;	}



public String getMail() {
		return Mail;
	}


	public void setMail(String mail) {
		Mail = mail;
	}


	public String getAnimal_type() {
		return Animal_type;
	}


	public void setAnimal_type(String animal_type) {
		Animal_type = animal_type;
	}


	public String getAnimal_Gender() {
		return Animal_Gender;
	}


	public void setAnimal_Gender(String animal_Gender) {
		Animal_Gender = animal_Gender;
	}


	public String getAges() {
		return Ages;
	}


	public void setAges(String ages) {
		Ages = ages;
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

public int getPhone() {
	return phone;

}


public void setPhone(int phone) {
	this.phone = phone;
}



}


	
