package com.mango.prjmango.ui.students.view;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Fonts;
import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewStudentView extends JPanel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    private JLabel studentsHeaderLabel;
    private JLabel searchLabel;

    private JTextField searchTextBox;

    private final JScrollPane studentsScrollPane = new JScrollPane();
    private final JTable studentTable = new JTable();

    @Getter
    private DefaultTableModel model;

    public ViewStudentView() {
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents(){
        studentsHeaderLabel     = createLabel("Students", 24);
        searchLabel             = createLabel("Search", 18);
        searchTextBox           = createTextField("");



        model = new DefaultTableModel(new Object[][]{}, new String[] { "Student ID", "First Name", "Last Name", "Grade", "Bio" });
        studentTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 45, 22), 1, true));
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
        studentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        studentTable.setCellSelectionEnabled(true);
        studentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);


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

    private void createLayout(){
        GroupLayout addAssignmentPanelLayout = new GroupLayout(this);
        setLayout(addAssignmentPanelLayout);
        addAssignmentPanelLayout.setHorizontalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
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
                addAssignmentPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(studentsHeaderLabel)
                        .addGap(49, 49, 49)
                        .addComponent(searchLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studentsScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(850, Short.MAX_VALUE)
                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING))
        );

    }
    private JTextField createTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setMargin(new Insets(0, 5, 0, 5));
        textField.setBackground(DARK_GREY);
        textField.setForeground(LIGHT_GREY);
        textField.setCaretColor(LIGHT_GREY);
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        return textField;
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setForeground(LIGHT_GREY);
        return label;
    }
}
