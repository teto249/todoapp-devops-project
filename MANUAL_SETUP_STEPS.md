# Manual DevOps Setup Instructions

## URGENT NEXT STEPS TO COMPLETE

### 1. Enable Kubernetes in Docker Desktop
1. **Start Docker Desktop**:
   - Open Docker Desktop application
   - Wait for it to fully start

2. **Enable Kubernetes**:
   - Click on Docker Desktop system tray icon
   - Go to Settings/Preferences
   - Click on "Kubernetes" tab
   - Check "Enable Kubernetes"
   - Click "Apply & Restart"
   - Wait for Kubernetes to start (green indicator)

### 2. Verify Kubernetes Setup
```powershell
# After Docker Desktop starts with Kubernetes enabled
kubectl cluster-info
kubectl get nodes
```

### 3. Deploy Your Application
```powershell
# Deploy to Kubernetes
kubectl apply -f k8s-deployment.yaml

# Check deployment status
kubectl get deployments
kubectl get pods
kubectl get services

# Access your application
# Get the service URL
kubectl get services todoapp-service
# Your app will be at: http://localhost:30080
```

### 4. Create GitHub Repository (IMMEDIATE TASK)
1. Go to https://github.com
2. Click "New repository"
3. Repository name: `todoapp-springboot-devops`
4. Description: "Spring Boot Todo App with DevOps Pipeline"
5. Make it Public
6. Don't initialize with README (you have files already)
7. Click "Create repository"

### 5. Push Your Code to GitHub
```powershell
# Initialize git in your project folder
git init
git add .
git commit -m "Initial commit: Spring Boot Todo App with DevOps setup"
git branch -M main

# Add your GitHub repository (replace YOUR_USERNAME)
git remote add origin https://github.com/YOUR_USERNAME/todoapp-springboot-devops.git
git push -u origin main
```

### 6. Create Jira Project (IMMEDIATE TASK)
1. Go to https://www.atlassian.com/software/jira
2. Sign up for free account
3. Create new project:
   - Project name: "Todo App DevOps"
   - Project type: "Software Development"
   - Template: "Scrum"
4. Invite team members via email

### 7. Install Jenkins (Next Priority)
1. Download from: https://www.jenkins.io/download/
2. Install Jenkins
3. Open http://localhost:8080
4. Follow setup wizard
5. Install suggested plugins
6. Create admin user

### 8. Configure Jenkins
1. Install additional plugins:
   - Docker Pipeline
   - GitHub Integration
   - Blue Ocean
2. Add credentials:
   - GitHub Personal Access Token
   - Docker Hub credentials

### 9. Create Docker Hub Repository
1. Go to https://hub.docker.com
2. Sign up/login
3. Create repository: `YOUR_USERNAME/todoapp`
4. Make it public

### 10. Update Jenkinsfile and Push
```powershell
# Tag and push your Docker image to Docker Hub
docker tag todoapp:latest YOUR_USERNAME/todoapp:latest
docker push YOUR_USERNAME/todoapp:latest

# Update k8s-deployment.yaml to use Docker Hub image
# Change image: todoapp:latest to YOUR_USERNAME/todoapp:latest

# Commit and push changes
git add .
git commit -m "Update deployment to use Docker Hub image"
git push origin main
```

### 11. Recording Requirements for Submission
Record these activities:
1. [ ] Creating Jira project and adding team members
2. [ ] Creating GitHub repository and adding collaborators
3. [ ] Setting up Jenkins with plugins
4. [ ] Building and pushing Docker image
5. [ ] Deploying to Kubernetes
6. [ ] Complete CI/CD pipeline execution
7. [ ] Application running on Kubernetes

### 12. Screenshots Needed
- [ ] Jira project dashboard
- [ ] GitHub repository with team members
- [ ] Jenkins successful build
- [ ] Docker Hub repository
- [ ] Kubernetes pods running
- [ ] Application accessible in browser
- [ ] Jenkins pipeline logs

## TODAY'S PRIORITY ORDER:
1. ✅ Start Docker Desktop and enable Kubernetes
2. ✅ Create GitHub repository
3. ✅ Push code to GitHub
4. ✅ Create Jira project
5. ✅ Deploy to Kubernetes locally
6. Install Jenkins
7. Create Docker Hub repository
8. Setup CI/CD pipeline
9. Record everything

## Quick Verification Commands:
```powershell
# Check Docker
docker ps

# Check Kubernetes
kubectl get all

# Check your app
kubectl get services
# Access at http://localhost:30080

# Check git status
git status
git remote -v
```

## Team Collaboration Setup:
1. Add team members to GitHub repo as collaborators
2. Add team members to Jira project
3. Share Jenkins access with team
4. Document access credentials safely

This setup will complete your DevOps Part A requirements!
