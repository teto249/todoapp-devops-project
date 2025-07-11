# DevOps Part A - Submission Checklist

## ✅ COMPLETED
- [x] Found existing software code (Spring Boot Todo App)
- [x] Created Dockerfile
- [x] Built Docker image successfully
- [x] Created Kubernetes deployment files
- [x] Application runs in Docker container

## 🔄 IN PROGRESS / NEXT STEPS

### 1. Project Management Setup
- [ ] **Create Jira project** - "Todo App DevOps"
- [ ] **Add team members to Jira**
- [ ] **Create GitHub repository** - "todoapp-springboot-devops"
- [ ] **Add team members as GitHub collaborators**

### 2. Container & Orchestration
- [ ] **Enable Kubernetes in Docker Desktop**
- [ ] **Deploy app to Kubernetes** (`kubectl apply -f k8s-deployment.yaml`)
- [ ] **Verify app runs on Kubernetes** (http://localhost:30080)
- [ ] **Access Kubernetes dashboard**

### 3. Jenkins CI/CD Pipeline
- [ ] **Install Jenkins**
- [ ] **Install Jenkins plugins** (Docker, Kubernetes, GitHub)
- [ ] **Configure Jenkins credentials** (GitHub, Docker Hub)
- [ ] **Create Jenkins pipeline job**
- [ ] **Test automated build from GitHub**

### 4. Docker Hub Integration
- [ ] **Create Docker Hub account & repository**
- [ ] **Push Docker image to Docker Hub**
- [ ] **Update Kubernetes deployment to use Docker Hub image**
- [ ] **Team members pull image from Docker Hub**

### 5. Integration & Testing
- [ ] **Integrate Jira with Jenkins**
- [ ] **Setup GitHub webhook for automatic builds**
- [ ] **Test complete CI/CD pipeline**
- [ ] **Verify end-to-end automation**

## 📹 RECORDING REQUIREMENTS

### Video Recording Checklist:
1. [ ] **Jira project setup** with team member invitations
2. [ ] **GitHub repository creation** and team collaboration setup
3. [ ] **Jenkins installation** and plugin configuration
4. [ ] **Docker image build and push** to Docker Hub
5. [ ] **Kubernetes deployment** process
6. [ ] **Application running** on Kubernetes cluster
7. [ ] **Complete CI/CD pipeline** execution (code change → auto deploy)

### Screenshots Required:
1. [ ] Jira project dashboard with team members
2. [ ] GitHub repository with collaborators list
3. [ ] Jenkins dashboard with successful build
4. [ ] Docker Hub repository with pushed image
5. [ ] Kubernetes dashboard showing running pods
6. [ ] Application accessible in browser (localhost:30080)
7. [ ] Jenkins pipeline execution logs
8. [ ] Team member access confirmations

## 🚀 QUICK START COMMANDS

### 1. Enable Kubernetes & Deploy
```bash
# Start Docker Desktop → Settings → Kubernetes → Enable
kubectl apply -f k8s-deployment.yaml
kubectl get all
kubectl get services  # Note the port for access
```

### 2. Create GitHub Repository
```bash
git init
git add .
git commit -m "DevOps Part A: Todo App with CI/CD setup"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/todoapp-springboot-devops.git
git push -u origin main
```

### 3. Build and Push to Docker Hub
```bash
docker tag todoapp:latest YOUR_USERNAME/todoapp:latest
docker push YOUR_USERNAME/todoapp:latest
```

## 📋 SUBMISSION DELIVERABLES

### Required Files:
- [x] **Source code** with Dockerfile
- [x] **k8s-deployment.yaml** - Kubernetes deployment configuration
- [x] **Jenkinsfile** - CI/CD pipeline definition
- [x] **docker-compose.yml** - Local development setup
- [x] **DEVOPS_SETUP_GUIDE.md** - Complete documentation
- [x] **README.md** - Project overview and setup instructions

### Required Access:
- [ ] **Jira project URL** with team member access
- [ ] **GitHub repository URL** with collaborator access
- [ ] **Docker Hub repository URL** with public access
- [ ] **Jenkins URL** (if accessible to team)

### Required Evidence:
- [ ] **Complete video recording** (10-15 minutes)
- [ ] **Screenshots collection** (all major steps)
- [ ] **Team collaboration proof** (invitations, access grants)
- [ ] **Working application URL** (Kubernetes deployment)

## ⏰ TIME ESTIMATES

| Task | Time Required | Priority |
|------|---------------|----------|
| Enable Kubernetes | 5 minutes | HIGH |
| Create GitHub repo | 5 minutes | HIGH |
| Create Jira project | 10 minutes | HIGH |
| Deploy to Kubernetes | 5 minutes | HIGH |
| Install Jenkins | 20 minutes | MEDIUM |
| Setup CI/CD pipeline | 30 minutes | MEDIUM |
| Create Docker Hub repo | 10 minutes | MEDIUM |
| Recording & Screenshots | 45 minutes | HIGH |

**Total estimated time: ~2.5 hours**

## 🎯 SUCCESS CRITERIA

### Technical Requirements:
✅ Application builds automatically from GitHub
✅ Docker image pushes to Docker Hub
✅ Application deploys to Kubernetes
✅ Team members can access all tools
✅ End-to-end automation works

### Documentation Requirements:
✅ All steps are recorded in video
✅ Screenshots document each major step
✅ Team collaboration is demonstrated
✅ Access URLs and credentials are documented

### Submission Requirements:
✅ Submitted by due date to e-learning
✅ All team members have access
✅ Video quality is clear and audible
✅ Complete demonstration of workflow

---

## 📞 SUPPORT CONTACTS
- **Project Lead**: [Your Name]
- **GitHub Repository**: https://github.com/YOUR_USERNAME/todoapp-springboot-devops
- **Jira Project**: [To be created]
- **Documentation**: Available in repository

**Next Action**: Start with enabling Kubernetes in Docker Desktop, then create GitHub repository!
