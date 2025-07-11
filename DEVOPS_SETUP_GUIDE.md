# DevOps Setup Guide - Todo App Spring Boot Project

## Project Overview
This document provides step-by-step instructions for setting up a complete DevOps pipeline for the Todo App Spring Boot application using Jenkins, Docker, Kubernetes, GitHub, and Jira.

## Part A: DevOps Implementation Checklist

### 1. Project Setup ✅
- [x] Found existing software code (Spring Boot Todo App)
- [x] Created Dockerfile for containerization
- [x] Created Docker Compose for local development

### 2. Project Management & Version Control
- [ ] Create Jira project account
- [ ] Invite team members to Jira
- [ ] Setup GitHub repository
- [ ] Add team members as collaborators

### 3. Jenkins Integration
- [ ] Install Jenkins plugins (Docker, Kubernetes)
- [ ] Integrate Jira with Jenkins
- [ ] Integrate GitHub with Jenkins
- [ ] Setup Docker and Kubernetes credentials

### 4. Docker & Kubernetes Deployment
- [ ] Create Kubernetes deployment files
- [ ] Setup Minikube
- [ ] Deploy application to Kubernetes
- [ ] Test Kubernetes dashboard

### 5. CI/CD Pipeline
- [ ] Create Jenkins pipeline
- [ ] Push Docker image to Docker Hub
- [ ] Automate deployment process
- [ ] Test automated builds

---

## Step-by-Step Implementation

### Step 1: Jira Project Setup

