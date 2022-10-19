pipeline {
    agent any
    stages {
        stage('Checkout') {
            agent { label 'Slave Node (1)' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: '45085cc3-8539-46a1-8357-a08ac9a463ea',
                    branch: 'main'
            }
        }
    }
}
