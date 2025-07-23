pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "listsystem-app"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/muadzam/listsystem.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Run Docker Compose') {
            steps {
                sh 'docker compose down'
                sh 'docker compose up -d'
            }
        }

        stage('Expose with Ngrok') {
            steps {
                sh 'ngrok http 8080 > ngrok.log & sleep 10'
                sh 'cat ngrok.log | grep -o "https://[a-z0-9]*\\.ngrok-free\\.app" | head -1'
            }
        }
    }
}
