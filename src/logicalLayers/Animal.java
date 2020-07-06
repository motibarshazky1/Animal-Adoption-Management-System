package logicalLayers;


 public abstract class Animal {
	public static final String dog="DOG";
	public static final String Cat="CAT";
	public abstract String getType();
	public abstract String getGender();
	public  abstract int getAge();
	public  abstract int getHisun();
	public abstract int getId();
	public abstract void setId(int id);
	public abstract String getName();
}


/*class Animal{
    
    private String Name;
    private String Type;
    private String Gender;
    private int Age;
    private int Hisun;
     private int id;
    
    public Animal(String Name,String Type,String Gender,int Age,int Hisun){
        this.Name = Name;
        this.Gender=Gender;
        this.Type = Type;
        this.Age = Age;
        this.Hisun = Hisun;
        Random random = new Random();

        id=random.nextInt(10000 + 1 - 1000) + 1000;
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
}*/