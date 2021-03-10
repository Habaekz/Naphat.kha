public class Repository{
  private String name;
  private int type;   // 0: public, 1: private

  public Repository(String aName, int aType){
    name = aName;
    type = aType;
  }

  /*
   * Return the name of this repository
   */
  public String getName(){
    return this.name;
  }

  /*
   * Return the type of this repository
   */
  public int getType(){
    return this.type;
  }

  /* 
   * Check whether the given repository is equal to this repository or not.
   * Two repositories will be equal if their names are the same and their type are the same as well.
   */
  public boolean isEqual(Repository repo){
    return (this.name.equals(repo.getName()) && this.type == repo.getType());  
  }

  /*
   * Return true if this repository has a private type (type value is equal to 1). Otherwise, return false
   */
  public boolean isPrivate(){
    return this.type == 1;
  }

  /*
   * Return a string with repository's name and type.
   * There are two types PRIVATE or PUBLIC.
   * If type == 1 is true, the string will contain the keyword "PRIVATE" e.g., Name: repo_name1 (PRIVATE)
   * Otherwise, the string will contain the keyword "PUBLIC".
   * e.g., Name: repo_name2 (PUBLIC)
   */
  public String toString(){
    return "Name: " + this.name + " (" + ( this.type == 1? "PRIVATE" : "PUBLIC") + ")";

  }
}