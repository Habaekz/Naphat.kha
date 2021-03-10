import java.util.ArrayList;

public class FreeMember {

	ArrayList<Repository> repoList = new ArrayList<Repository>();
	String str1;
	String str2;
	int FREE_PRIVATE_REPOS=10;
	int fee=10;
	public FreeMember(String email, String password) {
		// TODO Auto-generated constructor stub
		str1 = email;
		str2 = password;
	}

	public boolean addRepository(Repository repo) {
		// TODO Auto-generated method stub
			if(fee==0)
				{
				FREE_PRIVATE_REPOS = 10;
				}
			if(repo.getType() == 1 && FREE_PRIVATE_REPOS<=3)
			{
				System.out.print(repo.toString());
				System.out.println(" cannot be added because the number of private repository is reaching the limit ");
				
				FREE_PRIVATE_REPOS--;
				fee--;
				return false;
			}
			else
			{
				repoList.add(repo);
				FREE_PRIVATE_REPOS--;
				fee--;
				return true;
			}
			
	}

	public void printMemberInfo() {
		// TODO Auto-generated method stub
		System.out.println("---- FREE MEMBER ----");
		System.out.println("Email: "+str1+" (pwd: "+str2+")");
		System.out.println("List of repositories");
		for(int i=0 ; i<repoList.size() ; i++)
		{
			System.out.println(repoList.get(i));
		}
	}

	public boolean removeRepository(Repository repo) {
		// TODO Auto-generated method stub
		for(int i=0 ; i<repoList.size() ; i++)
		{
			if(repoList.get(i)==repo)
			{
				System.out.println(repo.toString()+" is successfully removed.");
				repoList.remove(i);
			}
		}
		return true;
	}
	
	public int getNumPrivateRepo() {
		return FREE_PRIVATE_REPOS;
		
	}

	

}
