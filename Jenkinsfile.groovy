pipline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                sh "mvn install-Dcucumber.filter.tags =\"{TAG}\""
            }
        }
        stage('Allure Report Generation') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/reports/allure-results']]
            }
        }

    }
    post {
        always {
            cleanWS notFailBuild: true
        }
    }
}