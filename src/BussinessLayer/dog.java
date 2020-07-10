package BussinessLayer;


public class dog implements Animal
{
	  private String Name;
	    private String Type;
	    private String Gender;
	    private int Age;
	    private int Hisun;
	     private int id;
	     private Boolean status;
	 	private boolean Guide_dog;





public dog( int id,String Name,String Type,String Gender,int Age,int Hisun,Boolean status) {
	this.id=id;
	this.Name=Name;
	this.Type=Type;
	this.Gender=Gender;
	this.Age=Age;
	this.Hisun=Hisun;
	this.status=status;

	//this.image=image;
	}



public dog(int id,String Name,String Type,String Gender,int Age,int Hisun)
{	
	this.id=id;
	this.Name=Name;
	this.Type=Type;
	this.Gender=Gender;
	this.Age=Age;
	this.Hisun=Hisun;
	this.status=true;
	//this.image=image;
	//this.Is_Domesticated=Is_Domesticated;
	}


public String getName(){
    return this.Name;
}

public String getGender(){
    return this.Gender;
}

public String getType(){
    return this.Type;
}

public int getAge(){
    return this.Age;
}

public int getHisun(){
    return this.Hisun;
} 
public int getId(){
    return this.id;
} 
public void setId(int newId){
    this.id=newId;
} 
/*
public File getImage(){
    return this.image;
} 

public void setImage(File newfile){
    this.image=newfile;
} */

public Boolean getStatus() {
	return status;
}

public void setStatus(Boolean status) {
	this.status = status;
}



public boolean isGuide_dog() {
	return Guide_dog;
}



public void setGuide_dog(boolean guide_dog) {
	Guide_dog = guide_dog;
}
}