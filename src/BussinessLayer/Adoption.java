package BussinessLayer;

public class Adoption
{

	int Adoption;
	public Animal animal;
	public Adopter adopter;
	

public Adoption(int Adoption1,Animal animal1,Adopter adopter1)
{
this.Adoption=Adoption1;
this.animal=animal1;
this.adopter=adopter1;
animal1.setStatus(false);

}


public int getID(){               // Case ID
    return this.Adoption;
}
public void setID(int id){               // Case ID
    this.Adoption=id;
}


public String getAnimalName(){    // Name Animal
    return this.animal.getName();
}

public int getAnimalID(){         // id Animal
    return this.animal.getId();
}

public String getAdopterName(){    // Name Adopter
    return adopter.GetName();
}

public int getAdopterID(){         // id Adopter
    return adopter.GetId();
}

}