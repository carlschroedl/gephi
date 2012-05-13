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
    
    //ugly fix
    private static SpanningTreeAlgorithm stAlg;
    
    
    
    @Override
    public String getName() {
        return "Spanning Tree";
    }

    @Override
    public Statistics getStatistics() {
        return new SpanningTree(SpanningTreeBuilder.stAlg);
    }
    
    @Override
    public Class<? extends Statistics> getStatisticsClass() {
        return SpanningTree.class;
    }

    /**
     * @return the stAlg
     */
    public static SpanningTreeAlgorithm getSpanningTreeAlgorithm() {
        return stAlg;
    }

    /**
     * @param stAlg the stAlg to set
     */
    public static void setSpanningTreeAlgorithm(SpanningTreeAlgorithm stAlg) {
        SpanningTreeBuilder.stAlg = stAlg;
    }

}
