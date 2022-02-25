public class Project {
    String name = "";
    int no_of_days = -1;
    int score = -1;
    int best_before = -1;
    int no_of_roles = -1;
    Role roles[];
    public void setRoles(){
        roles = new Role[no_of_roles];
    }
}
