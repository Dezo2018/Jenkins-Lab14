pipeline {
    agent any
    stages {
        stage('Checkout') {
            agent { label 'Slave Node (1)' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: '5a5c1459-4e62-4cae-888b-31953c70008a',
                    branch: 'main'
            }
        }
    }
}
