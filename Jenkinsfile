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
                apk add --no-cache openjdk17 maven curl py3-pip
                pip install docker-compose
                '''
            }
        }

        stage('Build App JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t listsystem-app .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh 'docker rm -f listsystem-app || true'
            }
        }

        stage('Start with Docker Compose') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}
