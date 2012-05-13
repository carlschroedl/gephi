/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.statistics.spanningtree;

import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.data.attributes.api.AttributeOrigin;
import org.gephi.data.attributes.api.AttributeTable;
import org.gephi.data.attributes.api.AttributeType;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.utils.progress.Progress;
import org.gephi.utils.progress.ProgressTicket;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Carl Schroedl <carlschroedl@gmail.com>
 */
@ServiceProvider(service = SpanningTreeAlgorithm.class)
public class KruskalsAlgorithm extends SpanningTreeAlgorithm{

    private static final String name = "Kruskal's Algorithm";
    private ProgressTicket progressTicket;
    private boolean cancel;
    
    //<required methods>
    @Override
    public void execute(Graph graph, AttributeModel attributeModel) {
        //throw new UnsupportedOperationException("Not supported yet.");
        graph.writeLock();
        
        //See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Implementation_help
        
        AttributeTable nodeTable = attributeModel.getNodeTable();
        AttributeColumn inCol = nodeTable.getColumn("spanningtree");

        if (inCol == null) {
            inCol = nodeTable.addColumn("spanningtree", "Spanning Tree", AttributeType.INT, AttributeOrigin.COMPUTED, 0);

        }
        
        
        try {
            Progress.start(progressTicket, graph.getNodeCount());
            boolean one = false;
            for (Node n : graph.getNodes()) {
                //do something
                if(one){
                    n.getAttributes().setValue("spanningtree", 1);
                    
                }
                one = !one;
                Progress.progress(progressTicket);
                if (cancel) {
                    break;
                }
            }
                        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Unlock graph
            graph.writeUnlock();
        }
    }

    @Override
    public JPanel getOptions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean cancel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void execute(GraphModel graphModel, AttributeModel attributeModel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getReport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    
    
}