1. **Create Jira Account**
   - Go to [Atlassian Jira](https://www.atlassian.com/software/jira)
   - Create a free account
   - Create a new project: "Todo App DevOps"

2. **Project Configuration**
   ```
   Project Name: Todo App DevOps
   Project Type: Software Development
   Template: Scrum
   ```

3. **Invite Team Members**
   - Go to Project Settings → People
   - Add team member emails
   - Assign appropriate roles

### Step 2: GitHub Repository Setup

1. **Create Repository**
   ```bash
   # Create new repository on GitHub
   Repository Name: todoapp-springboot-devops
   Description: Spring Boot Todo App with DevOps Pipeline
   Visibility: Public/Private
   ```

2. **Add Collaborators**
   - Go to Settings → Manage access
   - Click "Invite a collaborator"
   - Add team member GitHub usernames

3. **Initialize Repository**
   ```bash
   git init
   git add .
   git commit -m "Initial commit: Spring Boot Todo App"
   git branch -M main
   git remote add origin https://github.com/yourusername/todoapp-springboot-devops.git
   git push -u origin main
   ```

### Step 3: Jenkins Setup and Configuration

1. **Install Jenkins**
   ```bash
   # Download Jenkins
   # Follow installation guide for your OS
   # Start Jenkins service
   ```

2. **Install Required Plugins**
   - Go to Manage Jenkins → Manage Plugins
   - Install these plugins:
     - Docker Pipeline
     - Kubernetes CLI
     - GitHub Integration
     - Jira Integration
     - Blue Ocean

3. **Configure Credentials**
   - Go to Manage Jenkins → Manage Credentials
   - Add GitHub Personal Access Token
   - Add Docker Hub credentials
   - Add Kubernetes config (if using remote cluster)

### Step 4: Docker Hub Setup

1. **Create Docker Hub Account**
   - Go to [Docker Hub](https://hub.docker.com)
   - Create account
   - Create repository: `yourusername/todoapp`

2. **Login to Docker Hub**
   ```bash
   docker login
   # Enter your Docker Hub credentials
   ```

### Step 5: Kubernetes Setup with Minikube

1. **Install Minikube**
   ```bash
   # Windows (using Chocolatey)
   choco install minikube

   # Or download from: https://minikube.sigs.k8s.io/docs/start/
   ```

2. **Start Minikube**
   ```bash
   minikube start
   
   # Verify installation
   kubectl cluster-info
   minikube status
   ```

3. **Access Dashboard**
   ```bash
   minikube dashboard
   # This will open Kubernetes dashboard in browser
   ```

### Step 6: Application Deployment

1. **Build and Push Docker Image**
   ```bash
   # Build image
   docker build -t yourusername/todoapp:latest .
   
   # Push to Docker Hub
   docker push yourusername/todoapp:latest
   ```

2. **Deploy to Kubernetes**
   ```bash
   # Apply deployment
   kubectl apply -f k8s-deployment.yaml
   
   # Check deployment status
   kubectl get deployments
   kubectl get pods
   kubectl get services
   ```

3. **Access Application**
   ```bash
   # Get service URL
   minikube service todoapp-service --url
   ```

### Step 7: Jenkins Pipeline Configuration

1. **Create New Pipeline Job**
   - New Item → Pipeline
   - Name: "TodoApp-CI-CD"
   - Configure GitHub webhook

2. **Pipeline Configuration**
   - Pipeline script from SCM
   - Repository URL: Your GitHub repo
   - Script Path: Jenkinsfile

### Step 8: Integration Testing

1. **Test GitHub Integration**
   ```bash
   # Make a change to code
   git add .
   git commit -m "Test CI/CD pipeline"
   git push origin main
   ```

2. **Verify Jenkins Build**
   - Check Jenkins dashboard
   - Verify build triggers automatically
   - Check build logs

3. **Verify Kubernetes Deployment**
   ```bash
   kubectl get pods
   kubectl logs <pod-name>
   ```

---

## Troubleshooting Common Issues

### Docker Issues
```bash
# If Docker build fails
docker system prune -f
docker build --no-cache -t yourusername/todoapp:latest .

# If permission denied
sudo usermod -aG docker $USER
# Logout and login again
```

### Kubernetes Issues
```bash
# If pods are not starting
kubectl describe pod <pod-name>
kubectl logs <pod-name>

# If minikube issues
minikube delete
minikube start --driver=docker
```

### Jenkins Issues
```bash
# If Jenkins can't connect to Docker
# Add Jenkins user to docker group
sudo usermod -aG docker jenkins
sudo systemctl restart jenkins

# If GitHub webhook not working
# Check GitHub webhook settings
# Verify Jenkins URL is accessible
```

---

## Monitoring and Verification

### 1. Application Health Check
```bash
# Check if application is running
curl http://$(minikube ip):30080/actuator/health

# Check Swagger documentation
curl http://$(minikube ip):30080/swagger-ui.html
```

### 2. Kubernetes Monitoring
```bash
# Check all resources
kubectl get all

# Check logs
kubectl logs -f deployment/todoapp-deployment

# Check events
kubectl get events --sort-by=.metadata.creationTimestamp
```

### 3. Jenkins Pipeline Status
- Monitor build history
- Check console output
- Verify deployment stages

---

## Recording Your Work

### Screenshots to Capture:
1. Jira project dashboard with team members
2. GitHub repository with collaborators
3. Jenkins dashboard with successful builds
4. Docker Hub repository with pushed images
5. Kubernetes dashboard showing running pods
6. Application running in browser
7. Minikube dashboard
8. Jenkins pipeline execution logs

### Video Recording Checklist:
1. [ ] Demonstrate Jira project setup
2. [ ] Show GitHub repository and team access
3. [ ] Jenkins pipeline execution from start to finish
4. [ ] Docker image build and push process
5. [ ] Kubernetes deployment process
6. [ ] Application running on Kubernetes
7. [ ] End-to-end CI/CD process (code change → deployment)

---

## Submission Requirements

### Documentation:
- [x] This DevOps setup guide
- [ ] Screenshots of all major steps
- [ ] Video recording of complete process
- [ ] Team member access confirmations

### Deliverables:
1. Jira project with team members
2. GitHub repository with collaborators
3. Jenkins pipeline configuration
4. Docker images in Docker Hub
5. Kubernetes deployment files
6. Working application accessible via Kubernetes
7. Complete video demonstration

---

## Team Collaboration Workflow

### Daily Workflow:
1. **Developer**: Push code changes to GitHub
2. **Jenkins**: Automatically triggers build pipeline
3. **Docker**: Builds and pushes new image
4. **Kubernetes**: Deploys updated application
5. **Team**: Reviews deployment in Kubernetes dashboard

### Project Management:
1. **Jira**: Track tasks and user stories
2. **GitHub**: Version control and code reviews
3. **Jenkins**: Continuous integration and deployment
4. **Kubernetes**: Production-ready deployment environment

---

## Next Steps
1. Complete all unchecked items in the checklist
2. Record demonstration video
3. Gather all screenshots
4. Submit to e-learning platform by due date

## Contact Information
- Project Lead: [Your Name]
- Repository: [GitHub URL]
- Jira Project: [Jira URL]
- Jenkins: [Jenkins URL]

## Current Status ✅
- [x] Spring Boot application is working and containerized
- [x] Docker image builds successfully (todoapp:latest)
- [x] kubectl is installed (v1.32.2)
- [x] Kubernetes deployment files created and configured
- [x] Dockerfile optimized for production
- [ ] Docker Desktop Kubernetes needs to be enabled
- [ ] GitHub repository needs to be created
- [ ] Jira project needs to be created
- [ ] Jenkins needs to be installed

## IMMEDIATE ACTION REQUIRED 🚨

### Step 1: Enable Kubernetes (5 minutes)
1. **Start Docker Desktop** (if not running)
2. **Go to Settings → Kubernetes → Enable Kubernetes**
3. **Apply & Restart** and wait for green status

### Step 2: Create GitHub Repository (5 minutes)
1. Go to GitHub.com and create new repository: `todoapp-springboot-devops`
2. Don't initialize with README
3. Copy the repository URL

### Step 3: Push Your Code (2 minutes)
```powershell
git init
git add .
git commit -m "Initial DevOps setup with Spring Boot Todo App"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/todoapp-springboot-devops.git
git push -u origin main
```

### Step 4: Deploy to Kubernetes (2 minutes)
```powershell
kubectl apply -f k8s-deployment.yaml
kubectl get pods
kubectl get services
# Access at: http://localhost:30080
```