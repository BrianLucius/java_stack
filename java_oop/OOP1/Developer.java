import java.util.ArrayList;

public class Developer {
    // 1. Attributes (what it has)
    public String name;
    public ArrayList<String> languages;
    public ArrayList<Project> projects = new ArrayList<Project>();
    public int salary;
    public double hoursOfSleep;

    // 2. Methods (what it does)
    public void displayStatus() {
        System.out.println("Name: "+this.name);
        System.out.println("Salary: "+this.salary);
        System.out.println("Sleep: "+this.hoursOfSleep);
        System.out.println("Languages: "+this.languages);
        System.out.println("Projects: ");
        for(Project project: this.projects){
            project.displayInfo();
        }
    } 

    public void addProject(Project proj){
        this.projects.add(proj);
    }
}