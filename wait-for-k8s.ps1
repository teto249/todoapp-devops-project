# Wait for Kubernetes to be ready
Write-Host "Waiting for Kubernetes to start..." -ForegroundColor Yellow

do {
    try {
        $result = kubectl cluster-info 2>$null
        if ($LASTEXITCODE -eq 0) {
            Write-Host "✅ Kubernetes is now running!" -ForegroundColor Green
            kubectl cluster-info
            break
        }
    } catch { }
    
    Write-Host "." -NoNewline
    Start-Sleep -Seconds 5
} while ($true)

Write-Host "`n🚀 Ready to deploy your app!" -ForegroundColor Cyan
Write-Host "Run: kubectl apply -f k8s-deployment.yaml" -ForegroundColor Yellow
