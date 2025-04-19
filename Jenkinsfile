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
                script {
                    // يبحث فقط عن الكلمة "Base64" ويرفض إذا وجدها
                   def result = sh(script: "grep -r 'Base64' --include='*.java' . || true", returnStatus: true)

                    if (result == 0) {
                        error("Security Scan Failed: Usage of Base64 is not allowed due to weak encoding.")
                    } else {
                        echo "Security Scan Passed"
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
