/*
 * Your license here
 */

package org.gephi.statistics.spanningtree;

import org.gephi.statistics.spi.Statistics;
import org.gephi.statistics.spi.StatisticsBuilder;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_StatisticsBuilder
 * 
 * @author Your Name <your.name@your.company.com>
 */
@ServiceProvider(service = StatisticsBuilder.class)
public class SpanningTreeBuilder implements StatisticsBuilder {

    @Override
    public String getName() {
        return "Spanning Tree";
    }

    @Override
    public Statistics getStatistics() {
        return new SpanningTree();
    }

    @Override
    public Class<? extends Statistics> getStatisticsClass() {
        return SpanningTree.class;
    }

}
