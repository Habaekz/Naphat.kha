public class MemberTester {
  public static void main(String[] args) {
    Repository[] repos = new Repository[10];
    // create 10 repositories
    for(int i = 0; i < repos.length; i++){
      repos[i] = new Repository("lab" + i, i%2);
    }

    FreeMember free = new FreeMember("abc@mu.edu", "1234");
    System.out.println("Task 1: Adding new repositories into free member account");
    for(Repository repo: repos){
      free.addRepository(repo);
    }
    System.out.println("*******************************");
    
    System.out.println("Task 2: Remove/add a repository from free account");
    free.removeRepository(repos[1]);
    free.addRepository(repos[7]);
    System.out.println("*******************************");
    
    System.out.println("Task 3: Display free member information");
    free.printMemberInfo();
    System.out.println("*******************************");
    
    ProMember pro = new ProMember("xyz@mu.edu", "9876", 200);
    System.out.println("Task 4: Add/remove new repositories into pro member account");
    for(Repository repo: repos){
      pro.addRepository(repo);
    }
    pro.removeRepository(repos[2]);
    pro.removeRepository(new Repository("lab10", 1));
    System.out.println("*******************************");
    
    System.out.println("Task 5: Display pro member information");
    pro.printMemberInfo();
    System.out.println("*******************************");
    
    
    System.out.println("Challenge 1: Add/Remove collaborator");
    pro.addColloborator("alan@turing");
    pro.addColloborator("bill@gates");
    pro.addColloborator("steve@jobs");
    pro.addColloborator("mark@zuckerberg");
    pro.removeColloborator("steve@job");
    pro.removeColloborator("steve@jobs");
    System.out.println("*******************************");
    
    System.out.println("Challenge 2: Get monthly bill of pro member account");
    System.out.println("The monthly bill: " + pro.getMonthlyBill());
    System.out.println("*******************************");
    
    System.out.println("Challenge 3: Display pro member info");
    pro.printMemberInfo();
    System.out.println("*******************************");
    
  }
}