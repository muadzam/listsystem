pipeline {
    agent {
        docker {
            image 'docker:24.0.2-dind'
            args '-u root --privileged -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    stages {
        stage('Build with Maven') {
            steps {
                sh '''
				apk add --no-cache openjdk17 maven
				mvn clean package -DskipTests
				'''
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t listsystem-app .'
            }
        }
		
		stage('Stop Old Container'){
			steps{
				sh "docker rm -f  listsystem-app || true"
			}
		}

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8080:8080 listsystem-app'
            }
        }
    }
}
