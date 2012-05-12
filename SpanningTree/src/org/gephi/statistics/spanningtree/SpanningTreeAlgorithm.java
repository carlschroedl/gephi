package org.gephi.statistics.spanningtree;

import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.Graph;

/**
 *
 * @author Carl Schroedl <carlschroedl@gmail.com>
 */
public abstract class SpanningTreeAlgorithm {
              
    public abstract void execute(Graph graph, AttributeModel attributeModel);
    public abstract JPanel getOptions();

    
    //These 2 methods return the name shown to the user in the interface:
    public abstract String getName();
    
    @Override
    public final String toString(){
        return this.getName();
    }
    
    
}
