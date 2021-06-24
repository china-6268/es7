package com.hzwtech.cqwjs.jena.helloworld;

import com.hzwtech.cqwjs.jena.CheeseBase;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/24
 * @since v1.0
 */
public class HelloWorld extends CheeseBase {
    public static void main(String[] args) {
        new HelloWorld().setArgs(args).run();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        // creates a new, empty in-memory model
        Model m = ModelFactory.createDefaultModel();

        // load some data into the model
        FileManager.get().readModel(m, CHEESE_DATA_FILE);

        // generate some output
        showModelSize(m);
        listCheeses(m);
    }

    protected void showModelSize(Model m) {
        System.out.println(String.format("The model contains %d triples", m.size()));
    }

    protected void listCheeses(Model m) {
        Resource cheeseClass = m.getResource(CHEESE_SCHEMA + "Cheese");

        StmtIterator i = m.listStatements(null, RDF.type, cheeseClass);

        while (i.hasNext()) {
            Resource cheese = i.next().getSubject();
            String label = getEnglishLabel(cheese);
            System.out.println(String.format("Cheese %s has name: %s", cheese.getURI(), label));
        }
    }

    protected String getEnglishLabel(Resource cheese) {
        StmtIterator i = cheese.listProperties(RDFS.label);
        while (i.hasNext()) {
            Literal l = i.next().getLiteral();

            if (l.getLanguage() != null && l.getLanguage().equals("en")) {
                // found the English language label
                return l.getLexicalForm();
            }
        }

        return "A Cheese with No Name!";
    }
}
