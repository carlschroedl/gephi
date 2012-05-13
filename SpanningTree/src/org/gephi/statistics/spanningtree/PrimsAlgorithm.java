/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.statistics.spanningtree;

import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.utils.progress.ProgressTicket;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Carl Schroedl <carlschroedl@gmail.com>
 */
@ServiceProvider(service = SpanningTreeAlgorithm.class)
public class PrimsAlgorithm extends SpanningTreeAlgorithm{

    private static final String name = "Prim's Algorithm";
    
    @Override
    public void execute(Graph graph, AttributeModel attributeModel) {
        throw new UnsupportedOperationException("Not supported yet.");
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
