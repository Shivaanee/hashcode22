// import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Entry {
    String name;
    LinkedList<String> skill = new LinkedList<String>();
    LinkedList<Integer> level = new LinkedList<Integer>();
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void addSkill(String skill, int level){
        this.skill.add(skill);
        this.level.add(level);
    }
    public ListIterator<String> getSkills(String name){
        if(this.name==name){
            ListIterator<String> skillsIterator = skill.listIterator();
            return skillsIterator;
        }
        else
        return null;
    }
    public int getSkillLevel(String skill){
        ListIterator<String> skillsIterator = this.skill.listIterator();
        int skillNo = 1;
        String ptr;
        while(skillsIterator.hasNext()){
            ptr = skillsIterator.next();
            if(ptr == skill){
                ListIterator<Integer> levelsIterator = this.level.listIterator();
                int levelOfSkill = -1;
                while(skillNo!=0){
                    levelOfSkill = levelsIterator.next();
                    skillNo--;
                }
                return levelOfSkill;
            }
            skillNo++;
        }
        return -1;
    }
}
