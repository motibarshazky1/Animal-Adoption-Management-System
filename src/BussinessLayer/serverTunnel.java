package BussinessLayer;


import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import dataLayer.db_connection;
import userInterfaceLayer.MainWindow;
import userInterfaceLayer.Work;


public class serverTunnel
{
	private static Statement st;
	private static PreparedStatement pst;
	private static serverTunnel instance;

private serverTunnel() {

}

public serverTunnel getserverTunnel() { // return Connection.
   return instance;
}

public static serverTunnel getInstance() throws SQLException { // create new db_connection instance.
   if (instance == null) { // NO Instance
	   
	       instance = new serverTunnel();
   } 
   return instance; // return the exist instance
}



public void AnimalToDB(Animal animal,File selectedFile)  // Input - Animal -> Output Animal Details in DB. $$
{

	
		try {
			
		//File file=new File(path);
		FileInputStream fis=new FileInputStream(selectedFile);
	
		
		try {
			String query1="SELECT count(*) as id FROM sos.animals;"; // This query is for check animal count for next id

			ResultSet rs=SelectCommand(query1);
			while(rs.next())
       	{
			int next_id=rs.getInt("id")+1;
       	   animal.setId(next_id);
       	}
		     			
   		}catch(Exception e1)
   		{
   			System.err.println(e1);
   		}

			String query="Insert into animals "
					+ "(ID,Date,Name,Type,Gender,Age,Hisun,Picture) "
					+ "values("+animal.getId()+",now(),'"+animal.getName()
					+"','"+animal.getType()+"',"+ "'"+animal.getGender()
					+"',"+animal.getAge()+","+animal.getHisun()+",?);"; 

			InsertCommand(query,fis);
       		 	fis.close();
	
	
	
}
		 catch(Exception e1)
 		{
 			System.err.println(e1);
 		}

}


public void UpdateAnimalInDB(Animal newAnimal,String path)  // Input - ID + Animal -> Output Update Animal Details in DB.
{
	int flag=0;
if(newAnimal.getStatus()==true)
	flag=1;
	String query;
		 query ="UPDATE sos.animals SET ID="+
		 newAnimal.getId()+", Name ='"+newAnimal.getName()+
		 "', Type ='"+newAnimal.getType()+"',Gender ='"+newAnimal.getGender()+
		 "',Age ="+ newAnimal.getAge()+",Hisun ="+ newAnimal.getHisun()+",Picture=?,Status="+flag+" WHERE id="+newAnimal.getId()+";";
		 UpdateDB(query,path); 		 
		 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
	 	
		 
}

public void UpdateAnimalInDB(Animal newAnimal)  // Input - ID + Animal -> Output Update Animal Details in DB.

{
	int flag=0;
	if(newAnimal.getStatus()==true)
		flag=1;
	String query="";
try {

		 query ="UPDATE sos.animals SET ID="+newAnimal.getId()+", Name ='"+newAnimal.getName()+"', Type ='"+newAnimal.getType()+"',Gender ='"+newAnimal.getGender()+"',Age ="+ newAnimal.getAge()+",Hisun ="+ newAnimal.getHisun()+",Status="+flag+" WHERE id="+newAnimal.getId()+";";
		UpdateDB(query);

		 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
	 	
}
catch(Exception e1)
{
	System.err.println(query);

} 
}



public ImageIcon ImageByAnimal(Animal animal,int height,int width)  // 

{
	ImageIcon newImage=null;
	 try {
   	   		
				//serverTunnel tunnel= new serverTunnel();
				String query1 ="SELECT Picture FROM animals WHERE id="+animal.getId()+";";
	     		 ResultSet rs = SelectCommand(query1);
	     		 
		 	 if(rs.next()){
               byte[] img = rs.getBytes("Picture");
	       		ImageIcon image = new ImageIcon(img);
	       		Image im=image.getImage();
	       		Image myImage=im.getScaledInstance( width,  height, Image.SCALE_SMOOTH);
	       		 newImage = new ImageIcon(myImage);
	     	 }
	      	} catch (SQLException ex) {
	             Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
	         }	
	 return newImage;
}



public String DateByCase(Adoption case1)  // 

{
	String date="";
	 try {
   	   		
				//serverTunnel tunnel= new serverTunnel();
				String query1 ="SELECT Date FROM adoptions WHERE Adoption_ID="+case1.getID()+";";
	     		 ResultSet rs = SelectCommand(query1);
	     		 
		 	 if(rs.next()){
		 		 date=rs.getString("Date");
                 	 }
	      	} catch (SQLException ex) {
	             Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
	         }	
	 return date;
}







public  ArrayList<Animal> getAnimals() 
/* pull all animals from DB to ArrayList of Animals and return the ArrayList.
*/
{
ArrayList<Animal> animals = new ArrayList<Animal>();
    
    ResultSet rs;
    String query;
    Animal u;
    
    try {
        
        
        	//serverTunnel tunnel= new serverTunnel();
  		 query = "SELECT * FROM animals where status=1";
  		 rs = SelectCommand(query);
  		 
        while(rs.next()){ // loop over all the Animals in DB.
        	
      	  AnimalFactory animalFctory = new AnimalFactory();
   		
            u =  animalFctory.createAnimal(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Type"),
                    rs.getString("Gender"),
                    rs.getInt("Age"),
                    rs.getInt("Hisun"),true

   	    		
            );

            animals.add(u);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
    return animals;

}


public ArrayList<Adoption> getAdoptions(){
    
    ArrayList<Adoption> adoptions = new ArrayList<Adoption>();
    ResultSet rs;
    String query;
  
    Adoption case1;
    
    try {
        
        	//serverTunnel tunnel= new serverTunnel();
  		 query = "SELECT * FROM adoptions";
  		 rs = SelectCommand(query);
        
        while(rs.next()){
      	  
        	AnimalFactory animalFctory = new AnimalFactory();
       		
            Animal animal =  animalFctory.createAnimal(
                    rs.getInt("Animal_ID"),
                    rs.getString("Animal_Name"),
                    rs.getString("Animal_Type"),
                    rs.getString("Animal_Gender"),
                    rs.getInt("Animal_Age"),
                    rs.getInt("Animal_Hisun"),false);
        	
        	
        	Adopter adopter=new Adopter(
        			rs.getInt("Adopter_ID"),  rs.getString("Adopter_Name"),
        			rs.getString("Adopter_Gender"), rs.getInt("Adopter_Age"),
        			rs.getString("Adopter_Occupation"), rs.getInt("Adopter_phone"),
        			rs.getString("Adopter_address"), rs.getString("Adopter_mail"));

        	
        	case1=new Adoption(rs.getInt("Adoption_ID"), animal, adopter);
        	
  
            adoptions.add(case1);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

    return adoptions;
}



public ArrayList<Vet> getVets(){
    
    ArrayList<Vet> vets = new ArrayList<Vet>();
    
    ResultSet rs;
    String query;
    Vet vet;
    
    try {
        
        
     	
        
		 query = "SELECT * FROM proffesional_services where Job='VET' order by Job,Experience DESC";

		 //else  query = "SELECT * FROM proffesional_services";

		 
  		 rs = SelectCommand(query);
  		 
        
        while(rs.next()){
   		vet=new Vet(
   				rs.getInt("ID"),rs.getString("Name"), 
   				rs.getString("Gender"), rs.getInt("Age"),
   				rs.getString("Speciality"),rs.getInt("Experience"),
   				rs.getInt("Phone"),rs.getString("Address"));
           

            vets.add(vet);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

    
    return vets;
}







public void case_Insertion(int id, Animal animal,Adopter adopter) // this function get Animal, Adopter, create case object and insert it to DB.
{
	Adoption case1= new Adoption(id, animal, adopter);

	 UpdateAnimalInDB(animal);
	 String query="Insert into adopters (ID,Name,Gender,Age,Occupation,Phone,Address,Mail) values ("+
				adopter.GetId()+",'"+adopter.GetName()+"','"+adopter.GetGender()+"',"+adopter.GetAge()+
				",'"+adopter.GetOccupation()+"',"+adopter.GetPhoneNumber()+",'"+adopter.GetAddress()+"','"+adopter.GetMail()+"');";
				try {
						InsertCommand(query);
				}catch(Exception e1)
		 		{
		 			System.err.println(e1);

		 		} 
	 
	 
	 try {
			String query1="SELECT count(*) as id FROM sos.adoptions;"; // This query is for check animal count for next id
			//serverTunnel tunnel1=new serverTunnel();

			ResultSet rs=SelectCommand(query1);
			while(rs.next())
      	{
				case1.setID(rs.getInt("id")+1);

      	}
		     			
  		}catch(Exception e1)
  		{
  			System.err.println(e1);
  		}
	 
		String query5="Insert into sos.adoptions (Adoption_ID,Date,Animal_Name,Animal_ID,Animal_Type,Animal_Gender,Animal_Age,Animal_Hisun,"
				+ "Adopter_ID,Adopter_name,Adopter_Gender,Adopter_Age,Adopter_Occupation,Adopter_Phone,Adopter_Address,Adopter_Mail) values ("
				+ case1.getID()+",now(),'"+case1.animal.getName()+"',"+case1.animal.getId()
				+",'"+case1.animal.getType()+"','"+case1.animal.getGender()
				+"',"+case1.animal.getAge()+","+case1.animal.getHisun()
				+","+case1.adopter.GetId()+",'"+case1.adopter.GetName()
				+"','"+case1.adopter.GetGender()+"',"+case1.adopter.GetAge()
				+",'"+case1.adopter.GetOccupation()+"',"+case1.adopter.GetPhoneNumber()
				+",'"+case1.adopter.GetAddress()+"','"+case1.adopter.GetMail()
				+"');";
		InsertCommand(query5);

	
				SendEmail mail=new SendEmail("tomerca94@gmail.com", "SOS - Adoptions's Details", 
						"Hey "+case1.adopter.GetName()+",\n\n"+
				 		"we thank you deeply for choosing to adopt a new member of your family - "+case1.animal.getName()+":\n"+
						"please review the following details about "+case1.animal.getName()+
						"\nAdopcion case: "+case1.getID()+
						"\nAdopcion Date: "+DateByCase(case1)+
						"\nAnimal Id: "+case1.animal.getId()+
				 		"\nName: "+case1.animal.getName()+
						"\nGender: "+case1.animal.getGender()+
						"\nAge: "+case1.animal.getAge()+
						"\nHisun:"+case1.animal.getHisun()+
				 		"\n\nPlease do not hesitate to contact us if you require any further information about the adoption .\n" + 
				 		"we are reachable by email animal_adoption@gmail.com , or by phone number 08-8487778 .\n"+
				 		"\nwishing you best luck on your new jurney !");					
 		} 




	



public static ResultSet SelectCommand(String query)
{
	db_connection  con=null;
	  try {
    		 con=db_connection.getInstance();
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
	//Statement st=null;
    ResultSet rs=null;
        	      
    try {
        
        st = con.getConnection().createStatement();
        rs = st.executeQuery(query);

    }   catch (Exception e)
    {
    	
    }
    return rs;
}

public static void UpdateDB(String query)
{
	  try {
			 db_connection conn=db_connection.getInstance();
			 PreparedStatement ps=conn.getConnection().prepareStatement(query);
			 ps.executeUpdate();	
	  }
	  catch (Exception e)
	    {
	    	
	    }

}
public static void UpdateDB(String query,String path)
{
	File pic=new File(path);
	FileInputStream pis=null;
	try {
		pis = new FileInputStream(pic);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		//e1.printStackTrace();
	}
	  try {
			 db_connection conn=db_connection.getInstance();
			 PreparedStatement pst=conn.getConnection().prepareStatement(query);
			 pst.setBlob(1, pis);
			 pst.executeUpdate();	
	  }
	  catch (Exception e)
	    {
	    	
	    }

}

public static void InsertCommand(String query)
{
	db_connection  con=null;
	  try {
    		 con=db_connection.getInstance();
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
    

        try {
			pst = con.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

  
    
}
public static void InsertCommand(String query,FileInputStream pic)
{
	db_connection  con=null;
	  try {
    		 con=db_connection.getInstance();

    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {

        pst = con.getConnection().prepareStatement(query);
        

	 	pst.setBlob(1, pic);
		pst.executeUpdate();
   		        


    }   catch (Exception e)
    {
    }
}

public void closeConnection()
{
	  try {
    		 db_connection.getInstance().closeConnection();
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

}



public String GetmaxDogAge() 
{
	String result="";
	   String query="";
       	try {
  		 query="select Name, Age from sos.animals where Age=(Select max(Age) as max from sos.animals where Type='DOG' and status=1);";
        	ResultSet rs=SelectCommand(query);
         	while(rs.next())
	         	{
         		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
         		if(result.equals("null  Age: 0") ||result.equals("") )	
	        		result="none";
	         		}catch(Exception e1)
         	
 	     		{
 	     			System.err.println(e1);
 	     		}	

	return result;
}



public String GetminDogAge() {
	String result="";
	   String query="";
    	try {
		 query="select Name, Age from sos.animals where Age=(Select min(Age) as max from sos.animals where Type='DOG' and status=1);";
     	ResultSet rs=SelectCommand(query);
      	while(rs.next())
	         	{
      		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
      			if(result.equals("null  Age: 0") ||result.equals("") )	
	        		result="none";
	         		}catch(Exception e1)
      	
	     		{
	     			System.err.println(e1);
	     		}	

	return result;
}



public String GetAvgDogAge() {
	String result="";
	   String query="";
 	try {
 		query="Select AVG(Age) as avg1 from animals where Type='DOG' and status=1;";
  	ResultSet rs=SelectCommand(query);
   	while(rs.next())
	         	{
   		result=" "+rs.getInt("avg1");
	         	}
	        	if(result.equals(" 0"))	
	        		result="none";
	         		}catch(Exception e1)
   	
	     		{
	     			System.err.println(e1);
	     		}	

	return result;

}

public String GetmaxCatAge() 
{
	String result="";
	   String query="";
       	try {
  		 query="select Name, Age from sos.animals where Age=(Select max(Age) as max from sos.animals where Type='CAT' and status=1);";
        	ResultSet rs=SelectCommand(query);
         	while(rs.next())
	         	{
         		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
         		if(result.equals("null  Age: 0") ||result.equals("") )	
	        		result="none";
	         		}catch(Exception e1)
         	
 	     		{
 	     			System.err.println(e1);
 	     		}	

	return result;
}



public String GetminCatAge() {
	String result="";
	   String query="";
    	try {
		 query="select Name, Age from sos.animals where Age=(Select min(Age) as max from sos.animals where Type='CAT' and status=1);";
     	ResultSet rs=SelectCommand(query);
      	while(rs.next())
	         	{
      		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
	        	if(result.equals("null  Age: 0") ||result.equals("") )	
	        		result="none";
	         		}catch(Exception e1)
      	
	     		{
	     			System.err.println(e1);
	     		}	

	return result;
}



public String GetAvgCatAge() {
	String result="";
	   String query="";
 	try {
 		query="Select AVG(Age) as avg1 from animals where Type='CAT' and status=1;";
  	ResultSet rs=SelectCommand(query);
   	while(rs.next())
	         	{
   		result=" "+rs.getInt("avg1");
	         	}
	        	if(result.equals(" 0"))	
	        		result="none";
	         		}catch(Exception e1)
   	
	     		{
	     			System.err.println(e1);
	     		}	

	return result;

}



public String GetMaleDogs() {
	String result="";
	   String query="";
	try {
   		query="Select count(*) as count from animals where Type='DOG' and Gender='Male' and status=1;";
         	ResultSet rs4=SelectCommand(query);
         	while(rs4.next())
         	{
         		result=" "+rs4.getInt("count");
         	}
         		}catch(Exception e1)
	     		{
	     			System.err.println(e1);
	     		}	
	return result;

}



public String GetFemaleDogs() {
	String result="";
	   String query="";
	try {
		query="Select count(*) as count from animals where Type='DOG' and Gender='Female' and status=1;";
      	ResultSet rs4=SelectCommand(query);
      	while(rs4.next())
      	{
      		result=" "+rs4.getInt("count");
      	}
      		}catch(Exception e1)
	     		{
	     			System.err.println(e1);
	     		}	
	return result;

}



public String GetMaleCats() {
		String result="";
	   String query="";
	try {
		query="Select count(*) as count from animals where Type='CAT' and Gender='Male' and status=1;";
   	ResultSet rs4=SelectCommand(query);
   	while(rs4.next())
   	{
   		result=" "+rs4.getInt("count");
   	}
   		}catch(Exception e1)
	     		{
	     			System.err.println(e1);
	     		}	
	
	return result;
}



public String GetFemaleCats() {
	String result="";
	   String query="";
	try {
		query="Select count(*) as count from animals where Type='CAT' and Gender='Female' and status=1;";
	ResultSet rs4=SelectCommand(query);
	while(rs4.next())
	{
		result=" "+rs4.getInt("count");
	}
		}catch(Exception e1)
	     		{
	     			System.err.println(e1);
	     		}	
	return result;
}



public String GetOldestDog() {
	String result="";
	   String query="";
	try {
	    		query="Select Name from animals where Type='DOG' and status=1 order by Date DESC limit 1;";
	         	ResultSet rs12=SelectCommand(query);
	         	while(rs12.next())
	         	{
	         	result=" "+rs12.getString("Name");
	         	}
	         	

	     	
	         		}catch(Exception e1)
	     		{
	     			System.err.println(e1);
	     		}
	return result;

}



public String GetOldestCat() {
	String result="";
	   String query="";
	try {
	    		query="Select Name from animals where Type='CAT'and status=1 order by Date DESC limit 1;";
	         	ResultSet rs12=SelectCommand(query);
	         	while(rs12.next())
	         	{
	         	result=" "+rs12.getString("Name");
	         	}
	         	

	     	
	         		}catch(Exception e1)
	     		{

	         			System.err.println(e1);
	     		}
	return result;
}



public String GetOldestDogDate() {
	String result="";
	   String query="";
	try {
	    		query="Select Date from animals where Type='DOG' and status=1 order by Date DESC limit 1;";
	         	ResultSet rs12=SelectCommand(query);
	         	while(rs12.next())
	         	{
	         	result=" "+rs12.getString("Date");
	         	}
	         	

	     	
	         		}catch(Exception e1)
	     		{
	     			System.err.println(e1);
	     		}
	return result;
}



public String GetOldestCatDate() {
	String result="";
	   String query="";
	try {
	    		query="Select Date from animals where Type='CAT' and status=1 order by Date DESC limit 1;";
	         	ResultSet rs12=SelectCommand(query);
	         	while(rs12.next())
	         	{
	         	result=" "+rs12.getString("Date");
	         	}
	         	

	     	
	         		}catch(Exception e1)
	     		{
	     			System.err.println(e1);
	     		}
	return result;
}


public Boolean login(login login1) {
	Boolean flag=false;
	  ResultSet rs;
      String query;
      
      
      if (login1.getUser().equals("") || login1.getPass().equals("") || login1.getUser().equals(" ") || login1.getPass().equals("" )) 
		{
    	  login1.setMsg("user or password must not be null");
    	  	
    	 
		}
      
      else
      {
    	  try {
              
              query="SELECT * FROM users where Name ='"+login1.getUser()+"' and pass='"+login1.getPass()+"';";
        		rs=SelectCommand(query);
        		
        		if(rs.next())
        		{

      	    	  login1.setMsg("login successfull");
      			flag=true;
        		}
        		else 
        		{
        	    	  login1.setMsg("bad credentials");

        		}
        		
        			
        			/* else
            	  {
            		  	        
          	  try {
          		  
        		query="SELECT premmission FROM users where username ='"+login1.getUser()+"' and premmission='Admin User';";
        		flag=true;

                 if (rs.next()) // if there is no result
                 {   	      
               	  //panel.setVisible(true); 
          	  }
                 
                
          	  }catch (SQLException ex)
          	  {

      	      }
            	  }*/

          } catch (SQLException ex) {
          }
      }
		 JOptionPane.showMessageDialog(null, login1.getMsg(), "Details", JOptionPane.PLAIN_MESSAGE);
      return flag;
}

public ArrayList<Trainer> getTrainers() {
ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    
    ResultSet rs;
    String query;
    Trainer trainer;
    
    try {
        
  
        
		 query = "SELECT * FROM proffesional_services where Job='Trainer' order by Job,Experience DESC";

		 //else  query = "SELECT * FROM proffesional_services";

		 
  		 rs = SelectCommand(query);
  		 
        
        while(rs.next()){
   		trainer=new Trainer(
   				rs.getInt("ID"),rs.getString("Name"), 
   				rs.getString("Gender"), rs.getInt("Age"),
   				rs.getString("Speciality"),rs.getInt("Experience"),
   				rs.getInt("Phone"),rs.getString("Address"));
           

   		trainers.add(trainer);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

    return trainers;

	
}

public void WaiterToDB(PotentialAdopter someone) {
	


		String query="Insert into waiting_list "
				+ "(ID,Name,phone,Mail,AnimalType,AnimalGender,Ages) "
				+ "values("+someone.GetId()+",'"+someone.GetName()
				+"',"+someone.getPhone()+","+ "'"+someone.getMail()
				+"','"+someone.getAnimal_type()+"','"+someone.getAnimal_Gender()+"','"+someone.getAges()+"');"; 

		InsertCommand(query);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow.closeWindow();
					MainWindow window =new MainWindow(MainWindow.user);
					MainWindow.frame.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});



}



public static void NotifyWatingListContact(Animal animal) {

     String ages="";
  if(animal.getAge()<=3) 
      ages="0-3"; 
  if(animal.getAge()<=4 && animal.getAge()>=7) 
      ages="4-7"; 
  if(animal.getAge()<=8 && animal.getAge()>=11) 
      ages="8-11";
  if(animal.getAge()>=12) 
      ages="up to 12";
	
	String query1 ="SELECT Name,Mail FROM waiting_list WHERE AnimalType='"+animal.getType()+"' and AnimalGender='"+animal.getGender()+"' and Ages='"+ages+"';";
	 //JOptionPane.showMessageDialog(null, query1, "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
	ResultSet rs=SelectCommand(query1);
	try {
		while(rs.next())
		{
			SendEmail mail=new SendEmail(rs.getString("Mail"), "SOS - Match Found",
					"Hey "+rs.getString("Name")+"\n"+"We found a match between you and "+animal.getName()+".\n"
					+"call our SOS center with the follow animal id - "+animal.getId()+".\n"
					+"we are reachable by email animal_adoption@gmail.com , or by phone number 08-8487778 .\n\n"+
			"SOS Center.\n"); 
			 //JOptionPane.showMessageDialog(null, rs.getString("Mail"), "מילוי שדות", JOptionPane.PLAIN_MESSAGE);


		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}




}

public Volunteer checkPermession(String username) {
	ResultSet rs;
    String query;
    
		Volunteer vol=new Volunteer(0, "", "", 0, "","");

  	  try {
            
            query="SELECT * FROM users where Name ='"+username+"';";
      		rs=SelectCommand(query);
      		
      		if(rs.next())
      		{
      			 vol=new Volunteer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Gender"),rs.getInt("Age"), rs.getString("pass"),rs.getString("premission"));
    	    	  
      		}
      		
      		
      		
        } catch (SQLException ex) {
        }
    
    return vol;	
}

public void userToDB(Volunteer vol) {

	
    String query="insert into sos.users (ID,Name,Gender,Age,pass,premission) values("
	     		+ ""+vol.GetId()+",'"+vol.GetName()+"','"
	     		+vol.GetGender()+"',"
	     		+ vol.GetAge()+",'"+vol.getPassword()+"','"+vol.getPermmission()
   		 +"');";

   	    		InsertCommand(query);
  	
}
public void userToDB(Manager man) {

	

	try {
		String query1="SELECT * FROM sos.users where id="+man.GetId()+";"; // This query is for check animal count for next id

		ResultSet rs=SelectCommand(query1);
		if(rs.next())
   	{
			 JOptionPane.showMessageDialog(null, "id is already exist", "Details", JOptionPane.PLAIN_MESSAGE);

   	}
		else
		{

		    String query="insert into sos.users (ID,Name,Gender,Age,pass,premission) values("
			     		+ ""+man.GetId()+",'"+man.GetName()+"','"
			     		+man.GetGender()+"',"
			     		+ man.GetAge()+",'"+man.getPassword()+"','"+man.getPermmission()
		   		 +"');";

		   	    		InsertCommand(query);
		}
	     			
		}catch(Exception e1)
		{
			System.err.println(e1);
		}
	
	
	
  	
}

public ArrayList<Manager> getManagers() {
ArrayList<Manager> managers = new ArrayList<Manager>();
    
    ResultSet rs;
    String query;
    Manager manager;
    
    try {
        
  
        
		 query = "SELECT * FROM users where premission='Admin'";

		 //else  query = "SELECT * FROM proffesional_services";

		 
  		 rs = SelectCommand(query);
  		 
        
        while(rs.next()){
        	manager=new Manager(
   				rs.getInt("ID"),rs.getString("Name"), 
   				rs.getString("Gender"), rs.getInt("Age"),
   				rs.getString("pass"),rs.getString("premission"));
           

   		managers.add(manager);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

    return managers;

	
}
public ArrayList<Volunteer> getVolunteers() {
ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
    
    ResultSet rs;
    String query;
    Volunteer volunteer;
    
    try {
        
  
        
		 query = "SELECT * FROM users where premission!='Admin'";
  		 rs = SelectCommand(query);
        
        while(rs.next()){
        	volunteer=new Volunteer(
   				rs.getInt("ID"),rs.getString("Name"), 
   				rs.getString("Gender"), rs.getInt("Age"),
   				rs.getString("pass"),rs.getString("premission"));
           

        	volunteers.add(volunteer);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

    return volunteers;

	
}

public void userUpdateInDB(Volunteer volanteer) {

		
		String query="";
	try {

			 query ="UPDATE sos.users SET ID="+volanteer.GetId()+", Name ='"+volanteer.GetName()+
					 "',Gender ='"+volanteer.GetGender()+"',Age ="+ volanteer.GetAge()+
					 ",pass ='"+ volanteer.getPassword()+"',premission='"+volanteer.getPermmission()+"' WHERE id="+volanteer.GetId()+";";
			UpdateDB(query);

			 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
		 	
	}
	catch(Exception e1)
	{
		System.err.println(query);

	} 
	}
	
public void userUpdateInDB(Manager manager) {

	
	String query="";
try {

		 query ="UPDATE sos.users SET ID="+manager.GetId()+", Name ='"+manager.GetName()+
				 "',Gender ='"+manager.GetGender()+"',Age ="+ manager.GetAge()+
				 ",pass ='"+ manager.getPassword()+"',premission='"+manager.getPermmission()+"' WHERE id="+manager.GetId()+";";
		UpdateDB(query);
		 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
	 	
}
catch(Exception e1)
{
	System.err.println(query);

} 
}

public void userDeleteFromDB(Volunteer volanteer) {
	

	String query="";
try {

		 query ="DELETE FROM sos.users WHERE id="+volanteer.GetId()+";";
		UpdateDB(query);
		 JOptionPane.showMessageDialog(null, "Deletion in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
	 	
}
catch(Exception e1)
{
	System.err.println(query);

} 
	
}

public void userDeleteFromDB(Manager manager) {
	

	String query="";
try {

		 query ="DELETE FROM sos.users WHERE id="+manager.GetId()+";";
		UpdateDB(query);
		 JOptionPane.showMessageDialog(null, "Deletion in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
	 	
}
catch(Exception e1)
{
	System.err.println(query);

} 
	
}

public ArrayList<PotentialAdopter> getWaiting_People() {
ArrayList<PotentialAdopter> waiting_People = new ArrayList<PotentialAdopter>();
    
    ResultSet rs;
    String query;
    PotentialAdopter waiter;
    
    try {
        
  
        
		 query = "SELECT * FROM waiting_list ";
  		 rs = SelectCommand(query);
        
        while(rs.next()){
        	waiter=new PotentialAdopter(
   				rs.getInt("ID"),rs.getString("Name"), 
   				rs.getInt("Phone"), rs.getString("Mail"),
   				rs.getString("AnimalType"),rs.getString("AnimalGender"),rs.getString("Ages"));


        	waiting_People.add(waiter);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

    return waiting_People;

	
}

public void DeleteWaitingList(int id) {

	String query="";
try {

		 query ="DELETE FROM waiting_list WHERE id="+id+";";
		UpdateDB(query);
		 JOptionPane.showMessageDialog(null, "Deletion in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
	 	
}
catch(Exception e1)
{
	System.err.println(query);

} 
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			MainWindow.closeWindow();
			MainWindow window =new MainWindow(MainWindow.user);
			MainWindow.frame.setVisible(true);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});
		
}

public void DeleteProffFromDB(Vet vet) {
	String query ="Delete from proffesional_services WHERE ID="+vet.GetId()+";";
	InsertCommand(query);
 JOptionPane.showMessageDialog(null, "Delete Action in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			MainWindow.closeWindow();
			MainWindow window =new MainWindow(MainWindow.user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
});	
}
public void DeleteProffFromDB(Trainer trainer) {
	String query ="Delete from proffesional_services WHERE ID="+trainer.GetId()+";";
	InsertCommand(query);
 JOptionPane.showMessageDialog(null, "Delete Action in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			MainWindow.closeWindow();
			MainWindow window =new MainWindow(MainWindow.user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
});	
}

public void ProffToDB(Trainer trainer) {
	
	String query="Insert into proffesional_services (ID,Name,Job,Speciality,Experience,Gender,Age,Phone,Address) values ("
			+trainer.GetId()+",'"+trainer.GetName()+"','Trainer','"+trainer.GetSpecialty()+"',"+trainer.GetExperience()+",'"
					+trainer.GetGender()+"',"+trainer.GetAge()+","+trainer.GetPhoneNumber()+",'"+trainer.GetAddress()+"');";
		InsertCommand(query);
		
		 JOptionPane.showMessageDialog(null, "Insert Action in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow.closeWindow();
					MainWindow window =new MainWindow(MainWindow.user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});	
}


public void ProffToDB(Vet vet) {
	
	String query="Insert into proffesional_services (ID,Name,Job,Speciality,Experience,Gender,Age,Phone,Address) values ("
			+vet.GetId()+",'"+vet.GetName()+"','Vet','"+vet.GetSpecialty()+"',"+vet.GetExperience()+",'"
					+vet.GetGender()+"',"+vet.GetAge()+","+vet.getPhone()+",'"+vet.getAddress()+"');";
		InsertCommand(query);
		
		 JOptionPane.showMessageDialog(null, "Insert Action in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow.closeWindow();
					MainWindow window =new MainWindow(MainWindow.user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});	
}

public void UpdateProffInDB(Trainer trainer) {

		String query ="UPDATE proffesional_services SET"
	 		+ " id="+trainer.GetId()+
			 ",Name= '"+ trainer.GetName()+
			 "', Job ='Trainer"+
			 "',Speciality ='"+trainer.GetSpecialty()+
			 "',Experience ="+trainer.GetExperience()+
			 ",Gender ='"+trainer.GetGender()+
			 "',Age ="+trainer.GetAge()+
			 ",Address ='"+trainer.GetAddress()+
			 "',Phone ="+trainer.GetPhoneNumber()+
			" WHERE id='"+trainer.GetId()+"';";
	UpdateDB(query);
	 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			MainWindow.closeWindow();
			MainWindow window =new MainWindow(MainWindow.user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
});	
}

public void UpdateProffInDB(Vet vet) {

		String query ="UPDATE proffesional_services SET"
	 		+ " id="+vet.GetId()+
			 ",Name= '"+ vet.GetName()+
			 "', Job ='Vet"+
			 "',Speciality ='"+vet.GetSpecialty()+
			 "',Experience ="+vet.GetExperience()+
			 ",Gender ='"+vet.GetGender()+
			 "',Age ="+vet.GetAge()+
			 ",Address ='"+vet.getAddress()+
			 "',Phone ="+vet.getPhone()+
			" WHERE id='"+vet.GetId()+"';";
	UpdateDB(query);
	 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			MainWindow.closeWindow();
			MainWindow window =new MainWindow(MainWindow.user);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
});	
}



}
	














