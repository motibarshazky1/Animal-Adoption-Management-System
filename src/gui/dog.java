package gui;

public class dog implements Animal
{
	private boolean Guide_dog;
	  private String Name;
	    private String Type;
	    private String Gender;
	    private int Age;
	    private int Hisun;
	     private int id;


public dog( int id,String Name,String Type,String Gender,int Age,int Hisun) {
	
	this.id=id;
	this.Name=Name;
	this.Type=Type;
	this.Gender=Gender;
	this.Age=Age;
	this.Hisun=Hisun;
}

public boolean IsForGuide()
{
return this.Guide_dog;
}
public void SetGuide(Boolean New_Status)
{
this.Guide_dog=New_Status;
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
}