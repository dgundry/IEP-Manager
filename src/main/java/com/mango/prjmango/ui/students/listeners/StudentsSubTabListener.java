package com.mango.prjmango.ui.students.listeners;

import com.mango.prjmango.utilities.subtabs.StudentsSubTabs;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.students.StudentsView;
import com.mango.prjmango.ui.students.create.CreateStudentController;
import com.mango.prjmango.ui.students.create.CreateStudentView;
import com.mango.prjmango.ui.students.view.ViewStudentController;
import com.mango.prjmango.ui.students.view.ViewStudentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StudentsSubTabListener implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;
    private final ImageIcon selectedImage;

    private StudentsSubTabs studentsSubTab;

    public StudentsSubTabListener(
            JLabel label,
            ImageIcon noHoveredImage,
            ImageIcon hoveredImage,
            ImageIcon selectedImage,
            StudentsSubTabs studentsSubTab) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.selectedImage = selectedImage;
        this.studentsSubTab = studentsSubTab;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        StudentsView.previouslyActiveTab = StudentsView.currentlyActiveTab;
        StudentsView.currentlyActiveTab = studentsSubTab;
        resetLabelImages();
        label.setIcon(selectedImage);

        switch (StudentsView.currentlyActiveTab.ordinal()) {
            case 0:
                ViewStudentView viewStudentView = new ViewStudentView();
                new ViewStudentController(viewStudentView);
                StudentsView.setActiveDisplay(viewStudentView);
                break;
            case 1:
                CreateStudentView createStudentView = new CreateStudentView();
                new CreateStudentController(createStudentView);
                StudentsView.setActiveDisplay(createStudentView);
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (label.getIcon().equals(noHoveredImage)) {
            label.setIcon(hoveredImage);
        }

        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (label.getIcon().equals(hoveredImage)) {
            label.setIcon(noHoveredImage);
        }

        label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    private void resetLabelImages() {
        StudentsSubTabs previouslyActiveTab = StudentsView.previouslyActiveTab;
        switch (previouslyActiveTab.ordinal()) {
            case 0:
                StudentsView.getViewStudentsLabel().setIcon(ImageIcons.STUDENTS_VIEW_NO_HOVER.getImageIcon());
                break;
            case 1:
                StudentsView.getCreateStudentLabel().setIcon(ImageIcons.STUDENTS_CREATE_NO_HOVER.getImageIcon());
                break;
        }
    }
}
