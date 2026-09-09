pipeline {
    agent any

    tools {
        jdk 'Java-21'
        maven 'Maven-3.9.16'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'target/surefire-reports/*.xml',
                             allowEmptyArchive: true

            archiveArtifacts artifacts: 'target/screenshots/*.png',
                             allowEmptyArchive: true
        }
    }
}