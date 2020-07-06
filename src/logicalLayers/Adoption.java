package logicalLayers;

public class Adoption
{

	int Adoption;
	//String Date;
	public Animal animal;
	public Adopter adopter;
	

public Adoption(int Adoption1,Animal animal1,Adopter adopter1)
{
this.Adoption=Adoption1;
this.animal=animal1;
this.adopter=adopter1;

}


public int getID(){               // Case ID
    return this.Adoption;
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