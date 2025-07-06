# Jenkinsfile for TodoApp DevOps Pipeline
pipeline {
    agent any
    
    environment {
        DOCKER_HUB_REPO = 'your-dockerhub-username/todoapp'
        DOCKER_HUB_CREDENTIALS = credentials('dockerhub-credentials')
        KUBECONFIG_CREDENTIALS = credentials('kubeconfig')
        IMAGE_TAG = "${BUILD_NUMBER}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh './mvnw clean compile'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './mvnw test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh './mvnw package -DskipTests'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                script {
                    def image = docker.build("${DOCKER_HUB_REPO}:${IMAGE_TAG}")
                    docker.withRegistry('https://registry-1.docker.io', 'dockerhub-credentials') {
                        image.push()
                        image.push('latest')
                    }
                }
            }
        }
        
        stage('Deploy to Kubernetes') {
            steps {
                echo 'Deploying to Kubernetes...'
                script {
                    sh "sed -i 's|your-dockerhub-username/todoapp:latest|${DOCKER_HUB_REPO}:${IMAGE_TAG}|g' k8s-deployment.yaml"
                    sh 'kubectl apply -f k8s-deployment.yaml'
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completed!'
            cleanWs()
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
