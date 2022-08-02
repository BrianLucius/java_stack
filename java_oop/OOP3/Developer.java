import java.util.ArrayList;

public class Developer {
    // 1. Attributes (what it has) all private/protected
    private String name;
    public ArrayList<String> languages;
    public ArrayList<Project> projects = new ArrayList<Project>();
    private int salary;
    private double hoursOfSleep;
    private static int devCount;
    private static int totalIncome;
    private static int totalProjects;

    // 2. Methods (what it does)
    public void displayStatus() {
        System.out.println("Name: "+this.name);
        System.out.println("Salary: "+this.salary);
        System.out.println("Sleep: "+this.hoursOfSleep);
        System.out.println("Languages: "+this.languages);
        System.out.println("Projects: ");
        for(Project project: this.projects){
            project.displayInfo();
            totalProjects++;
        }
    } 

    public void addProject(Project proj){
        this.projects.add(proj);
    }

    // constructor
    public Developer() {
        this.name = "Anonymous Developer";
        this.languages = new ArrayList<String>();
        this.projects = new ArrayList<Project>();
        this.salary = 90000;
        this.hoursOfSleep = 4;
        devCount++;
        totalIncome += this.salary;
    }

    public Developer(String name, int salary, double hoursOfSleep){
        this.name = name;
        this.languages = new ArrayList<String>();
        this.projects = new ArrayList<Project>();
        this.salary = salary;
        this.hoursOfSleep = hoursOfSleep;
        devCount++;
        totalIncome += this.salary;
    }

    // Add getters and setters for private attributes
    // getters: name convention: get+var in camel case
    public String getName(){
        return this.name;
    }
    public int getSalary(){
        return this.salary;
    }
    public double getHoursOfSleep(){
        return this.hoursOfSleep;
    }

    // setter, does not return a value
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setHoursOfSleep(double hours ) {
        this.hoursOfSleep = hours;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setProjects(ArrayList<Project> project){
        this.projects = project;
    }

    public void addLanguage(String language){
        this.languages.add(language);
    }

    public static int getDevCount(){
        return devCount;
    }

    public static int getTotalSalary(){
        return totalIncome;
    }

    public static int getTotalProjects(){
        return totalProjects;
    }

}