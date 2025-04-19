pipeline {
    agent any

    stages {
        stage('Build Java') {
            steps {
                sh 'javac App.java'
            }
        }

        stage('Security Scan') {
            steps {
                sh 'echo "Simulated security scan..."'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t devops-app .'
            }
        }

        stage('Run Docker') {
            steps {
                sh 'docker run --rm devops-app'
            }
        }
    }
}
