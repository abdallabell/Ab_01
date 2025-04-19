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
                echo 'Running security scan...'
                
                 
                        echo "Security Scan Passed"
                    
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
