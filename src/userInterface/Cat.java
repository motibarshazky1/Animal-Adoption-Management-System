package userInterface;

public class Cat extends Animal
{
	
private Boolean Is_Domesticated;

public Cat(String Name,String Type,String Gender,int Age,int Hisun)
{
super(Name,Type,Gender,Age,Hisun);
}


public Boolean IsDomesticated()
{
return this.Is_Domesticated;
}

public void SetDomesticated(Boolean New_Status)
{
this.Is_Domesticated=New_Status;
}
}
