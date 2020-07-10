package BussinessLayer;


public class Volunteer extends Person 
{
	private String password;
	private String permission;


public Volunteer(int Id,String Name,String Gender,int Age,String pass,String permission) //constructor
{
	super(Id,Name,Gender,Age);
	this.permission=permission;
	this.password=pass;
	
}




//Permission Getter & Setter

public String getPermmission() {
	return permission;
}


public void setPermmission(String permmission) {
	this.permission = permmission;
}


//Password Getter & Setter

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

}