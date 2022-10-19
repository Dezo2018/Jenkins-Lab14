pipeline {
    agent any
    stages {
        stage('Checkout') {
            agent { label 'Slave Node (1)' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: '14944dad-e6d3-445a-8ca0-d86f2ddd8f42',
                    branch: 'main'
            }
        }
    }
}
