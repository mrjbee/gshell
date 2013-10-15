[
usage:{cli->
    cli.if(args:1, argName:'source file path','Specify path to xml')
	cli.name(args:1, argName:'text','Specify your name')
},

execute:{options->
	
	println " Hello ${options.name}!"

    if (!options.if){
		println "Please specify source file path"
		return
	}
	def inFile = new File(options.if)
	if (!inFile.exists()){
		println "'$inFile' not exists"
		return
	}	
	println """
File $inFile. 
Content = {
${inFile.getText()}
}
"""
}
]