def build() { 
    println("Building the application...")
}

def test() { 
    println("Testing the application...")
}

def deploy() { 
    println("Deploying the application...")
    println("Deploying version ${params.VERSION}")
}

def declareCommonEnvVariables() { 
    TEST_ENV_VARIABLE = "Some test environment variable..."
}

def loadSharedLibrary() { 
    library identifier: 'custom-lib@main',retriever: modernSCM(
        github(traits: [
        gitHubBranchDiscovery(1),
        gitHubPullRequestDiscovery(1), 
        gitHubForkDiscovery(strategyId: 1, trust: gitHubTrustPermissions())
    ], repository: 'jenkins_test_shared', repoOwner: 'morarivasile'))   
}

return this
