[
usage:{cli->
    cli.if(args:1, argName:'source input folder','Input folder to print out')	
},

execute:{options->
	if (!options.if){
		println "Please specify source file path"
		return
	}
	def inFile = new File(options.if)
	if (!inFile.exists()){
		println "Not exists"
		return
	}	
	inFile.list().each{
		println "--> $it"
	}	
	
}
]