package logicalLayers;

public class AnimalFactory {
	
	//public AnimalFactory() {}
	
	 

	public Animal createAnimal(int id,String Name,String animalType,String Gender,int Age,int Hisun) {
	    if(animalType.equalsIgnoreCase("DOG")){
	         return new dog(id,Name,"DOG", Gender,Age, Hisun ); 
	      	}
	      else if(animalType.equalsIgnoreCase("CAT")){
	         return new Cat(id,Name, "CAT", Gender,Age, Hisun );
	      	}
	      else {
	    	 
	    	  return null;
	      	}
	}
	
}