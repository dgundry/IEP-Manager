package com.mango.prjmango.ui.students;

import com.mango.prjmango.ui.common.*;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReportsView extends JPanel {

    @Getter private static JLabel studentsHeaderLabel;
    @Getter private JLabel fromLabel;
    @Getter private JLabel toLabel;

    @Getter private JLabel nextButton = new JLabel(ImageIcons.NEXTSTUDENT.getImageIcon());
    @Getter private JLabel exportButton = new JLabel(ImageIcons.EXPORT.getImageIcon());

    @Getter private final JScrollPane studentsScrollPane = new JScrollPane();

    @Getter private final JTable assignmentsTable = new JTable();

    @Getter private DateChooser dateTextField1;
    @Getter private DateChooser dateTextField2;

    @Getter private DefaultTableModel model;

    private String fullName;

    public ReportsView(String fullName) {
        setOpaque(false);
        this.fullName = fullName;

        createComponents();
        createLayout();
    }

    private void createComponents(){
        studentsHeaderLabel = Components.JLabel(fullName+"", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        fromLabel = Components.JLabel("From:", Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        toLabel = Components.JLabel("To:", Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        dateTextField1 = new DateChooser(1,1,1);
        dateTextField2 = new DateChooser(1,1,1);


        model = new DefaultTableModel(new Object[][]{}, new String[] { "Assignment ID", "Title", "Earned Points", "Total Points", "Date", "Comments","Delete"});
        assignmentsTable.setBorder(new LineBorder(new java.awt.Color(120, 45, 22), 1, true));
        assignmentsTable.setModel(model);
        assignmentsTable.setBackground(Colors.DARK_GREY);
        assignmentsTable.setFont(Fonts.SEGOE_UI_16.getFont());
        assignmentsTable.getTableHeader().setFont(Fonts.SEGOE_UI_18.getFont());
        assignmentsTable.getTableHeader().setBackground(Colors.LIGHT_GREY);
        assignmentsTable.getTableHeader().setForeground(Colors.DARK_GREY);
        assignmentsTable.setForeground(Colors.LIGHT_GREY);
        assignmentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        assignmentsTable.setIntercellSpacing(new Dimension(10, 0));
        assignmentsTable.setGridColor(Colors.DARK_GREY);
        assignmentsTable.setRowHeight(23);
        assignmentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        assignmentsTable.setCellSelectionEnabled(true);
        assignmentsTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        assignmentsTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        assignmentsTable.setDefaultEditor(Object.class, null);
        assignmentsTable.removeColumn(assignmentsTable.getColumnModel().getColumn(0));
        studentsScrollPane.add(assignmentsTable);
        studentsScrollPane.setViewportView(assignmentsTable);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        assignmentsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        assignmentsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        assignmentsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        assignmentsTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        assignmentsTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
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
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(studentsScrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)))))
                                )));
        addAssignmentPanelLayout.setVerticalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(studentsHeaderLabel)
                                .addGap(67, 67, 67)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGap(18, 18, 18)
                                .addComponent(studentsScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(850, Short.MAX_VALUE)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)))
        );

    }
}

