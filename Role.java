public class Role {
    String skill;
    String name;
    int level;
    public void setSkill(String skill){
        this.skill = skill;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public String getSkill(){
        return skill;
    }
    public int getLevel(String skill){
        if(this.skill == skill){
            return level;
        }
        return -1;
    }
}
