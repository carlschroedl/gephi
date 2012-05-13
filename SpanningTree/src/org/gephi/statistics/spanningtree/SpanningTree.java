/*
 * Your license here
 */

package org.gephi.statistics.spanningtree;

import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.data.attributes.api.AttributeOrigin;
import org.gephi.data.attributes.api.AttributeTable;
import org.gephi.data.attributes.api.AttributeType;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphFactory;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.statistics.spi.Statistics;
import org.gephi.utils.longtask.spi.LongTask;
import org.gephi.utils.progress.Progress;
import org.gephi.utils.progress.ProgressTicket;
import org.openide.util.Lookup;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_Statistics
 *
 * @author Carl Schroedl <carlschroedl@gmail.com>
 */
public class SpanningTree implements Statistics, LongTask {

    private boolean cancel = false;
    private ProgressTicket progressTicket;
    private SpanningTreeAlgorithm stAlgorithm;
    
    private boolean directed;
    
    public SpanningTree(SpanningTreeAlgorithm stAlgorithm){
        this.stAlgorithm = stAlgorithm;
    }
    
    @Override
    //wrapper method for the UI only, selects the currently visible graph
    public void execute(GraphModel graphModel, AttributeModel attributeModel) {
        this.execute(graphModel.getGraphVisible(), attributeModel);
    }
    //a more general version of execute()
    public void execute(Graph graph, AttributeModel attributeModel){
        
        //Your algorithm
        if( null == stAlgorithm){
            throw new NullPointerException("No Spanning Tree Algorithm was set.");
        }
        else{
            stAlgorithm.execute(graph, attributeModel);
        }
        
    }
    /** Only useful if the algorithm takes graph type into account. */

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    /** ----------------------------------------------------------- */

    @Override
    public String getReport() { //delegate
        //Write the report HTML string here
        return stAlgorithm.getReport();
    }

    @Override   //delegate
    public boolean cancel() {
        return stAlgorithm.cancel();
    }

    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        this.progressTicket = progressTicket;
    }

    /**
     * @return the stAlgorithm
     */
    public SpanningTreeAlgorithm getStAlgorithm() {
        return stAlgorithm;
    }

    /**
     * @param stAlgorithm the stAlgorithm to set
     */
    public void setStAlgorithm(SpanningTreeAlgorithm stAlgorithm) {
        this.stAlgorithm = stAlgorithm;
    }
}
