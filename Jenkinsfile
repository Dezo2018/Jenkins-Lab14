pipeline {
    agent any
    stages {
        stage('Checkout') {
            agent { label 'Slave Node (1)' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: 'ea07d808-d4d6-4f66-931c-ad5d486fb37c',
                    branch: 'main'
            }
        }
    }
}
