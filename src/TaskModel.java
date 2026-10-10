import java.sql.Date;
import java.sql.Timestamp;
public class TaskModel {
    private int id;
    private String title;
    private String description;
    private java.sql.Date deadline;
    public enum Status{
        PENDING,COMPLETED;
    }
    private Status status;
    private int priority;
    private java.sql.Timestamp createdAt;

    //Setters
    public void setId(int id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setDeadline(java.sql.Date deadline){
        this.deadline=deadline;
    }
    public void setStatus(Status status){
        this.status=status;
    }
   public void setPriority(int priority){
        this.priority=priority;
   }
   public void setCreatedAt(java.sql.Timestamp createdAt){
        this.createdAt=createdAt;
   }

   //Getters
    public int getId()
    {
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public java.sql.Date getDeadline(){
        return deadline;
    }
    public Status getStatus(){
        return status;
    }
    public int getPriority(){
        return priority;
    }
    public java.sql.Timestamp getCreatedAt(){
        return createdAt;
    }
}
