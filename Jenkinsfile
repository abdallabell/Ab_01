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
        script {
            def result = sh(script: "grep -r 'Base64' . || true", returnStatus: true)
            if (result == 0) {
                error("Security Scan Failed: Weak encoding (Base64) detected!")
            }
        }
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
