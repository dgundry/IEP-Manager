package com.mango.prjmango.windows.activities.fry.assignment;

import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.Components;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

public class FryAssignmentView extends JPanel {

    private JLabel sightWordHeaderLabel;
    private JLabel wordLabel;
    private JLabel numberWordLabel;

    @Getter private JLabel incorrectLabel;
    @Getter private JLabel correctLabel;

    private final String SIGHT_WORD_SELECTION;

    public FryAssignmentView(String sightWordSelection) {
        this.SIGHT_WORD_SELECTION = sightWordSelection;

        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        sightWordHeaderLabel = Components.JLabel(
                SIGHT_WORD_SELECTION,
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        numberWordLabel = Components.JLabel(
                "1/100",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        wordLabel = Components.JLabel(
                "First word",
                Fonts.SEGOE_UI_70.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);

        correctLabel   = new JLabel(ImageIcons.FRY_ASSIGNMENT_CORRECT_NO_HOVER.getImageIcon());
        incorrectLabel = new JLabel(ImageIcons.FRY_ASSIGNMENT_INCORRECT_NO_HOVER.getImageIcon());
    }

    private void createLayout() {
        GroupLayout sightWordAssignmentPanelLayout = new GroupLayout(this);
        setLayout(sightWordAssignmentPanelLayout);
        sightWordAssignmentPanelLayout.setHorizontalGroup(
                sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(correctLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(incorrectLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addGap(161, 161, 161))
                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                                .addGap(123, 123, 123)
                                                .addComponent(wordLabel, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(numberWordLabel)))
                                .addContainerGap(133, Short.MAX_VALUE))
                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(sightWordHeaderLabel)
                                        .addContainerGap(421, Short.MAX_VALUE)))
        );
        sightWordAssignmentPanelLayout.setVerticalGroup(
                sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(numberWordLabel)
                                .addGap(101, 101, 101)
                                .addComponent(wordLabel)
                                .addGap(90, 90, 90)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(correctLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(incorrectLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(1305, Short.MAX_VALUE))
                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(sightWordHeaderLabel)
                                        .addContainerGap(1510, Short.MAX_VALUE)))
        );
    }
}
