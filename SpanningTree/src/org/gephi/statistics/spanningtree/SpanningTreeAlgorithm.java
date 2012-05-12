package org.gephi.statistics.spanningtree;

import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.GraphModel;

/**
 *
 * @author carlschroedl@gmail.com
 */
public interface SpanningTreeAlgorithm {
    public void execute(GraphModel graphModel, AttributeModel attributeModel);
    public JPanel getOptions();
}
