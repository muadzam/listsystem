pipeline {
    agent {
        docker {
            image 'docker:24.0.2-dind'
            args '-u root --privileged -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    environment {
        COMPOSE_VERSION = "1.29.2"
    }

    stages {
        stage('Install Dependencies') {
            steps {
                sh '''
                apk add --no-cache openjdk17 maven curl

                # Install docker-compose
                curl -L "https://github.com/docker/compose/releases/download/${COMPOSE_VERSION}/docker-compose-$(uname -s)-$(uname -m)" \
                    -o /usr/local/bin/docker-compose
                chmod +x /usr/local/bin/docker-compose
                docker-compose --version
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
                sh 'docker-compose down || true'
                sh 'docker-compose up --build -d'
            }
        }
    }
}
