pipeline {
    agent none
    stages {
        stage('Checkout') {
            agent { label 'Slave Node (1)' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: '7d937aa7-c4a9-4d20-a848-be32db0e02d5',
                    branch: 'main'
            }
        }
        stage('Build') {
            agent { label 'Slave Node (2) }
            steps {
                sh 'mvn -B DskipTests clean package'
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
