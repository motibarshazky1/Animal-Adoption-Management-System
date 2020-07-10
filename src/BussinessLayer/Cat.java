package BussinessLayer;


public class Cat implements Animal
{
	 private String Name;
	    private String Type;
	    private String Gender;
	    private int Age;
	    private int Hisun;
	     private int id;
	     private Boolean status;
	     private Boolean Is_Domesticated;






public Cat(int id,String Name,String Type,String Gender,int Age,int Hisun,Boolean status)
{	
	this.id=id;
	this.Name=Name;
	this.Type=Type;
	this.Gender=Gender;
	this.Age=Age;
	this.Hisun=Hisun;
	this.status=status;
	
	}




public Cat(int id,String Name,String Type,String Gender,int Age,int Hisun)
{	
	this.id=id;
	this.Name=Name;
	this.Type=Type;
	this.Gender=Gender;
	this.Age=Age;
	this.Hisun=Hisun;
	this.status=true;
	
	}


public Boolean IsDomesticated()
{
return this.Is_Domesticated;
}

public void SetDomesticated(Boolean New_Status)
{
this.Is_Domesticated=New_Status;
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




public Boolean getStatus() {
	return status;
}




public void setStatus(Boolean status) {
	this.status = status;
}
}

