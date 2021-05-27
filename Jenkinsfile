#!groovy

@Library('my-shared-library') _

def common

pipeline {
    agent any

    // Declare parameters here. Visually interactive in Jenkins UI
    parameters {
        choice(name: "VERSION", choices: ["1.1.0", "1.2.0", "1.3.0"], description: "")
        booleanParam(name: "executeTests", defaultValue: true, description: "")
    }

    stages { 
        stage("Wrlcome") { 
            steps { 
                welcomeJob 'VASYAAA'
            }
        }
        stage("Prepare") { 
            steps {
                println("Preparing...")
                script {
                    common = load "common.groovy"
                }
            }
        }

        stage("Build") { 
            steps {  
                script { 
                    common.build()
                }  
            }
        }

        stage("Test") { 
            when { 
                expression { 
                    params.executeTests
                }
            }
            steps {    
                script { 
                    common.test()
                }
            }
        }

        stage("Deploy") { 
            steps {    
                script { 
                    common.deploy()
                }
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