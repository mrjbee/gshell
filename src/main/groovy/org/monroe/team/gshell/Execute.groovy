package org.monroe.team.gshell

/**
 * User: MisterJBee 
 * Date: 10/4/13 Time: 1:47 AM
 * Open source: MIT Licence 
 * (Do whatever you want with the source code)
 */
class Execute {

    private static final Execute execute = new Execute();
    private final String SCRIPT_HOME = System.getenv("GSHELL_SCRIPT_HOME")
    private final String USAGE_HELP =
"""
Groovy shell script runner. Usage:'gshell <Script Name> <Script Args>'

<Script Name> - script file name to execute without extention. Path to script
                will be taken from GSHELL_SCRIPT_HOME variable.

<Script Args> - Arguments with witch script shoud be runned. If EMPTY - script
                help will be displayed

(version 0.3)
"""

    static void main(String[] args){
        System.exit(execute.call(args))
    }

    int call(String[] args) {
        if (!args || args.length == 0){
          println(USAGE_HELP)
          println("Script home folder: ${SCRIPT_HOME}")
          return 1
        }
        def map = loadScript(args[0])
        CliBuilder cliBuilder = new CliBuilder(usage:"${args[0]} [options]",
                header:'Options:')
        map.usage.call(cliBuilder);
        if (args.length == 1){
           println()
           cliBuilder.usage();
           return 1
        } else {
           args = args.drop(1);
           def options = cliBuilder.parse(args)
           map.execute.call(options)
        }
        return 0
    }

    Map loadScript(String scriptName) {
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        Map answer = shell.evaluate(new File(SCRIPT_HOME,"${scriptName}.shell.groovy"));
    }


}
