import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
class TaskManager{
    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/task_jdbc";
        String username = "your_username";
        String password = "your_password";
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected Successfully to DB");

            int choice=0;
            while(choice!=5)
            {
                System.out.println("enter your choice");
                System.out.println("1.Add task");
                System.out.println("2.print task");
                System.out.println("3.update task");
                System.out.println("4.Remove tasks");
                System.out.println("5.exit program");
                choice=Integer.parseInt(sc.nextLine());


                switch(choice)
                {
                    case 1:
                        addTask(sc,connection);
                        break;
                    case 2:
                        viewTask(connection);
                        break;
                    case 3:
                        updateTaskStatus(sc,connection);
                        break;
                    case 4:
                        deleteTask(sc,connection);
                        break;
                    case 5:
                        System.out.println("Exiting program");
                        break;
                    default:
                        System.out.println("please enter a valid choice");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void addTask(Scanner sc,Connection connection){
       try(PreparedStatement ps = connection.prepareStatement("INSERT INTO task_table(title,description,deadline,priority)VALUES(?,?,?,?)")){
           System.out.println("enter the title");
           String title = sc.nextLine();
           System.out.println("enter the description");
           String description = sc.nextLine();
           System.out.println("enter the date in the format yyyy-mm-dd");
           String date = sc.nextLine();
           System.out.println("enter the priority of the task");
           int priority = Integer.parseInt(sc.nextLine());
           java.sql.Date deadline = java.sql.Date.valueOf(date);


           ps.setString(1,title);
           ps.setString(2,description);
           ps.setDate(3,deadline);
           ps.setInt(4,priority);

           int rows=ps.executeUpdate();
           if(rows>0)
               System.out.println(rows+" row(s) affected");
       }
       catch(SQLException E)
       {
           E.printStackTrace();
       }
    }
    private static void viewTask(Connection connection){
        try(PreparedStatement ps=connection.prepareStatement("SELECT * FROM task_table");
        ResultSet rs=ps.executeQuery();){
          System.out.println("id"+" | "+" title "+" | "+" description "+" | "+" deadline" +" | "+" status "+" | "+"priority"+" | "+" created at ");
            System.out.println("----------------------------------------------------------------------------------------------");
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String description=rs.getString("description");
                Date deadline=rs.getDate("deadline");
                String status=rs.getString("status");
                int priority=rs.getInt("priority");
                Timestamp created_at=rs.getTimestamp("created_at");

               System.out.printf("%-3d|%-10s|%-15s|%-12s|%-10s|%-7d|%-15s\n",id,title,description,deadline,status,priority,created_at);
                System.out.println("----------------------------------------------------------------------------------------------");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    private static void updateTaskStatus(Scanner sc,Connection connection){
       try(PreparedStatement ps= connection.prepareStatement("UPDATE task_table SET status=? WHERE id=?")){
           System.out.println("enter the task id which you want to update");
           int task_id=Integer.parseInt(sc.nextLine());
           System.out.println("select the status");
           System.out.println("1.pending");
           System.out.println("2.completed");
           int choice=Integer.parseInt(sc.nextLine());
           String status="";
           switch(choice)
           {
               case 1:
                   status="PENDING";
                   break;
               case 2:
                   status="COMPLETED";
                   break;
               default:
                   System.out.println("enter a valid choice");
                   return;
           }
           ps.setString(1,status);
           ps.setInt(2,task_id);

           int row=ps.executeUpdate();
           if(row>0)
               System.out.println(row+" rows updated");
           else
               System.out.println("0 rows affected");
       }
       catch(SQLException E)
       {
           E.printStackTrace();
       }
    }
    private static void deleteTask(Scanner sc,Connection connection){
      try(PreparedStatement ps=connection.prepareStatement("DELETE FROM task_table WHERE id=?")){
          System.out.println("enter the task id which you want to delete");
          int id=Integer.parseInt(sc.nextLine());

          System.out.println("Are you sure you want to delet task "+id+" yes/no");
          String confirm=sc.nextLine();

          if(confirm.equalsIgnoreCase("yes"))
          {
              ps.setInt(1,id);
              int row=ps.executeUpdate();

              if(row>0)
                  System.out.println(row+" row(s) deleted");
              else{
                  System.out.println("0 rows deleted");
                  return;
              }
          }
          else{
              System.out.println("deletion cancelled");
              return;
          }
      }
      catch(SQLException e)
      {
          e.printStackTrace();
      }
    }
}
