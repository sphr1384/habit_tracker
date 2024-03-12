package UserPackage;

import java.util.Scanner;

import TaskPackage.Task;

public class User {
    public Task createTask(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("enter task name:");
        String taskName = scan.next(); 
        scan.close(); 
        Task  newTask = new Task(taskName);
        
         
        return newTask;
    }

    private String username;
    private String password;
    public String first_name;
    public String last_name;
    public String email;
    public int streak;

    public void setUsername(String S){
        username = S;
    }
    public String getUsername(){
        return this.username;
    }


    public void setPassword(String S){
        password = S;
    }
    public String getPassword(){
        return this.password;
    }

    public User (String username, String password, String first_name, String last_name, String email){
        setUsername(username);
        setPassword(password);
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getFullName(){
        return (first_name + " " + last_name);
    }
}
