pipeline {
    agent any

    tools {
        jdk 'jdk17' // تأكد أن JDK 17 معرف في Jenkins بهذا الاسم
    }

    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/abdallabell/Ab_01.git' // استبدل بالرابط الصحيح إن لزم
            }
        }

        stage('Build Java') {
            steps {
                sh 'javac App.java'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t hello-java-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run --rm hello-java-app'
            }
        }
    }
}
