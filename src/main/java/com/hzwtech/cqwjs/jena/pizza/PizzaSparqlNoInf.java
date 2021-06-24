package com.hzwtech.cqwjs.jena.pizza;

import com.hzwtech.cqwjs.jena.JenaBase;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/24
 * @since v1.0
 */
public class PizzaSparqlNoInf extends JenaBase {
    public static final String SOURCE = "./src/main/resources/jena/data/";
    // Pizza ontology namespace
    public static final String PIZZA_NS = "http://www.co-ode.org/ontologies/pizza/pizza.owl#";

    public static void main(String[] args) {
        new PizzaSparqlNoInf().setArgs(args).run();
    }

    @Override
    public void run() {
        OntModel m = getModel();
        loadData( m );
        String prefix = "prefix pizza: <" + PIZZA_NS + ">\n" +
                "prefix rdfs: <" + RDFS.getURI() + ">\n" +
                "prefix owl: <" + OWL.getURI() + ">\n";


        showQuery( m,
                prefix +
                        "select ?pizza where {?pizza a owl:Class ; " +
                        "                            rdfs:subClassOf ?restriction.\n" +
                        "                     ?restriction owl:onProperty pizza:hasTopping ;" +
                        "                            owl:someValuesFrom pizza:PeperoniSausageTopping" +
                        "}" );
    }

    protected OntModel getModel() {
        return ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
    }

    protected void loadData(Model m) {
        FileManager.get().readModel(m, SOURCE + "pizza.owl.rdf");
    }

    protected void showQuery(Model m, String q) {
        Query query = QueryFactory.create(q);
        QueryExecution qexec = QueryExecutionFactory.create(query, m);
        try {
            ResultSet results = qexec.execSelect();
            ResultSetFormatter.out(results, m);
        } finally {
            qexec.close();
        }
    }
}
