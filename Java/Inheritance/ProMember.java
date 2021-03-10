import java.util.ArrayList;

public class ProMember {

	ArrayList<Repository> repoList = new ArrayList<Repository>();
	ArrayList<String> collaborators = new ArrayList<String>();
	String str1;
	String str2;
	double feee;
	double COLLOABORATOR_FEE = 80.00; 
	public ProMember(String email, String password, double fee) {
		// TODO Auto-generated constructor stub
		str1 = email;
		str2 = password;
		feee = fee;
	}
	
	public boolean addRepository(Repository repo) {
		// TODO Auto-generated method stub
		if(repo != null)
		{
			repoList.add(repo);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void printMemberInfo() {
		// TODO Auto-generated method stub
		System.out.println("---- PRO MEMBER ---- ");
		System.out.println("Member fee: "+feee);
		System.out.println("Email:"+str1+"(pwd: "+str2+")");
		System.out.println("List of repositories");
		for(int i=0 ; i<repoList.size() ; i++)
		{
			System.out.println(repoList.get(i));
		}
		System.out.println("---------------------");
		System.out.println("List of collaborators");
		System.out.println(collaborators);
	}
	
	public boolean removeRepository(Repository repo) {
		// TODO Auto-generated method stub
		for(int i=0 ; i<repoList.size() ; i++)
		{
			if(repoList.get(i)==repo)
			{
				System.out.println(repo.toString()+" is successfully removed.");
			}
		}
		return true;
	}
	
	public double getMonthlyBill()
	{
		return COLLOABORATOR_FEE=(COLLOABORATOR_FEE*collaborators.size())+f;
		
	}
	
	public boolean removeColloborator(String username) {
			if(collaborators.contains(username))
			{
				collaborators.remove(username);
				return true;
			}
			else
			{
				System.out.println(username+" cannot be removed.");
				System.out.println(username+" is removed successfully.");
				return false;
			}
		
		
		
	}
	
	public boolean addColloborator(String username)
	{
		if(username.isEmpty())
		{
			return false;
		}
		else
		{
			collaborators.add(username);
			System.out.println(username+"is added successfully.");
			return true;
		}
		
		
	}

}
