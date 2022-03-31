package com.mango.prjmango.ui.students.view;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;

public class ViewStudentView extends JPanel {

    private JLabel studentsHeaderLabel;
    private JLabel searchLabel;

    private JTextField searchTextBox;

    private final JScrollPane studentsScrollPane = new JScrollPane();
    @Getter private final JTable studentTable = new JTable();
    @Getter private JButton viewButton = new JButton("View");

    @Getter
    private DefaultTableModel model;

    public ViewStudentView() {
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents(){
        studentsHeaderLabel = Components.JLabel("Students", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        searchLabel         = Components.JLabel("Search",   Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);

        searchTextBox = Components.JTextField("");

        model = new DefaultTableModel(new Object[][]{}, new String[] { "Student ID", "First Name", "Last Name", "Grade", "Bio", "View" });
        studentTable.setBorder(new LineBorder(new java.awt.Color(120, 45, 22), 1, true));
        studentTable.setModel(model);
        studentTable.setBackground(Colors.DARK_GREY);
        studentTable.setFont(Fonts.SEGOE_UI_16.getFont());
        studentTable.getTableHeader().setFont(Fonts.SEGOE_UI_18.getFont());
        studentTable.getTableHeader().setBackground(Colors.LIGHT_GREY);
        studentTable.getTableHeader().setForeground(Colors.DARK_GREY);
        studentTable.setForeground(Colors.LIGHT_GREY);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.setIntercellSpacing(new Dimension(10, 0));
        studentTable.setGridColor(Colors.DARK_GREY);
        studentTable.setRowHeight(23);
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        studentTable.setCellSelectionEnabled(true);
        studentTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        studentTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        studentTable.setDefaultEditor(Object.class, null);

        studentsScrollPane.add(studentTable);
        studentsScrollPane.setViewportView(studentTable);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        studentTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        studentTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        studentTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        studentTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        studentTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
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
                                                        .addComponent(studentsHeaderLabel)
                                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(searchLabel))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())
                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                .addComponent(searchTextBox, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(studentsScrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)))))
        );
        addAssignmentPanelLayout.setVerticalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentsHeaderLabel)
                        .addGap(67, 67, 67)
                        .addComponent(searchLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studentsScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(850, Short.MAX_VALUE)
                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)))
        );

    }
}
