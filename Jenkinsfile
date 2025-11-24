pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git url: 'https://github.com/Harshad-Dange/agilecrm_apiautomation.git', branch: 'main'
            }
        }
        stage('Clean') {
                    steps {
                        echo 'Cleaning project...'
                        bat 'mvn clean'
                    }
                }
        stage('Build') {
            steps {
                echo 'Building project...
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package' // creates JAR/WAR in target/
            }
        }
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
         }

        stage('Deploy') {
            steps {
                echo 'Deployment logic goes here...'
            }
        }
    }
     post {
            success {
                echo 'Build succeeded!'
            }
            failure {
                echo 'Build failed!'
            }
        }
}
