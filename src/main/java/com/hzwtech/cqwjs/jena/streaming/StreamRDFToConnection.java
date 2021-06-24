package com.hzwtech.cqwjs.jena.streaming;

import org.apache.jena.arq.querybuilder.UpdateBuilder;
import org.apache.jena.graph.Triple;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.TxnType;
import org.apache.jena.rdf.model.*;
import org.apache.jena.rdf.model.impl.StatementImpl;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.riot.system.StreamRDF;
import org.apache.jena.sparql.core.Quad;
import org.apache.jena.vocabulary.RDF;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jasper Liuzengyu 刘峻华
 * @version v1.0.0
 * @description
 * @date 2021/6/24
 * @since v1.0
 */
public class StreamRDFToConnection implements StreamRDF {
    private RDFConnection connection;
    private int bufferSize = 1000;
    private Set<Quad> quads = new HashSet<Quad>();
    private Model model = ModelFactory.createMemModelMaker().createFreshModel();

    public StreamRDFToConnection( RDFConnection connection ) {
        this.connection = connection;
    }
    public StreamRDFToConnection( RDFConnection connection, int bufferSize ) {
        this.connection = connection;
        this.bufferSize = bufferSize;
    }
    public static void main(String[] args){
        Dataset dataset = DatasetFactory.create();
        RDFConnection connection = RDFConnectionFactory.connect(dataset);
        StreamRDFToConnection stream = new StreamRDFToConnection( connection );

        Resource s = ResourceFactory.createResource( "s" );
        Property p = ResourceFactory.createProperty( "p" );
        RDFNode o = ResourceFactory.createPlainLiteral("OHHHH");
        Resource t = ResourceFactory.createResource( "t" );
        Resource g = ResourceFactory.createResource( "g" );
        Statement stmt1 = new StatementImpl( s, p ,o );
        Statement stmt2 = new StatementImpl( s, RDF.type, t );
        stream.start();
        stream.triple( stmt1.asTriple() );
        stream.quad( new Quad( g.asNode(), stmt2.asTriple()));
        stream.finish();

        System.out.println( "Contains model 'g': "+dataset.containsNamedModel("g") );
        Model m = dataset.getDefaultModel();
        System.out.println( "Default model contains <s,p,o>: "+	m.contains( stmt1 ));
        m = dataset.getNamedModel( "g" );
        System.out.println( "model 'g' contains <s,RDF.type,t>: "+	m.contains( stmt2 ));

    }
    private void isBufferFull() {
        if (model.size() + quads.size() >= bufferSize)
        {
            flush();
        }
    }
    private void flush() {
        UpdateBuilder builder = new UpdateBuilder();
        builder.addPrefixes( model );
        builder.addInsert( model );
        builder.addInsertQuads( quads );
        connection.begin( TxnType.WRITE );
        connection.update( builder.build() );
        connection.commit();
        model.removeAll();
        quads.clear();
    }
    /**
     * Start processing
     */
    @Override
    public void start() {

    }

    /**
     * Triple emitted
     *
     * @param triple
     */
    @Override
    public void triple(Triple triple) {
        model.add( model.asStatement(triple));
        isBufferFull();
    }

    /**
     * Quad emitted
     *
     * @param quad
     */
    @Override
    public void quad(Quad quad) {
        quads.add(quad);
        isBufferFull();
    }

    /**
     * base declaration seen
     *
     * @param base
     */
    @Override
    public void base(String base) {

    }

    /**
     * prefix declaration seen
     *
     * @param prefix
     * @param iri
     */
    @Override
    public void prefix(String prefix, String iri) {
        model.setNsPrefix(prefix, iri);
    }

    /**
     * Finish processing
     */
    @Override
    public void finish() {
        flush();
    }
}
