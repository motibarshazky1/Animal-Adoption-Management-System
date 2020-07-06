package logicalLayers;


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
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
import userInterface.Work;


public class serverTunnel
{
	private static Statement st;
	private static PreparedStatement pst;

public serverTunnel() {
}



public static void AnimalToDB(Animal animal,String path)  // Input - Animal -> Output Animal Details in DB. $$
{

	
		try {
			
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
	
		
		try {
			String query1="SELECT count(*) as id FROM sos.available_animal;"; // This query is for check animal count for next id
			serverTunnel tunnel1=new serverTunnel();

			ResultSet rs=tunnel1.SelectCommand(query1);
			while(rs.next())
       	{
			int next_id=rs.getInt("id")+1;
       	   animal.setId(next_id);
       	}
		     			
   		}catch(Exception e1)
   		{
   			System.err.println(e1);
   		}

			String query="Insert into available_animal "
					+ "(ID,Date,Name,Type,Gender,Age,Hisun,Picture) "
					+ "values("+animal.getId()+",now(),'"+animal.getName()
					+"','"+animal.getType()+"',"+ "'"+animal.getGender()
					+"',"+animal.getAge()+","+animal.getHisun()+",?);"; 
			//serverTunnel tunnel=new serverTunnel();

			InsertCommand(query,fis);
       		 	fis.close();
	
	
	
}
		 catch(Exception e1)
 		{
 			System.err.println(e1);
 		}

}


public static void UpdateAnimalInDB(Animal newAnimal,FileInputStream fis)  // Input - ID + Animal -> Output Update Animal Details in DB.

{

	String query;
try {

		 //serverTunnel tunnel= new serverTunnel();	          	     		 
	 if(fis==null)
	 {
		 query ="UPDATE available_animal SET ID="+newAnimal.getId()+", Name ='"+newAnimal.getName()+"', Type ='"+newAnimal.getType()+"',Gender ='"+newAnimal.getGender()+"',Age ="+ newAnimal.getAge()+",Hisun ="+ newAnimal.getHisun()+" WHERE id="+newAnimal.getId()+";";
		 UpdateDB(query);
	 }
	 else
	 {
		 query ="UPDATE available_animal SET ID="+newAnimal.getId()+", Name ='"+newAnimal.getName()+"', Type ='"+newAnimal.getType()+"',Gender ='"+newAnimal.getGender()+"',Age ="+ newAnimal.getAge()+",Hisun ="+ newAnimal.getHisun()+",Picture=? WHERE id="+newAnimal.getId()+";";
		 UpdateDB(query,fis); 
	 }
		 
		 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
	 	
}
catch(Exception e1)
{
	System.err.println(e1);

} 
}



public static ImageIcon AnimalInTable(Animal animal,FileInputStream fis,int height,int width)  // 

{
	ImageIcon newImage=null;
	 try {
   	   		
				serverTunnel tunnel= new serverTunnel();
				String query1 ="SELECT Picture FROM available_animal WHERE id="+animal.getId()+";";
	     		 ResultSet rs = tunnel.SelectCommand(query1);
	     		 
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


public static  ArrayList<Animal> getAnimals()
{
ArrayList<Animal> animals = new ArrayList<Animal>();
    
    ResultSet rs;
    String query;
    Animal u;
    
    try {
        
        
        	serverTunnel tunnel= new serverTunnel();
  		 query = "SELECT * FROM available_animal";
  		 rs = tunnel.SelectCommand(query);
  		 
        
        while(rs.next()){
      	  AnimalFactory animalFctory = new AnimalFactory();
   		
            u =  animalFctory.createAnimal(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("Type"),
                    rs.getString("Gender"),
                    rs.getInt("Age"),
                    rs.getInt("Hisun")

   	    		
            );

            animals.add(u);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
    return animals;

}


public static ArrayList<String> getAdoptions(){
    
    ArrayList<String> adoptions = new ArrayList<String>();
    ResultSet rs;
    String query;
  
    String case2;
    
    try {
        
        	serverTunnel tunnel= new serverTunnel();
  		 query = "SELECT * FROM adoption_history";
  		 rs = tunnel.SelectCommand(query);
        
        while(rs.next()){
      	  
      	  case2=""+rs.getInt("Adoption_ID")+","+
      			  rs.getString("Date")+","+
      			  rs.getString("Animal_Name")+","+
      			  rs.getInt("Animal_ID")+","+
      			  rs.getInt("Adopter_ID")+","+
      			  rs.getString("Adopter_Name")+"";
   
            adoptions.add(case2);
        }
         
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

    return adoptions;
}


public static void case_Insertion(int id, Animal animal,Adopter adopter) // this function get Animal, Adopter, create case object and insert it to DB.
{
	 
	 String query="Insert into adopters (ID,Name,Gender,Age,Occupation,Phone,Address) values ("+
				adopter.GetId()+",'"+adopter.GetName()+"','"+adopter.GetGender()+"',"+adopter.GetAge()+
				",'"+adopter.GetOccupation()+"',"+adopter.GetPhoneNumber()+",'"+adopter.GetAdress()+"');";
				try {
						InsertCommand(query);
				}catch(Exception e1)
		 		{
		 			System.err.println(e1);

		 		} 
	 
	 
	 try {
			String query1="SELECT count(*) as id FROM sos.adoption_history;"; // This query is for check animal count for next id
			serverTunnel tunnel1=new serverTunnel();

			ResultSet rs=tunnel1.SelectCommand(query1);
			while(rs.next())
      	{
				id=rs.getInt("id");
      	}
		     			
  		}catch(Exception e1)
  		{
  			System.err.println(e1);
  		}
		Adoption case1= new Adoption(++id, animal, adopter);
		String query2="Insert into adoption_history (Date,Animal_Name,Animal_ID,Adopter_ID,Adopter_name) values (now(),'"+
		case1.animal.getName()+"',"+case1.animal.getId()+","+case1.adopter.GetId()+",'"+case1.adopter.GetAdopterName()+"');";
		try {
				serverTunnel tunnel= new serverTunnel();
				tunnel.InsertCommand(query2);
		}catch(Exception e1)
 		{
 			System.err.println(e1);

 		} 
		SendEmail aaa=new SendEmail("tomerca94@gmail.com", "SOS - Adoptions's Details", "Hey "+case1.adopter.GetAdopterName()+",\n"+
 		"Thank you for adoption "+case1.animal.getName()+"\n\nInforamation:\n"+
		"SOS Id: \n"+
 		"Name: \n"+
		"Gender: \n"+
		"Age: \n"+
		"Hisun:"+
 		"\n\nDont hesitate to contact us \n\n0508274254 \nSOS Center\n\n"+
		"\"Stop telling me that he's \"just a dog.\" My dog has more character, compassion,loyalty, and honesty than most people I know. He's family.\"");

		
	
}


	



public ResultSet SelectCommand(String query)
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
public static void UpdateDB(String query,FileInputStream pic)
{
	  try {
			 db_connection conn=db_connection.getInstance();
			 PreparedStatement pst=conn.getConnection().prepareStatement(query);
			 pst.setBlob(1, pic);
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

        st = con.getConnection().createStatement();

        st.executeUpdate(query);
        

    }   catch (Exception e)
    {
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
  		 query="select Name, Age from sos.available_animal where Age=(Select max(Age) as max from sos.available_animal where Type='DOG');";
        	ResultSet rs=SelectCommand(query);
         	while(rs.next())
	         	{
         		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
	        	if(result.equals("null  Age: 0"))	
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
		 query="select Name, Age from sos.available_animal where Age=(Select min(Age) as max from sos.available_animal where Type='DOG');";
     	ResultSet rs=SelectCommand(query);
      	while(rs.next())
	         	{
      		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
	        	if(result.equals("null  Age: 0"))	
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
 		query="Select AVG(Age) as avg1 from available_animal where Type='DOG';";
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
  		 query="select Name, Age from sos.available_animal where Age=(Select max(Age) as max from sos.available_animal where Type='CAT');";
        	ResultSet rs=SelectCommand(query);
         	while(rs.next())
	         	{
         		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
	        	if(result.equals("null  Age: 0"))	
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
		 query="select Name, Age from sos.available_animal where Age=(Select min(Age) as max from sos.available_animal where Type='CAT');";
     	ResultSet rs=SelectCommand(query);
      	while(rs.next())
	         	{
      		result=rs.getString("Name")+"  Age: "+rs.getInt("Age");
	         	}
	        	if(result.equals("null  Age: 0"))	
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
 		query="Select AVG(Age) as avg1 from available_animal where Type='CAT';";
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
   		query="Select count(*) as count from available_animal where Type='DOG' and Gender='Male';";
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
		query="Select count(*) as count from available_animal where Type='DOG' and Gender='Female';";
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
		query="Select count(*) as count from available_animal where Type='CAT' and Gender='Male';";
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
		query="Select count(*) as count from available_animal where Type='CAT' and Gender='Female';";
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
	    		query="Select Name from available_animal where Type='DOG' order by Date DESC limit 1;";
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
	    		query="Select Name from available_animal where Type='CAT' order by Date DESC limit 1;";
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
	    		query="Select Date from available_animal where Type='DOG' order by Date DESC limit 1;";
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
	    		query="Select Date from available_animal where Type='CAT' order by Date DESC limit 1;";
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

      try {
          
          query="SELECT * FROM users where username ='"+login1.getUser()+"' and pass='"+login1.getPass()+"';";
    		rs=SelectCommand(query);
    		
    		if(rs.next())
          	  throw new IllegalArgumentException("login details - error");
    		else
    			if (!rs.getString("username").equals("") && !rs.getString("username").equals("")) // if there is no result
    				throw new IllegalArgumentException("user or password must not be null");
          else
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
        	  }

      } catch (SQLException ex) {
      }
      return flag;
}



}






