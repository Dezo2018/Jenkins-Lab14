pipeline {
    agent none
    environment {
        bucket = "desmond-jen-bucket"
        region = "us-east-1"
    }
    tools {
        maven 'Maven 3.8.6'
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
                sh 'mvn -B -DskipTests clean package'
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Upload') {
            agent { label 'Slave Node (2)' }
            steps {
                dir('home/ec2-user/workspace'){

                    pwd(); //Log current directory

                    withAWS(region:'us-east-1',credentials:'87b17462-320c-49f5-933b-186cb497fe39') {

                        def identity=awsIdentity();//Log AWS credentials

                        // Upload files from working directory 'dist' in your project workspace
                        s3Upload(bucket:"desmond-jen-bucket", workingDir:'/my-app/target', includePathPattern:'**/*.jar');
                    }
                };
            }
        }
    }
}
