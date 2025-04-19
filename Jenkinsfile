pipeline {
    agent any

    environment {
        // هنا يمكن تعريف متغيرات البيئة
    }

    stages {
        stage('Checkout') {
            steps {
                // استنساخ الكود من المستودع
                git 'https://github.com/abdallabell/Ab_01.git'
            }
        }

        stage('Build Java') {
            steps {
                // بناء الكود باستخدام javac
                script {
                    sh 'javac App.java'
                }
            }
        }

        stage('Docker Build') {
            steps {
                // بناء صورة Docker
                script {
                    sh 'docker build -t my-java-app .'
                }
            }
        }

        stage('Run Docker') {
            steps {
                // تشغيل حاوية Docker
                script {
                    sh 'docker run -d -p 8080:8080 my-java-app'
                }
            }
        }
    }

    post {
        always {
            // تنظيف البيئة بعد الانتهاء من تنفيذ جميع المراحل
            echo 'Pipeline finished.'
        }
        success {
            // يمكن إضافة إشعار عند النجاح هنا
            echo 'Pipeline completed successfully!'
        }
        failure {
            // يمكن إضافة إشعار عند الفشل هنا
            echo 'Pipeline failed.'
        }
    }
}
