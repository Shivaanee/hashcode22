//import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class contributor{
    public static void main(String []args){
        System.out.println("");
        

        try {
            FileReader reader = new FileReader("a_an_example.in.txt");
            int character;
            character = reader.read(); // 3
            int no_contributors = character - 48;

            character = reader.read(); // whitespace

            character = reader.read(); // 3
            int no_projects = character - 48;

            character = reader.read(); // new line

            LinkedList<Entry> contributors = new LinkedList<Entry>();
            int cnt = no_contributors;
            Project projects[] = new Project[no_projects];

            while ((character = reader.read()) != -1) {
                //System.out.print((char) character);
                String name = "";
                int num = -1;
                while(cnt!=0){
                    Entry e = new Entry();
                    name = "";
                    num = -1;
                    while((char) character!=' '){
                        name = name.concat(Character.toString(((char) character)));
                        character = reader.read();
                    }
                    e.setName(name);
                    character = reader.read();
                    name = "";
                    while((char) character!='\n'){
                        name = name.concat(Character.toString(((char) character)));
                        character = reader.read();
                    }
                    num = Integer.valueOf(name);

                    character = reader.read(); // new line
                    name = "";
                    String level = "";
                    while(num!=0){
                        name = "";
                        while((char) character!=' '){
                            name = name.concat(Character.toString(((char) character)));
                            character = reader.read();
                        }
                        character = reader.read();
                        level = "";
                        while((char) character!='\n'){
                            level = level.concat(Character.toString(((char) character)));
                            character = reader.read();
                        }
                        e.addSkill(name, Integer.valueOf(level));
                        character = reader.read();
                        num--;
                    }
                    contributors.add(e);
                    cnt--;
                }
                cnt = 0;
                //int ptr1 = 0;
                int ptr2 = 0;
                while(cnt<no_projects){
                    projects[cnt] = new Project();
                    name = "";
                    while((char) character!=' '){
                        name = name.concat(Character.toString(((char) character)));
                        character = reader.read();
                    }
                    
                    projects[cnt].name = name;
                    character = reader.read();
                    name = "";
                    while((char) character!=' '){
                        name = name.concat(Character.toString(((char) character)));
                        character = reader.read();
                    }
                    
                    projects[cnt].no_of_days = Integer.valueOf(name);
                    character = reader.read();
                    name = "";
                    while((char) character!=' '){
                        name = name.concat(Character.toString(((char) character)));
                        character = reader.read();
                    }
                    
                    projects[cnt].score = Integer.valueOf(name);
                    character = reader.read();
                    name = "";
                    while((char) character!=' '){
                        name = name.concat(Character.toString(((char) character)));
                        character = reader.read();
                    }
                    
                    projects[cnt].best_before = Integer.valueOf(name);
                    character = reader.read();
                    name = "";
                    while((char) character!='\n'){
                        name = name.concat(Character.toString(((char) character)));
                        character = reader.read();
                    }
                    
                    projects[cnt].no_of_roles = Integer.valueOf(name);
                    projects[cnt].setRoles();
                    character = reader.read();
                    ptr2 = 0;
                    while(ptr2<projects[cnt].no_of_roles){
                        name = "";
                        projects[cnt].roles[ptr2] = new Role();
                        while((char) character!=' '){
                            name = name.concat(Character.toString(((char) character)));
                            character = reader.read();
                        }
                        
                        projects[cnt].roles[ptr2].setSkill(name);
                        character = reader.read();
                        name = "";
                        while((char) character!='\n'){
                            name = name.concat(Character.toString(((char) character)));
                            character = reader.read();
                        }
                        
                        projects[cnt].roles[ptr2].setLevel(Integer.valueOf(name));
                        character = reader.read();
                        ptr2++;
                    }
                    cnt++;
                }
            }

            // int days = 0;
            cnt = 0;
            while(cnt<no_projects){
                for(int i = 0; i<projects[cnt].no_of_roles; i++){
                    ListIterator<Entry> contributor_iterator = contributors.listIterator();
                    while(contributor_iterator.hasNext()){
                        Entry e = contributor_iterator.next();
                        ListIterator<String> skills = e.getSkills(e.getName());
                        while(skills.hasNext()){
                            String skill = skills.next();
                            if((skill == projects[cnt].roles[i].getSkill())){
                                if((e.getSkillLevel(skill)==projects[cnt].roles[i].getLevel(skill)) || (e.getSkillLevel(skill)>projects[cnt].roles[i].getLevel(skill))){
                                    projects[cnt].roles[i].name = e.getName();
                                }
                            }
                        }
                    }
                }
                
                cnt++;
            }
            System.out.println(no_projects);
            for(int i = 0; i<no_projects; i++){
                System.out.println(projects[i].name);
                for(int  j =0; j<projects[i].no_of_roles; j++){
                    System.out.print(projects[i].roles[j].name + " ");
                }
                System.out.println("");
            }


            // TESTING 
            // System.out.println(no_projects + " ");
            // System.out.println("Number of Contributors: " + no_contributors);

            // System.out.println("Contributors: ");
            // ListIterator<Entry> names = contributors.listIterator();
            // while(names.hasNext()){
            //     Entry next= names.next();
            //     System.out.println("Name: " + next.getName());
            //     System.out.println("Skills: ");
            //     ListIterator<String> skills = next.getSkills(next.getName());
            //     while(skills.hasNext()){
            //         String skill = skills.next();
            //         System.out.print(skill + " " + next.getSkillLevel(skill) + ", ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("Projects: ");
            // for(int i = 0; i<no_projects; i++){
            //     System.out.print("No of days: " + projects[i].no_of_days + ",    ");
            //     System.out.print("Score: " + projects[i].score + ",      ");
            //     System.out.print("Best Before: " + projects[i].best_before + ",    ");
            //     System.out.println("No of roles: " + projects[i].no_of_roles + ",    ");
            //     for(int j = 0; j<projects[i].no_of_roles; j++){
            //         System.out.print(projects[i].roles[j].getSkill() + ": " + projects[i].roles[j].getLevel(projects[i].roles[j].getSkill()) + ",    ");
            //     }
            //     System.out.println("");
            //}
            // TESTING END
            
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}