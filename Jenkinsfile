pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/abdallabell/Ab_01.git'
            }
        }

        stage('Build Java') {
            steps {
                script {
                    // بناء الكود باستخدام javac
                    sh 'javac App.java'
                }
            }
        }

        stage('OWASP Dependency-Check') {
            steps {
                script {
                    // تنفيذ فحص OWASP Dependency-Check
                    echo "Running OWASP Dependency-Check..."
                    sh 'dependency-check --project "DevOps Java App" --scan . --format HTML --out ./dependency-check-report'
                }
            }
        }

        stage('Run Java Application') {
            steps {
                script {
                    // تشغيل تطبيق Java
                    sh 'java App'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t myapp .'
            }
        }

        stage('Run Docker') {
            steps {
                sh 'docker run -d -p 8080:8080 myapp'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        failure {
            mail to: 'admin@example.com',
                 subject: "Jenkins Build Failure: ${currentBuild.fullDisplayName}",
                 body: "The build has failed due to insecure encryption method or dependencies. Please review the logs and OWASP Dependency-Check report."
        }
    }
}
