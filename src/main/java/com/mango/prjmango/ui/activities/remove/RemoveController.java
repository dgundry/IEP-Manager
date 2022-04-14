package com.mango.prjmango.ui.activities.remove;

import com.mango.prjmango.Main;
import com.mango.prjmango.Outlines.MathOutline;
import com.mango.prjmango.Outlines.MathOutlines;
import com.mango.prjmango.Outlines.Outline;
import com.mango.prjmango.Outlines.Outlines;
import com.mango.prjmango.assignment.Assignment;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.ui.dialogs.confirmation.Dialogs;
import com.mango.prjmango.ui.students.view.reports.ReportsController;
import com.mango.prjmango.ui.students.view.reports.ReportsView;
import com.mango.prjmango.utilities.DatabaseCommands;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

public class RemoveController {
    private RemoveView view;
    public RemoveController(RemoveView view) {
        this.view = view;
        populateTable(view, Main.getOutlines().getOutlines(), Main.getMathOutlines().getOutlines());
    }
    private static void populateTable(RemoveView view, List<Outline> outlines, List<MathOutline> mathOutlines) {
        for(Outline outline : outlines) {
                view.getModel().addRow(new Object[]{
                        outline.getAssignmentID(),
                        "Upload",
                        outline.getAssignmentName()});
        }
        for(MathOutline outline : mathOutlines) {
            view.getModel().addRow(new Object[]{
                    outline.getAssignmentID(),
                    "Math",
                    outline.getAssignmentName()});
        }
        view.getOutlinesTable().getColumn("Delete").setCellRenderer(new DeleteButtonRenderer());
        view.getOutlinesTable().getColumn("Delete").setCellEditor(new DeleteButtonEditor(view, new JCheckBox()));
    }
    private static class DeleteButtonRenderer extends DefaultTableCellRenderer {
        JLabel label = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            label = new JLabel(ImageIcons.DELETE_TRASH.getImageIcon());
            return label;
        }
    }

    private static class DeleteButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private final RemoveView view;

        public DeleteButtonEditor(RemoveView view, JCheckBox checkBox) {
            super(checkBox);
            this.view = view;
            button = new JButton();
            button.setOpaque(false);
            button.setBackground(null);
            button.setBorder(null);
            button.setContentAreaFilled(false);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if(isSelected){
//                System.out.println("Selected");

            }else{
//                System.out.println("Not Selected");
            }
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                String type = view.getModel().getValueAt(view.getOutlinesTable().getSelectedRow(), 1).toString();
                int outline_id = (int) view.getModel().getValueAt(view.getOutlinesTable().getSelectedRow(), 0);
                if(type.equals("Upload")) {
                    DatabaseCommands.deleteOutline(outline_id);
                    Main.setOutlines(new Outlines(Main.getActiveUser().getTeacherId()));
                }else if(type.equals("Math")) {
                    DatabaseCommands.deleteMathOutline(outline_id);
                    Main.setMathOutlines(new MathOutlines(Main.getActiveUser().getTeacherId()));
                }
                RemoveView view = new RemoveView();
                new RemoveController(view);
                ActivitiesView.setActiveDisplay(view);
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }
}
