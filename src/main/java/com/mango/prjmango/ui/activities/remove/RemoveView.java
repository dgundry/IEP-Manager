package com.mango.prjmango.ui.activities.remove;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;

public class RemoveView extends JPanel {
    @Getter private static JLabel outlineHeaderLabel;
    @Getter private final JTable outlinesTable = new JTable();
    @Getter private final JScrollPane outlinesScrollPane = new JScrollPane();
    @Getter private DefaultTableModel model;


    public RemoveView() {
        setOpaque(false);
        
        createComponents();
        createLayout();
    }
    private void createComponents(){
        outlineHeaderLabel = Components.JLabel("Your outlines", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        model = new DefaultTableModel(new Object[][]{}, new String[] { "Outline ID", "Type", "Assignment Name","Delete"});
        outlinesTable.setBorder(new LineBorder(new java.awt.Color(120, 45, 22), 1, true));
        outlinesTable.setModel(model);
        outlinesTable.setBackground(Colors.DARK_GREY);
        outlinesTable.setFont(Fonts.SEGOE_UI_16.getFont());
        outlinesTable.getTableHeader().setFont(Fonts.SEGOE_UI_18.getFont());
        outlinesTable.getTableHeader().setBackground(Colors.LIGHT_GREY);
        outlinesTable.getTableHeader().setForeground(Colors.DARK_GREY);
        outlinesTable.setForeground(Colors.LIGHT_GREY);
        outlinesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        outlinesTable.setIntercellSpacing(new Dimension(10, 0));
        outlinesTable.setGridColor(Colors.DARK_GREY);
        outlinesTable.setRowHeight(23);
        outlinesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        outlinesTable.setCellSelectionEnabled(true);
        outlinesTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        outlinesTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        outlinesTable.setDefaultEditor(Object.class, null);
        outlinesTable.removeColumn(outlinesTable.getColumnModel().getColumn(0));
        outlinesScrollPane.add(outlinesTable);
        outlinesScrollPane.setViewportView(outlinesTable);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        outlinesTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        outlinesTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
    }
    private void createLayout() {
        GroupLayout addAssignmentPanelLayout = new GroupLayout(this);
        setLayout(addAssignmentPanelLayout);
        addAssignmentPanelLayout.setHorizontalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, addAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(outlineHeaderLabel)
                                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                .addContainerGap())
                                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(outlinesScrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)))))
                                )));
        addAssignmentPanelLayout.setVerticalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(outlineHeaderLabel)
                                .addGap(67, 67, 67)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGap(18, 18, 18)
                                .addComponent(outlinesScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(850, Short.MAX_VALUE)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)))
        );

    }
}
