/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.statistics.spanningtree;

import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.GraphModel;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author cschroedl
 */
@ServiceProvider(service = SpanningTreeAlgorithm.class)
public class KruskalsAlgorithm implements SpanningTreeAlgorithm{

    @Override
    public void execute(GraphModel graphModel, AttributeModel attributeModel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JPanel getOptions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
