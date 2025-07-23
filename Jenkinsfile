pipeline {
    agent {
        docker {
            image 'docker:24.0.2-dind'
            args '-u root --privileged -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    stages {
        stage('Install Dependencies') {
            steps {
                sh '''
                apk add --no-cache openjdk17 maven
                docker version
                docker compose version
                '''
            }
        }

        stage('Build App JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Start with Docker Compose') {
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up --build -d'
            }
        }
    }
}
