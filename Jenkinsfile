pipeline {
    agent any
    environment {
        DEPENDENCY_CHECK_HOME = '/opt/dependency-check'  // مسار التثبيت لـ OWASP Dependency-Check على الخادم
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/abdallabell/Ab_01.git'
            }
        }
        stage('Build Java') {
            steps {
                script {
                    // بناء التطبيق
                    sh 'javac App.java'
                }
            }
        }
        stage('OWASP Dependency-Check') {
            steps {
                script {
                    // تنفيذ فحص OWASP Dependency-Check
                    sh '''
                    dependency-check --project "MyJavaProject" \
                                     --scan . \
                                     --out ./dependency-check-report \
                                     --format HTML
                    '''
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
            // إرسال التقرير بعد الفحص أو الإجراءات المطلوبة
            archiveArtifacts allowEmptyArchive: true, artifacts: 'dependency-check-report/*.html'
            echo 'Pipeline finished.'
        }
        failure {
            // إرسال تنبيه إذا تم اكتشاف مشاكل أثناء الفحص
            mail to: 'admin@example.com',
                 subject: "Jenkins Build Failure: ${currentBuild.fullDisplayName}",
                 body: "The build has failed. Please check the logs for more details."
        }
    }
}
