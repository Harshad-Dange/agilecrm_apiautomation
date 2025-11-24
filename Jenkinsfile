pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git url: 'https://github.com/Harshad-Dange/agilecrm_apiautomation.git', branch: 'main'
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
                // bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deployment logic goes here...'
            }
        }
    }
}
