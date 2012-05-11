/*
 * Your license here
 */

package org.gephi.statistics.spanningtrees;

import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.statistics.spi.Statistics;
import org.gephi.utils.longtask.spi.LongTask;
import org.gephi.utils.progress.Progress;
import org.gephi.utils.progress.ProgressTicket;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_Statistics
 * 
 * @author Your Name <your.name@your.company.com>
 */
public class SpanningTrees implements Statistics, LongTask {

    private boolean cancel = false;
    private ProgressTicket progressTicket;

    private boolean directed;

    @Override
    public void execute(GraphModel graphModel, AttributeModel attributeModel) {
        Graph graph = graphModel.getGraphVisible();
        graph.readLock();

        //Your algorithm
        //See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Implementation_help
        try {
            Progress.start(progressTicket, graph.getNodeCount());

            for (Node n : graph.getNodes()) {
                //do something
                Progress.progress(progressTicket);
                if (cancel) {
                    break;
                }
            }
            graph.readUnlockAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Unlock graph
            graph.readUnlockAll();
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
    public String getReport() {
        //Write the report HTML string here
        String report = "The result is 42. ;)";

        return report;
    }

    @Override
    public boolean cancel() {
        cancel = true;
        return true;
    }

    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        this.progressTicket = progressTicket;
    }
}
