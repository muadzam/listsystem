pipeline {
    agent {
        docker {
            image 'maven:3.9.4-openjdk-17'
        }
    }

    stages {
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t your-image-name .'
            }
        }

        stage('Run Docker Compose') {
            steps {
                sh 'docker-compose up -d'
            }
        }

        stage('Expose with Ngrok') {
            steps {
                sh 'ngrok http 8080'
            }
        }
    }
}
