pipeline {
    agent any
    stages {
        stage('Checkout') {
            agent { label 'Slave Node (1)' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: '45f94a69-5685-478a-b17e-27e994b424c3',
                    branch: 'main'
            }
        }
    }
}
