/*
 * Your license here
 */

package org.gephi.statistics.spanningtrees;

import javax.swing.JPanel;
import org.gephi.statistics.spi.Statistics;
import org.gephi.statistics.spi.StatisticsUI;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_StatisticsUI
 * 
 * @author Your Name <your.name@your.company.com>
 */
@ServiceProvider(service = StatisticsUI.class)
public class SpanningTreesUI implements StatisticsUI {

    private SpanningTreesPanel panel;
    private SpanningTrees myMetric;

    @Override
    public JPanel getSettingsPanel() {
        panel = new SpanningTreesPanel();
        return panel; //null if no panel exists
    }

    @Override
    public void setup(Statistics statistics) {
        this.myMetric = (SpanningTrees) statistics;
        if (panel != null) {
            panel.setDirected(myMetric.isDirected()); //Remove it if not useful
        }
    }

    @Override
    public void unsetup() {
        if (panel != null) {
            myMetric.setDirected(panel.isDirected()); //Remove it if not useful
        }
        panel = null;
    }

    @Override
    public Class<? extends Statistics> getStatisticsClass() {
        return SpanningTrees.class;
    }

    @Override
    public String getValue() {
        //Returns the result value on the front-end. 
        //If your metric doesn't have a single result value, return null.
        return null;
    }

    @Override
    public String getDisplayName() {
        return "Spanning Trees";
    }

    @Override
    public String getCategory() {
        //The category is just where you want your metric to be displayed: NODE, EDGE or NETWORK.
        //Choose between:
        //- StatisticsUI.CATEGORY_NODE_OVERVIEW
        //- StatisticsUI.CATEGORY_EDGE_OVERVIEW
        //- StatisticsUI.CATEGORY_NETWORK_OVERVIEW
        return StatisticsUI.CATEGORY_NETWORK_OVERVIEW;
    }

    @Override
    public int getPosition() {
        //The position control the order the metric front-end are displayed. 
        //Returns a value between 1 and 1000, that indicates the position. 
        //Less means upper.
        return 800;
    }

}
