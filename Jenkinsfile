pipeline {
    agent any
    stages {
        stage('Checkout') {
            agent { label 'Slave Node (1)' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: '7d937aa7-c4a9-4d20-a848-be32db0e02d5',
                    branch: 'main'
            }
        }
    }
}
