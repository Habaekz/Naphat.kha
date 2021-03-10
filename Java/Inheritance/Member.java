import java.util.ArrayList;

public class Member {

	ArrayList<Repository> repoList = new ArrayList<Repository>();
	ArrayList<Repository> repoList1 = new ArrayList<Repository>(repoList);
	String str1;
	String str2;
	public Member(String email, String password) {
		// TODO Auto-generated constructor stub
		str1 = email;
		str2 = password;
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
	
	public boolean removeRepository(Repository repo) {
		// TODO Auto-generated method stub
		for(int i=0 ; i<repoList.size() ; i++)
		{
			if(repo.getType() == 1 && repoList.get(i)==repo)
			{
				System.out.println(repo.toString()+" is successfully removed.");
				repoList.remove(i);
			}
		}
		return true;
	}
	
	public void printMemberInfo() {
		// TODO Auto-generated method stub
		System.out.println("Email: "+str1+" (pwd: "+str2+")");
		System.out.println("List of repositories");
		for(int i=0 ; i<repoList.size() ; i++)
		{
			System.out.println(repoList.get(i));
		}
	}

	

	

}
