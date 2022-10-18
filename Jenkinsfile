pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Checkout') {
            agent { label 'node-1' }
            steps {
                git url: 'https://github.com/Dezo2018/Jenkins-Lab14.git',
                    credentialsId: '3294a4ff-262b-4d7c-8e4b-ef0b55b01917',
                    branch: 'main'
            }
        }
        stage('Build') {
            agent { label 'node-2' }
            steps {
                sh 'mvn -B -DskipTests clean validate'
                sh 'mvn test'
                sh 'mvn compile package'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
