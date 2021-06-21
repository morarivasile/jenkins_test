def call() { 
    library identifier: 'custom-lib@main',retriever: modernSCM(
        github(traits: [
        gitHubBranchDiscovery(1),
        gitHubPullRequestDiscovery(1), 
        gitHubForkDiscovery(strategyId: 1, trust: gitHubTrustPermissions())
    ], repository: 'jenkins_test_shared', repoOwner: 'morarivasile'))   
}
