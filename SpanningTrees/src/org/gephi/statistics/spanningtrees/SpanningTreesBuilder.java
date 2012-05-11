/*
 * Your license here
 */

package org.gephi.statistics.spanningtrees;

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
public class SpanningTreesBuilder implements StatisticsBuilder {

    @Override
    public String getName() {
        return "Spanning Trees";
    }

    @Override
    public Statistics getStatistics() {
        return new SpanningTrees();
    }

    @Override
    public Class<? extends Statistics> getStatisticsClass() {
        return SpanningTrees.class;
    }

}
