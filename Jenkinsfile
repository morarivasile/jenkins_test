#!groovy

pipeline {
    agent any
    environment { 
        NEW_VERSION = "1.2.0"
    }
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
            when { 
                expression { 
                    BRANCH_NAME == "dev"
                }
            }
            steps {    
                println("Testing...")
            }
        }

        stage("Deploy") { 
            steps {    
                println("Deploying...")
                println("New version is: ${NEW_VERSION}")
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