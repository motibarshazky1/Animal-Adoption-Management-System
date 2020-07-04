
class Animal{
    
    private String Name;
    private String Type;
    private String Gender;
    private int Age;
    private int Hisun;
    
    public Animal(String Name,String Type,String Gender,int Age,int Hisun){
        this.Name = Name;
        this.Gender=Gender;
        this.Type = Type;
        this.Age = Age;
        this.Hisun = Hisun;
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
}