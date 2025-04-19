pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/simple-devops.git'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("simple-devops:${env.BUILD_ID}")
                }
            }
        }
        
        stage('Run Container') {
            steps {
                script {
                    docker.image("simple-devops:${env.BUILD_ID}").run()
                }
            }
        }
    }
    
    post {
        always {
            echo 'تم الانتهاء من عملية البناء والتشغيل'
        }
    }
}
