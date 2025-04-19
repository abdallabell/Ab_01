pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/USERNAME/REPO.git'
            }
        }

        stage('Build') {
            steps {
                sh 'javac App.java'
            }
        }

        stage('Run Java') {
            steps {
                sh 'java App'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t hello-world-java .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker run --rm hello-world-java'
            }
        }
    }
}

