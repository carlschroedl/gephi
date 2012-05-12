/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.statistics.spanningtree;

import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.Graph;
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
    
}
