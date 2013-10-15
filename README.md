GShell or Groovy Shell
======

##About
Small tool which allows to execute groovy script from command line. GShell is based on Groovy CLI which 
allows specify script options in a just few steps and provide friendly way to interact with script end client.

##Usage
Start plaing with creating hello world script. File should ends with ___....shell.groovy___  so name for Hellow
World example will be ___helloworld.shell.groovy___. Place it in a script home folder (Note you should specify
script home folder by creating ___GSHELL_SCRIPT_HOME___ env variable which conatins path to it).

```java
[usage:{cli->
    cli.name(args:1, argName:'text','Specify your name')
},

execute:{options->
    println " Hello ${options.name}!"

}]

```
Script contains to part, which represents by closures. Usage closure - allows to specify script options which 
would be provided as console command arguments. Usage closure use groovy CliBuilder for declaring option type and 
usage. Find more on [CliBuidler home page](http://groovy.codehaus.org/Groovy+CLI).

Execute closure - allows to specify script body. You could access options provided by user in command line by using
options map. Find more on [CliBuidler home page](http://groovy.codehaus.org/Groovy+CLI).

In order to run script open concole ant type

```
java -jar gshell-{version}.jar helloworld --name mrjbee 

```
You simplify invoking by creating .sh (or .bat for Windows) file with follwoing text

```
#!/bin/bash
export GSHELL_SCRIPT_HOME="/home/mrjbee/WorkShop/Workspace/github/monroe-team-incubator/main/Scr$
java -jar gshell.jar $@
```
