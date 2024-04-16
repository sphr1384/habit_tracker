package UserPackage;

import TaskPackage.Task;
import  UtilityPackage.Utils;

public class User {
    private String username;
    private String password;
    public String first_name;
    public String last_name;
    public String email;
    public int streak;
    public static Task taskArray[] = new Task[20];
    public static int taskArrayCounter;


    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        if(Utils.isPasswordValid(password) == true)
            this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Task getTaskByName(String name){
        for (int i = 0; i < taskArrayCounter; i++){
            if (name == taskArray[i].getName()){
                return taskArray[i];
            }
        }

        System.out.println("thare is no task with this name!");
        return null;
    }

    public String[] geTasksbyColor(String color){
        int count = 0;
        String str[] = new String[20];
        for (int i = 0; i < taskArrayCounter; i++){
            if (color == taskArray[i].color){
                str[count] = taskArray[i].color;
            }
        }
        return str;
    }

    public void setFirstName(String firstName){
        String capitalFormatted = formatName(firstName);
        this.first_name = capitalFormatted + " ";


    }

    public void setLastName(String lastName){
        String capitalFormatted = formatName(lastName);
        this.last_name = capitalFormatted;
    }

    public void setEmail(String email) {
        if (Utils.isValidEmail(email)){
            this.email = email;
        }
        else System.out.println("password is not valid");
    }

    private String formatName(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

    }


    public String getFullName() {
        String fullName = first_name.concat(last_name);
        return fullName;
    }


    public static void addToArray(Task task){
        taskArray[taskArrayCounter] = task;
        taskArrayCounter++;
    }

    public boolean isTaskRepetive(Task task){
        for (int i = 0; i <= taskArrayCounter; i++){
            if (taskArray[i] == task) return true;
        }
        return false;
    }

    public Task createTask(String taskName, User user){
        Task  newTask = new Task(taskName, user);
        if (isTaskRepetive(newTask) == false){
            addToArray(newTask);
            return newTask;
        }
        else {
            System.out.println("The task is repetitive!");
            return null;
        }

    }

    public User(String username, String password, String first_name, String last_name, String email) {

        setUsername(username);
        setPassword(password);
        setEmail(email);

        setFirstName(first_name);        
        setLastName(last_name);    
    }
}