#!groovy

pipeline {
    agent any
    stages { 
        stage("Prepare") { 
            steps {    
                println("Preparing...")
            }
        }

        stage("Build") { 
            steps {    
                println("Building...")
            }
        }

        stage("Test") { 
            steps {    
                println("Testing...")
            }
        }

        stage("Deploy") { 
            steps {    
                println("Deploying...")
            }
        }
    }
    post { 
        success { 
            println("Pipeline succeeded HOORAY!")
            println("Branch name: ${BRANCH_NAME}")
        }
    }
}