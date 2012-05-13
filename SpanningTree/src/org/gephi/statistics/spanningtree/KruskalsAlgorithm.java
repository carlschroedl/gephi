/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.statistics.spanningtree;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.data.attributes.api.AttributeOrigin;
import org.gephi.data.attributes.api.AttributeTable;
import org.gephi.data.attributes.api.AttributeType;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.utils.progress.Progress;
import org.gephi.utils.progress.ProgressTicket;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Carl Schroedl <carlschroedl@gmail.com>
 */
@ServiceProvider(service = SpanningTreeAlgorithm.class)
public class KruskalsAlgorithm extends SpanningTreeAlgorithm {

    private static final String name = "Kruskal's Algorithm";
    private ProgressTicket progressTicket;
    private boolean cancel;

    //<required methods>
    @Override
    public void execute(Graph graph, AttributeModel attributeModel) {
        //throw new UnsupportedOperationException("Not supported yet.");
        graph.writeLock();

        //See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Implementation_help

        AttributeTable nodeTable = attributeModel.getNodeTable();
        AttributeColumn inCol = nodeTable.getColumn("spanningtree");

        if (inCol == null) {
            inCol = nodeTable.addColumn("spanningtree", "Spanning Tree", AttributeType.INT, AttributeOrigin.COMPUTED, 0);

        }


        try {
            Progress.start(progressTicket, graph.getNodeCount());
            boolean one = false;
            for (Node n : graph.getNodes()) {
                //do something
                if (one) {
                    n.getAttributes().setValue("spanningtree", 1);

                }
                one = !one;
                Progress.progress(progressTicket);
                if (cancel) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Unlock graph
            graph.writeUnlock();
        }
    }

    @Override
    public JPanel getOptions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean cancel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void execute(GraphModel graphModel, AttributeModel attributeModel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getReport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class DisjointSet {

        private int rank;
        private DisjointSet parent;
        private String label = "";
        private final String ARROW = " ==> ";
        private Object value;
        private static final boolean DEBUG = false;

        DisjointSet(String label) {
            this.label = label;
            this.rank = 0;
            this.parent = this;
        }

        DisjointSet() {
            this.rank = 0;
            this.parent = this;
        }

        private DisjointSet find() {

            DisjointSet x = this;

            String dbg = label + " : " + x.rank + ARROW;

            while (x != x.parent) {
                x = x.parent;
                dbg += x.label + " : " + x.rank + ARROW;
            }
            if (DEBUG) {
                dbg = dbg.substring(0, dbg.length() - ARROW.length());
                System.out.println(dbg);
            }
            return x;
        }

        /*
         * <ACCESSORS AND MUTATORS>
         */
        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        public void setParent(DisjointSet parent) {
            this.parent = parent;
        }

        public DisjointSet getParent() {
            return parent;
        }
        /*
         * <ACCESSORS AND MUTATORS>
         */

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }//end private class

    private class Unionizer {

        public void union(DisjointSet x, DisjointSet y) {
            DisjointSet rootX = x.find();
            DisjointSet rootY = y.find();

            if (rootX == rootY) {
                //System.out.println("Warning: the two sets already have the same root");
                return;
            } else if (rootX.rank > rootY.rank) {
                rootY.parent = rootX;
            } else {
                rootX.parent = rootY;
                if (rootX.rank == rootY.rank) {
                    ++rootY.rank;
                }
            }

        }//end method
    }

    private class KNode {

        private ArrayList<KEdge> edges = new ArrayList<KEdge>();
        private String label = "";
        private DisjointSet djsPointer;

        KNode() {
            this("", null);
        }

        KNode(String label, DisjointSet djsPointer) {
            this.label = label;
            this.djsPointer = djsPointer;
        }

        public void addKEdge(KEdge e) {
            edges.add(e);
        }

        public String toString() {
            return this.label;
        }

        public void setDjsPointer(DisjointSet djsPointer) {
            this.djsPointer = djsPointer;
        }

        public DisjointSet getDjsPointer() {
            return djsPointer;
        }
    }

    private class KEdge implements Comparable {

        private KNode srcKNode;
        private KNode destKNode;
        private int weight;

        KEdge(KNode srcKNode, KNode destKNode, int weight) {
            this.srcKNode = srcKNode;
            this.destKNode = destKNode;
            this.weight = weight;
        }

        KEdge(KNode srcKNode, KNode destKNode) {
            this(srcKNode, destKNode, 1);
        }

        public int compareTo(Object obj) {
            if (obj instanceof KEdge) {
                KEdge otherKEdge = (KEdge) obj;
                return this.weight - otherKEdge.weight;
            } else {
                System.out.println("Sorry, you supplied a non edge object");
                return 0;
            }

        }

        public String toString() {
            return "[" + this.srcKNode.toString()
                    + "]<====" + this.weight
                    + "====>[" + this.destKNode.toString()
                    + "]";

        }
        /*
         * <ACCESSORS AND MUTATORS>
         */

        public void setSrcKNode(KNode srcKNode) {
            this.srcKNode = srcKNode;
        }

        public KNode getSrcKNode() {
            return srcKNode;
        }

        public void setDestKNode(KNode destKNode) {
            this.destKNode = destKNode;
        }

        public KNode getDestKNode() {
            return destKNode;
        }

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
        /*
         * </ACCESSORS AND MUTATORS>
         */
    }

    private class KGraph {

        ArrayList<KNode> nodes = new ArrayList<KNode>();
        ArrayList<KEdge> edges = new ArrayList<KEdge>();

        KGraph() {
        }

        public void addNode(KNode node) {
            nodes.add(node);
        }

        public void addEdge(KEdge edge) {
            edges.add(edge);
        }

        public ArrayList<KNode> getNodes() {
            return this.nodes;
        }

        public ArrayList<KEdge> getEdges() {
            return this.edges;
        }

        public void setNodes(ArrayList<KNode> nodes) {
            this.nodes = nodes;
        }

        public void setEdges(ArrayList<KEdge> edges) {
            this.edges = edges;
        }
    }//end private class
}
