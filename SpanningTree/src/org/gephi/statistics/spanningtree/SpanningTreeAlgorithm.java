package org.gephi.statistics.spanningtree;

import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.Graph;

/**
 *
 * @author carlschroedl@gmail.com
 */
public interface SpanningTreeAlgorithm {
    public void execute(Graph graph, AttributeModel attributeModel);
    public JPanel getOptions();
    
    @Override
    //Returns the name shown to the user in the drop-down interface
    public String toString();
}
