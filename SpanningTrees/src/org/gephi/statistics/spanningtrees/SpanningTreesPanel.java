/*
 * Your license here
 *
 * If you don't need it, remove this file and edit MyMetricUI accordingly.
 */

package org.gephi.statistics.spanningtrees;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_StatisticsUI
 * @author Your Name <your.name@your.company.com>
 */
public class SpanningTreesPanel extends javax.swing.JPanel {

    /** Creates new form SpanningTreesPanel */
    public SpanningTreesPanel() {
        initComponents();
    }

    /** Add here setters and getters for all properties users can edit. */


    
    /** Only useful if the algorithm takes graph type into account. */
    
    public boolean isDirected() {
        return directedRadioButton.isSelected();
    }

    public void setDirected(boolean directed) {
        directedButtonGroup.setSelected(directed ? directedRadioButton.getModel() : undirectedRadioButton.getModel(), true);
    }

    /** ----------------------------------------------------------- */

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        directedButtonGroup = new javax.swing.ButtonGroup();
        header = new org.jdesktop.swingx.JXHeader();
        undirectedRadioButton = new javax.swing.JRadioButton();
        directedRadioButton = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(456, 218));

        header.setDescription(org.openide.util.NbBundle.getMessage(SpanningTreesPanel.class, "SpanningTreesPanel.header.description")); // NOI18N
        header.setTitle(org.openide.util.NbBundle.getMessage(SpanningTreesPanel.class, "SpanningTreesPanel.header.title")); // NOI18N

        directedButtonGroup.add(undirectedRadioButton);
        undirectedRadioButton.setText(org.openide.util.NbBundle.getMessage(SpanningTreesPanel.class, "SpanningTreesPanel.undirectedRadioButton.text")); // NOI18N

        directedButtonGroup.add(directedRadioButton);
        directedRadioButton.setText(org.openide.util.NbBundle.getMessage(SpanningTreesPanel.class, "SpanningTreesPanel.directedRadioButton.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(undirectedRadioButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(directedRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(358, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(directedRadioButton)
                .addGap(7, 7, 7)
                .addComponent(undirectedRadioButton)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup directedButtonGroup;
    protected javax.swing.JRadioButton directedRadioButton;
    private org.jdesktop.swingx.JXHeader header;
    protected javax.swing.JRadioButton undirectedRadioButton;
    // End of variables declaration//GEN-END:variables

}
