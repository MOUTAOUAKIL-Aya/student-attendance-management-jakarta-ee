# 🎓 Student Attendance Management System (Jakarta EE)

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-10-blue?style=for-the-badge&logo=eclipseide&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-3--Tier%20%2F%20MVC-success?style=for-the-badge)

A modular, enterprise-grade web application for tracking and managing university student absences. Built with **Jakarta EE**, this project demonstrates a pure 3-tier architecture with **MVC design pattern**, decoupled **DAO persistence**, service-layer business logic, and a **custom-built lightweight ORM engine**.

---

## 📌 Key Architectural Highlights

Unlike applications relying completely on high-level frameworks (e.g., Spring Boot), this project showcases a thorough understanding of foundational Java Enterprise principles and design patterns:

- **Front Controller & MVC Pattern:** A single centralized servlet (`Controller.java`) mapping incoming request paths to modular action methods (`AbsenceAction.java`) and forwarding views with dynamic models.
- **Custom Lightweight ORM Engine:** [`ORM.java`](./src/main/java/com/esisa/absences/mapping/ORM.java) implements automatic mapping from database tabular record matrices into strongly-typed Java entities (`Etudiant`, `Absence`, `Matiere`).
- **Data Access Object (DAO) Pattern:** Strict separation of database access logic through interfaces (`AbsenceDao`, `EtudiantDao`, `MatiereDao`) with JDBC implementations (`AbsenceDaoJdbc`, etc.).
- **Service Layer (Business Logic):** Encapsulates business validation rules and coordinates multi-DAO transactions (`AbsenceServiceDefault.java`).
- **Resilient Database Connectivity:** Configured with modern MySQL 8+ support, SSL safety, and fallback driver detection (`MySQLDataSource.java`).

---

## 🏛️ Project Structure

```
student-attendance-management-jakarta-ee/
│
├── 📂 database/
│   └── absences.sql              # Database DDL schema & sample dataset
│
├── 📂 src/main/
│   ├── 📂 java/com/esisa/absences/
│   │   ├── 📂 business/          # Business logic interfaces & implementation
│   │   │   ├── AbsenceService.java
│   │   │   └── AbsenceServiceDefault.java
│   │   ├── 📂 dao/               # Data Access Object contracts & JDBC implementations
│   │   │   ├── AbsenceDao.java & AbsenceDaoJdbc.java
│   │   │   ├── EtudiantDao.java & EtudiantDaoJdbc.java
│   │   │   └── MatiereDao.java & MatiereDaoJdbc.java
│   │   ├── 📂 jdbc/              # Connection pooling & low-level JDBC helpers
│   │   │   ├── Database.java
│   │   │   ├── DataSource.java
│   │   │   └── MySQLDataSource.java
│   │   ├── 📂 mapping/           # Custom lightweight ORM mapper
│   │   │   └── ORM.java
│   │   ├── 📂 models/            # Domain Entities (JavaBeans)
│   │   │   ├── Absence.java
│   │   │   ├── Etudiant.java
│   │   │   └── Matiere.java
│   │   └── 📂 web/               # Web Layer (MVC Front Controller & Actions)
│   │       ├── Controller.java
│   │       ├── Model.java
│   │       └── actions/AbsenceAction.java
│   │
│   └── 📂 webapp/                # Web application resources
│       ├── 📂 css/styles.css     # Clean CSS styling
│       ├── 📂 views/             # JSP templates (etudiants-list, absences-list, error)
│       ├── 📂 WEB-INF/web.xml    # Deployment descriptor
│       └── index.html            # Navigation dashboard
│
├── ⚙️ pom.xml                    # Standard Maven build configuration
└── 📖 README.md                  # Comprehensive documentation
```

---

## 🗄️ Database Setup

The project includes an automatic initialization script in [`database/absences.sql`](./database/absences.sql):

1. Open your MySQL client (MySQL Workbench, phpMyAdmin, or CLI):
   ```bash
   mysql -u root -p < database/absences.sql
   ```
2. The script will automatically:
   - Create the `absences` database with `utf8mb4` encoding.
   - Create tables `etudiants`, `matieres`, and `absences` with foreign key constraints.
   - Populate realistic sample records across multiple semesters and modules.

---

## 🌐 Web Endpoints & Actions

| Route | Method | Description |
| :--- | :--- | :--- |
| `/absences/get-all-etudiants` | `GET` | Retrieves and displays the full student directory |
| `/absences/search-etudiant?nom=...` | `GET` | Searches students dynamically by surname |
| `/absences/absences-mois?mois=...` | `GET` | Aggregates all recorded student absences for a given month |
| `/absences/absences-etudiant?id=...` | `GET` | Lists all absence events for a specific student ID |

---

## 🚀 How to Build and Run

### Option A: Using Apache Tomcat (v10+)
1. Ensure **Apache Tomcat 10.0+** (supporting Jakarta EE 9/10) is installed.
2. Build the `.war` archive using Maven:
   ```bash
   mvn clean package
   ```
3. Deploy `target/absences.war` to Tomcat's `webapps/` folder.
4. Access the web interface at:
   ```
   http://localhost:8080/absences/
   ```

### Option B: Using Eclipse / IntelliJ IDEA
1. Import the project as an **Existing Maven Project**.
2. Configure your local **Apache Tomcat 10+** Server runtime.
3. Right-click the project -> **Run On Server**.

---

## 👩‍💻 Author
- **Aya MOUTAOUAKIL** - *Business Intelligence & Software Engineering Student (ESISA)*
- GitHub: [@MOUTAOUAKIL-Aya](https://github.com/MOUTAOUAKIL-Aya)
