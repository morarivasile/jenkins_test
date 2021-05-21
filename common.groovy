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

return this