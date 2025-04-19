pipeline {
    agent any
    
    tools {
        jdk 'JDK 17'  // تحديد إصدار JDK في Jenkinsfile
    }
    
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'javac App.java'
                }
            }
        }
    }
}
