
pipeline {
    agent any
    
    tools {
        jdk 'jdk17'  # يجب تكوين JDK في Jenkins
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh '''
                    echo "Building Java application..."
                    mkdir -p target
                    javac -d target/classes src/main/java/com/example/App.java
                    jar cfe target/hello-devops.jar com.example.App -C target/classes .
                '''
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("hello-devops:latest")
                }
            }
        }
        
        stage('Run') {
            steps {
                script {
                    docker.image("hello-devops:latest").run("--name hello-devops-container -d")
                    sleep(5)
                    sh 'docker logs hello-devops-container'
                }
            }
            post {
                always {
                    sh 'docker stop hello-devops-container || true'
                    sh 'docker rm hello-devops-container || true'
                }
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
EOF
