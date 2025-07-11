# DevOps Part A - Status Checker
Write-Host "=== DevOps Part A Status Check ===" -ForegroundColor Cyan

# Check Docker Desktop
Write-Host "`n1. Checking Docker Desktop..." -ForegroundColor Yellow
try {
    $dockerInfo = docker info 2>$null
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ Docker Desktop is running" -ForegroundColor Green
    } else {
        Write-Host "❌ Docker Desktop is not running" -ForegroundColor Red
        Write-Host "   Please start Docker Desktop and wait for it to load" -ForegroundColor Gray
    }
} catch {
    Write-Host "❌ Docker Desktop is not running" -ForegroundColor Red
}

# Check Kubernetes
Write-Host "`n2. Checking Kubernetes..." -ForegroundColor Yellow
try {
    $k8sInfo = kubectl cluster-info 2>$null
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ Kubernetes is running" -ForegroundColor Green
    } else {
        Write-Host "❌ Kubernetes is not running" -ForegroundColor Red
        Write-Host "   Enable Kubernetes in Docker Desktop Settings" -ForegroundColor Gray
    }
} catch {
    Write-Host "❌ Kubernetes is not running" -ForegroundColor Red
}

# Check if app is deployed
Write-Host "`n3. Checking Todo App deployment..." -ForegroundColor Yellow
try {
    $pods = kubectl get pods -l app=todoapp 2>$null
    if ($LASTEXITCODE -eq 0 -and $pods -notlike "*No resources found*") {
        Write-Host "✅ Todo App is deployed to Kubernetes" -ForegroundColor Green
        kubectl get pods -l app=todoapp
        Write-Host "`n🌐 Access app at: http://localhost:30080" -ForegroundColor Cyan
    } else {
        Write-Host "❌ Todo App is not deployed" -ForegroundColor Red
        Write-Host "   Run: kubectl apply -f k8s-deployment.yaml" -ForegroundColor Gray
    }
} catch {
    Write-Host "❌ Todo App is not deployed" -ForegroundColor Red
}

Write-Host "`n=== Part A Completion Status ===" -ForegroundColor Cyan
Write-Host "Docker Desktop: $(if (docker info 2>$null) {'✅'} else {'❌'})" -ForegroundColor White
Write-Host "Kubernetes:     $(if (kubectl cluster-info 2>$null) {'✅'} else {'❌'})" -ForegroundColor White
Write-Host "App Deployed:   $(if (kubectl get pods -l app=todoapp 2>$null) {'✅'} else {'❌'})" -ForegroundColor White

if ((docker info 2>$null) -and (kubectl cluster-info 2>$null) -and (kubectl get pods -l app=todoapp 2>$null)) {
    Write-Host "`n🎉 PART A IS COMPLETE! 🎉" -ForegroundColor Green
} else {
    Write-Host "`n⚠️  PART A IS NOT YET COMPLETE" -ForegroundColor Yellow
    Write-Host "Follow the steps above to finish Part A" -ForegroundColor Gray
}
