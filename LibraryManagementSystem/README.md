# Library Management System

A Java-based Library Management System with MySQL database integration for managing books, users, and book issuing/returning operations.

## 👥 Team Members

- **Azizullah (023-25-0024)**
- **Wafa Hussain(023-25-0141)**
- **Sadaqat Ali (023-25-0135 )**
- **Arshad Ali (023-25-0022)**

## 📋 Project Overview

This Library Management System is a console-based application that provides functionality for:
- Adding and managing books
- Searching for books by title
- Viewing available books
- Issuing books to users
- Returning books
- Tracking book issue history

## 🛠️ Technologies Used

- **Java** - Core programming language
- **MySQL** - Database management
- **JDBC** - Database connectivity
- **MySQL Connector/J** - JDBC driver for MySQL

## 📦 System Requirements

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- MySQL Connector/J (JDBC Driver)
- IDE (Eclipse, IntelliJ IDEA, or NetBeans) or Command Line

## 🗄️ Database Structure

### Tables

#### 1. **users**
| Column | Type | Description |
|--------|------|-------------|
| id | INT (PK, AUTO_INCREMENT) | User ID |
| name | VARCHAR(100) | User name |
| email | VARCHAR(100) | User email |
| role | VARCHAR(50) | User role (student/admin) |

#### 2. **books**
| Column | Type | Description |
|--------|------|-------------|
| id | INT (PK, AUTO_INCREMENT) | Book ID |
| title | VARCHAR(200) | Book title |
| author | VARCHAR(100) | Book author |
| quantity | INT | Number of copies |
| isIssued | BOOLEAN | Issue status |

#### 3. **issues**
| Column | Type | Description |
|--------|------|-------------|
| id | INT (PK, AUTO_INCREMENT) | Issue ID |
| user_id | INT (FK) | References users(id) |
| book_id | INT (FK) | References books(id) |
| issue_date | TIMESTAMP | Date of issue |
| return_date | TIMESTAMP | Date of return (NULL if not returned) |

## 🚀 Installation & Setup

### Step 1: Install MySQL
1. Download and install MySQL Server from [mysql.com](https://dev.mysql.com/downloads/)
2. Set up MySQL with root user credentials

### Step 2: Create Database
```sql
CREATE DATABASE library_db;
```

### Step 3: Update Database Credentials
Open `DBManager` class and update the following:
```java
url = "jdbc:mysql://localhost:3306/library_db";
username = "root";
password = "YOUR_PASSWORD";  // Change this to your MySQL password
```

### Step 4: Add MySQL Connector/J
1. Download MySQL Connector/J from [MySQL website](https://dev.mysql.com/downloads/connector/j/)
2. Add the JAR file to your project's classpath

**For Command Line:**
```bash
javac -cp .:mysql-connector-java-x.x.xx.jar Main1.java
java -cp .:mysql-connector-java-x.x.xx.jar Main1
```

**For IDE:**
- Right-click project → Build Path → Add External JARs → Select mysql-connector-java.jar

### Step 5: Compile and Run
```bash
javac Main1.java
java Main1
```

## 📚 Class Structure

### Core Classes

#### 1. **DBManager**
Handles all database operations:
- Connection management (Singleton pattern)
- Table creation
- Dummy data insertion
- Connection testing

#### 2. **Book**
Entity class representing a book:
- Properties: id, title, author, quantity, isIssued
- Getters and setters
- toString() method for display

#### 3. **BookDAO** (Data Access Object)
Manages book-related database operations:
- `addBook()` - Add new book
- `viewAllBooks()` - Display all books
- `searchBook()` - Search by title or ID
- `updateBookStatus()` - Update issue status
- `deleteBook()` - Remove book
- `getAvailableBooks()` - Get non-issued books
- `getTotalBooks()` - Count total books

#### 4. **Issue**
Entity class representing a book issue record:
- Properties: id, userId, bookId, issueDate, returnDate
- Constructors and accessor methods

#### 5. **IssueDAO**
Manages book issuing operations:
- `isBookAvailable()` - Check book availability
- `issueBook()` - Issue book to user
- `returnBook()` - Process book return

## 🎯 Features

### Current Features
✅ Database connection management  
✅ Automatic table creation  
✅ Book CRUD operations  
✅ Book search functionality  
✅ Issue/Return tracking  
✅ Available books listing  
✅ Book status management  

### Potential Enhancements
- User authentication system
- Fine calculation for late returns
- Book reservation system
- Admin dashboard
- Report generation
- Email notifications
- GUI interface

## 💻 Usage Examples

### Adding a Book
```java
Book book = new Book("Operating System", "Galvin", false, 4);
bookDao.addBook(book);
```

### Searching for Books
```java
bookDao.searchBook("Java");
```

### Issuing a Book
```java
issueDao.issueBook(userId, bookId);
```

### Returning a Book
```java
issueDao.returnBook(bookId);
```

## 🐛 Common Issues & Solutions

### Issue 1: Connection Failed
**Solution:** Check MySQL service is running and credentials are correct

### Issue 2: ClassNotFoundException
**Solution:** Ensure MySQL Connector/J is in classpath

### Issue 3: SQLException
**Solution:** Verify database name and table structures

## 📝 Sample Output

```
Database Connected Successfully!
Connection Test Successful!
Tables Created Successfully!
Dummy Data Inserted!
Book added successfully!

All Books:
Book { ID=1, Title='Java Programming', Author='James Gosling', Quantity=5, Status=Available }
Book { ID=2, Title='Database Systems', Author='Elmasri', Quantity=3, Status=Available }
Book { ID=3, Title='Operating System', Author='Galvin', Quantity=4, Status=Available }

Search Book:
Book { ID=1, Title='Java Programming', Author='James Gosling', Quantity=5, Status=Available }

Available Books:
[List of available books]

Total Books:
3

Issue Book:
Book issued successfully!

Return Book:
Book returned successfully!

Connection Closed.
```

## 🤝 Contributing

This is a group project for educational purposes. Team members can contribute by:
1. Creating feature branches
2. Testing thoroughly before merging
3. Documenting code changes
4. Following Java coding conventions

## 📄 License

This project is created for educational purposes.

## 📧 Contact

For questions or issues, please contact any team member:
- Azizullah
- Wafa Hussain
- Sadaqat Ali
- Arshad Ali

---

**Note:** Remember to change the database password in `DBManager` class before running the application!

---

## 🔗 Project Links

- 📁 **Project Files (Google Drive):** [View on Google Drive](https://drive.google.com/file/d/1lDa4R6ZCAMmB2gPPaIEAvOKsc9foBM0a/view?usp=drive_link)
- 💻 **Source Code (GitHub):** [LibraryManagementSystem](https://github.com/Azizullah-Abbasi/LibraryManagementSystem)
