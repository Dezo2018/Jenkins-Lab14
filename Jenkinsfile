import static io.wcm.devops.jenkins.pipeline.utils.ConfigConstants.*

pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    // environment {
    //     CREDENTIALS_ID = credentials('github-token')
    // }

    stages {
        stage('Checkout') {
            agent { label 'node-1' }
            steps {
                checkoutScm(
                    (SCM) : [
                        (SCM_URL) : "git@github.com:Dezo2018/Jenkins-Lab14.git"
                        (SCM_BRANCHES) : [[name: '*/main']]
                        // (SCM_CREDENTIALS_ID) : "$CREDENTIALS_ID"
                    ]
                )
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
