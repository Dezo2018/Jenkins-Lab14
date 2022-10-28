#!/usr/bin/env groovy

def call() {
    sh 'mvn -B -DskipTests clean package'
    sh 'mvn test'  
}
