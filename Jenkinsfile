@Library('shared-library@main')_

pipeline {
    agent none
    environment {
        bucket = "desmond-jen-bucket"
        region = "us-east-1"
    }
    tools {
        maven 'Maven 3.8.6'
    }
    parameters{
        choice(
            choices: ['ONE', 'TWO'],
            name: 'ChoiceParam'
        )
        booleanParam(
            defaultValue: true,
            description: "",
            name: 'booleanParam'
        )
        string(
            defaultValue: "JenkinsLab",
            name: 'StringParam'
        )
        text(
            defaultValue: ''' 
            This is my first text
            parameter in Jenkins 
            ''',
            name: "TextParam",
            trim: true
        )
    }
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
            agent { label 'Slave Node (2)' }
            steps {
                script {
                    mvnBuild
                }
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        // stage('Upload') {
        //     agent { label 'Slave Node (2)' }
        //     steps {
        //         dir(''){

        //             pwd(); //Log current directory

        //             withAWS(region: env.region, credentials:'1bb2e8c8-84d5-481c-992c-b90c290717b5') {
        //                 script {
        //                     def identity=awsIdentity();//Log AWS credentials
        //                 }
        //                 // Upload files from working directory '*' in your project workspace
        //                 s3Upload(bucket: env.bucket, workingDir:'', includePathPattern:'**/*.jar');
        //             }
        //         };
        //     }
        // }
        stage('Setup parameters') {
            agent { label 'Slave Node (2)' }
            steps {
                sh 'echo $params.booleanParam'
                sh 'echo $params.TextParam'
                sh 'echo $params.ChoiceParam'
            }
        }
    }
}
