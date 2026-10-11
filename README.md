# Task Manager JDBC

A console-based Task Management System developed using **Java, JDBC, and MySQL**. This application allows users to manage tasks through a simple menu-driven interface and store task information in a MySQL database.

## Features

* **Add Tasks:** Create tasks with a title, description, deadline, and priority.
* **View Tasks:** Display all tasks stored in the database.
* **Update Task Status:** Mark tasks as `PENDING` or `COMPLETED`.
* **Delete Tasks:** Remove tasks with a confirmation step.
* **Database Connectivity:** Use JDBC to connect Java to MySQL.
* **Persistent Storage:** Store task information in a relational database.

## Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL
* SQL

## Prerequisites

Before running the application, ensure you have:

* Java Development Kit (JDK) installed.
* MySQL Server installed and running.
* MySQL Connector/J JDBC driver.
* An IDE such as IntelliJ IDEA or Eclipse, or a terminal for compiling and running Java programs.

## Database Setup

1. Open MySQL Workbench or your MySQL command-line client.
2. Create the database used by the application.
3. Create the task table with columns matching the fields used in the Java code.
4. Update the database connection URL, username, and password in the application configuration.

Example database creation:

```sql
CREATE DATABASE task_mgr;
USE task_mgr;
```

Make sure the database and table names match those used in your Java code and SQL statements.

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR-USERNAME/Task-Manager-JDBC.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Task-Manager-JDBC
   ```

3. Configure the MySQL connection details and ensure the JDBC driver is available on the classpath.

4. Open the project in your Java IDE or compile and run the application from the terminal.

5. Run the `TaskManager` main class.

6. Use the menu displayed in the console to add, view, update, or delete tasks.

## Concepts Practiced

* JDBC database connectivity
* SQL CRUD operations (Create, Read, Update, Delete)
* Java classes and objects
* Exception handling
* `PreparedStatement` and `ResultSet`
* Resource management using try-with-resources
* Working with dates, task priorities, and status values

## Future Improvements

* Add task search and filtering.
* Display tasks sorted by deadline or priority.
* Add input validation and improved error handling.
* Introduce a graphical user interface.
* Add user authentication and individual task lists.

## Author

**YOUR NAME**

GitHub: https://github.com/shekinah2007
