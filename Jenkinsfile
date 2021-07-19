#!groovy

import org.notifications.*

def common
    
def myLib = library identifier: 'custom-lib@main',retriever: modernSCM(
        github(traits: [
        gitHubBranchDiscovery(1),
        gitHubPullRequestDiscovery(1), 
        gitHubForkDiscovery(strategyId: 1, trust: gitHubTrustPermissions())
    ], repository: 'jenkins_test_shared', repoOwner: 'morarivasile'))   

pipeline {
    agent any

    // Declare parameters here. Visually interactive in Jenkins UI
    parameters {
        choice(name: "VERSION", choices: ["1.1.0", "1.2.0", "1.3.0"], description: "")
        booleanParam(name: "executeTests", defaultValue: true, description: "")
    }

    stages {
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
                script { 
                    log.testFunctionHere("Vasile", true)   
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
