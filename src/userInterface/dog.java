package userInterface;

public class dog extends Animal
{
	private boolean Guide_dog;

public dog(String Name,String Type,String Gender,int Age,int Hisun)
{
super(Name,Type,Gender,Age,Hisun);
}

public boolean IsForGuide()
{
return this.Guide_dog;
}
public void SetGuide(Boolean New_Status)
{
this.Guide_dog=New_Status;
}
}