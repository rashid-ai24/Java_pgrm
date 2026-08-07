# College Dashboard

A fully functional college dashboard built with Spring Boot, Thymeleaf, and an in-memory H2 database. The app includes a web UI and REST API endpoints for students, courses, enrollments, and dashboard metrics.

## Requirements

- Java 17+ installed
- Maven installed, or use the Maven wrapper if added later

## Run locally

If you have Maven installed:

```bash
cd d:\college-dashboard
mvn clean package
mvn spring-boot:run
```

Or use the included Maven wrapper scripts (recommended if you don't have Maven).

Before using the wrapper, ensure the wrapper JAR exists at `.mvn/wrapper/maven-wrapper.jar`.
If it's missing, download it with one of the commands below.

PowerShell (Windows):

```powershell
$url = 'https://repo1.maven.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.4/maven-wrapper-3.3.4.jar'
Invoke-WebRequest -Uri $url -OutFile '.mvn\wrapper\maven-wrapper.jar' -UseBasicParsing
```

Command Prompt / PowerShell (with curl):

```powershell
curl -L -o .mvn\wrapper\maven-wrapper.jar "https://repo1.maven.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.4/maven-wrapper-3.3.4.jar"
```

On Windows run the wrapper with:

```powershell
.\mvnw.cmd clean package
.\mvnw.cmd spring-boot:run
```

On macOS / Linux run:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

Then open:

```text
http://localhost:8080
```

## Web UI

- `/` - Main dashboard
- `/students` - Students list
- `/courses` - Courses list

## REST API Endpoints

### Dashboard

- `GET /api/dashboard`
  - Response: `{ "studentCount": 3, "courseCount": 2, "enrollmentCount": 3 }`

### Students

- `GET /api/students`
  - Returns all students
- `GET /api/students/{id}`
  - Returns the student with the given ID
- `POST /api/students`
  - Create a new student
  - Body example:
    ```json
    {
      "name": "New Student",
      "email": "student@example.com"
    }
    ```

### Courses

- `GET /api/courses`
  - Returns all courses
- `GET /api/courses/{id}`
  - Returns the course with the given ID
- `POST /api/courses`
  - Create a new course
  - Body example:
    ```json
    {
      "code": "ENG301",
      "title": "Advanced English"
    }
    ```

### Enrollments

- `GET /api/enrollments`
  - Returns all enrollments with student and course details
- `POST /api/enrollments`
  - Create a new enrollment
  - Body example:
    ```json
    {
      "studentId": 1,
      "courseId": 2
    }
    ```

## H2 Database Console

The H2 console is enabled for development:

```text
http://localhost:8080/h2-console
```

Use these settings:

- JDBC URL: `jdbc:h2:mem:college`
- User Name: `sa`
- Password: (empty)

## Notes

Sample data is loaded automatically at startup for quick testing.
