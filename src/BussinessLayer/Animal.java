package BussinessLayer;


public interface Animal {
	public static final String dog="DOG";
	public static final String Cat="CAT";
	public String getType();
	public String getGender();
	public  int getAge();
	public  int getHisun();
	public int getId();
	public void setId(int id);
	public String getName();
	public Boolean getStatus();
	public void setStatus(Boolean status);
	
}

