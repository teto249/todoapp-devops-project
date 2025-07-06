
# TodoApp DevOps Project

## Overview
This is a Spring Boot Todo Application with a complete DevOps pipeline including Jenkins, Docker, and Kubernetes.

## Features
- Simple Todo Management (Create, Read, Update, Delete)
- Task Status Management (Pending, In Progress, Completed)
- Priority Levels (Low, Medium, High)
- Modern Web UI
- REST API with Swagger Documentation

## Technology Stack
- **Backend**: Spring Boot 2.7.x, Java 21
- **Database**: H2 (In-memory for demo)
- **Build Tool**: Maven
- **Containerization**: Docker
- **Orchestration**: Kubernetes (Minikube)
- **CI/CD**: Jenkins
- **Version Control**: Git/GitHub

## API Endpoints

### Tasks
- `GET /api/tasks` - Get all tasks
- `GET /api/tasks/{id}` - Get task by ID  
- `POST /api/tasks` - Create new task
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task
- `GET /api/tasks/status/{status}` - Get tasks by status

### Swagger Documentation
- `http://localhost:8080/swagger-ui.html` - Interactive API documentation

## Build Application

To install this application, run the following commands:

```git
git clone https://github.com/devSuatt/todoApp-fullStack.git
```

## Test Application

You can run unit tests in `src/test/java/com/devsuatt/todoApp`

## Run Application with dependencies on Maven

- For maven usage

```xml
$ mvn clean install
$ mvn spring-boot:run
```

#### PORT: 8080

Swagger UI will be run on this url

`http://localhost:${PORT}/swagger-ui.html`

### Docker Hub

You can pull this application from Docker Hub

Link: https://hub.docker.com/r/devsuatt16/todoapp

`docker pull devsuatt16/todoapp`

### Docker Build

`docker build --compress --force-rm -t {Docker_Hub_Username}/{Docker_Hub_RepoName}:{Tag} .`

Example: `docker build . -t todoapp:1.0`

Run Docker image locally on a container with a name for the container.

`docker run --name todoapp -d -p 9090:8080 todoapp:1.0`

