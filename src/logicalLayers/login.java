package logicalLayers;

public class login {
	private String username;
	private String password;
	
	
	
	public login()
	{
		this.username="";
		this.password="";
	}
	
public login(String username,String password)
{
	this.username=username;
	this.password=password;
}

	
	public String getPass()
	{
		return this.password;
	}
	
	public String getUser() {
		return this.username;

	}

	
	public void setUser(String user)
	{
		this.username=user;

	}
	
	
	public void setPass(String pass)
	{
		this.password=pass;
	}
	
}
