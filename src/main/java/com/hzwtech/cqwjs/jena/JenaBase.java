package com.hzwtech.cqwjs.jena;

import org.apache.commons.cli.*;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/24
 * @since v1.0
 */
public abstract class JenaBase implements Runnable {
    public static final String DATA_DIR = "./src/main/resources/jena/data/";
    public static final String ONTOLOGIES_DIR = "./src/main/resources/jena/ontologies/";
    private static Options options;
    private CommandLine commandLine;

    public static void addOption(String opt, String longOpt, boolean hasArg, String description) {
        if (JenaBase.options == null) {
            JenaBase.options = new Options();
        }
        options.addOption(opt, longOpt, hasArg, description);
    }

    public static Options getOptions() {
        if (JenaBase.options == null) {
            JenaBase.options = new Options();
        }
        return options;
    }

    public JenaBase setArgs(String[] args) {
        if (args == null) {
            args = new String[]{};
        }

        try {
            commandLine = new GnuParser().parse(JenaBase.getOptions(), args);
        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("", options);
            System.exit(1);
        }

        // allow method chaining
        return this;
    }

    public boolean hasArg(String opt) {
        if (commandLine == null) {
            System.err.println("Command line arguments have not been set yet. See setArgs( String[] args )");
            System.exit(1);
        }
        return commandLine.hasOption(opt);
    }
}
