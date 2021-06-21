#!groovy

def common

pipeline {
    agent any

    // Declare parameters here. Visually interactive in Jenkins UI
    parameters {
        choice(name: "VERSION", choices: ["1.1.0", "1.2.0", "1.3.0"], description: "")
        booleanParam(name: "executeTests", defaultValue: true, description: "")
    }

    stages {
//         stage("Load shared library") { 
//             steps {
//                 library 'my-shared_lib@main'
//             }
//         }
        
        stage("Prepare") {
            steps {
                println("Preparing...")

                script {
                    // Load local script from current directory and store reference to `common`
                    common = load "common.groovy"
                    common.loadSharedLibrary()
                }
            }
        }

        stage("Test log from library") { 
            steps { 
                // Methods from scripts must be declared in `script` directive
                script { 
                    log.info 'Starting'
                }
                script { 
                    log.warning 'Nothing to do!'
                }
            }
        }

        stage("Welcome") { 
            steps {
                // Whole script can be called outside script directive
                welcomeJob 'VASYAAA'
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
