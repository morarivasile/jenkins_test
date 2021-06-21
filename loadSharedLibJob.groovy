def call(String version = 'main') { 
    library identifier: "custom-lib@${version}",retriever: modernSCM(
        github(traits: [
        gitHubBranchDiscovery(1),
        gitHubPullRequestDiscovery(1), 
        gitHubForkDiscovery(strategyId: 1, trust: gitHubTrustPermissions())
    ], repository: 'jenkins_test_shared', repoOwner: 'morarivasile'))   
}

return this;
