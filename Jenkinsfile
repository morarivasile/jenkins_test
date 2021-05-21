#!groovy

pipeline {
    agent any

    // agent {
    //     label 'dev-merge'
    // }

    // Declare env variables here
    environment { 
        NEW_VERSION = "1.2.0"
    }

    // Declare parameters here. Visually interactive in Jenkins UI
    parameters { 
        // string(name: "VERSION", defaultValue: "", description: "Version to deploy on prod")
        choice(name: "VERSION", choices: ["1.1.0", "1.2.0", "1.3.0"], description: "")
        booleanParam(name: "executeTests", defaultValue: true, description)
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
                    BRANCH_NAME == "dev" && params.executeTests
                }
            }
            steps {    
                println("Testing...")
            }
        }

        stage("Deploy") { 
            steps {    
                println("Deploying...")
                println("Deploying version ${params.VERSION}")
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