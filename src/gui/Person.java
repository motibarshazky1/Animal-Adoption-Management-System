package gui;


public class Person 
{
private String Name ;
private int Id;
private int Age;
private String Gender ;


public Person(String Name,String Gender,int Id,int Age)//constructor
{
this.Name=Name;
this.Id=Id;
this.Age=Age;
this.Gender=Gender;
}


public String GetName() 
{
return this.Name;
}


public int GetId() 
{
return this.Id;
}


public String GetGender()
{
return this.Gender;
}


public int GetAge()
{
return this.Age;
}


public void SetName(String name)
{
this.Name=name;
}


public void SetAge(int age)
{
this.Age=age;
}
public void SetId(int id)
{
this.Id=id;
}
public void SetGender(String gender)
{
this.Gender=gender;
}


}