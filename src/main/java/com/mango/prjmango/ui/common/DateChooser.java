package com.mango.prjmango.ui.common;

import java.time.LocalDate;
import java.util.Arrays;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import lombok.Getter;

public class DateChooser extends JPanel {
    @Getter private JComboBox<String> dayComboBox;
    @Getter private JComboBox<String> monthComboBox;
    @Getter private JComboBox<String> yearComboBox;

    public DateChooser(int day, int month, int year){
        setOpaque(false);

        createComponents();
        createLayout();
        setTodaysDates();
    }
    public void setDates(int dayIndex, int monthIndex, int yearIndex){
        dayComboBox.setSelectedIndex(dayIndex);
        monthComboBox.setSelectedIndex(monthIndex);
        yearComboBox.setSelectedIndex(yearIndex);
    }
    private void setTodaysDates(){
        LocalDate today = LocalDate.now();
        dayComboBox.setSelectedIndex(today.getDayOfMonth()-1);
        monthComboBox.setSelectedIndex(today.getMonth().getValue()-1);
        int calculatedYearIndex = today.getYear() - 2022;
        yearComboBox.setSelectedIndex(calculatedYearIndex);
    }
    private void createComponents(){
        String[] days = new String[] {"1","2","3","4","5","6","7","8","9","10",
                                    "11","12","13","14","15","16","17","18","19","20",
                                    "21","22","23","24","25","26","27","28","29","30","31"};
        dayComboBox = Components.JComboBox(Arrays.asList(days));
        dayComboBox.setEnabled(true);
        dayComboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        dayComboBox.setBackground(Colors.DARK_GREY);
        dayComboBox.setForeground(Colors.LIGHT_GREY);

        String[] months = new String[] {"January",
                                        "February",
                                         "March",
                                         "April",
                                         "May",
                                         "June",
                                         "July",
                                         "August",
                                         "September",
                                         "October",
                                         "November",
                                         "December"};
        monthComboBox = Components.JComboBox(Arrays.asList(months));
        monthComboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        monthComboBox.setBackground(Colors.DARK_GREY);
        monthComboBox.setForeground(Colors.LIGHT_GREY);

        String[] years = new String[] {"2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035"};
        yearComboBox = Components.JComboBox(Arrays.asList(years));
        yearComboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        yearComboBox.setBackground(Colors.DARK_GREY);
        yearComboBox.setForeground(Colors.LIGHT_GREY);
    }
    private void createLayout(){
        GroupLayout dateChooserLayout = new GroupLayout(this);
        setLayout(dateChooserLayout);
        dateChooserLayout.setHorizontalGroup(
                dateChooserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, dateChooserLayout.createSequentialGroup()
                                .addComponent(monthComboBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dayComboBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yearComboBox)));
        dateChooserLayout.setVerticalGroup(
                dateChooserLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(dateChooserLayout.createSequentialGroup()
                                .addGroup(dateChooserLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(monthComboBox)
                                        .addComponent(dayComboBox)
                                        .addComponent(yearComboBox))));
    }
    public String getText(){
        String tempMonth;
        String tempDay;
        if((monthComboBox.getSelectedIndex()+1) >= 10){
            tempMonth = ""+ (monthComboBox.getSelectedIndex()+1) ;
        }else{
            tempMonth = "0" + (monthComboBox.getSelectedIndex()+1);
        }
        if((dayComboBox.getSelectedIndex()+1) >= 10){
            tempDay = ""+ (dayComboBox.getSelectedIndex()+1) ;
        }else{
            tempDay = "0" + (dayComboBox.getSelectedIndex()+1);
        }

        return yearComboBox.getSelectedItem().toString() + "-" + tempMonth + "-" + tempDay;
    }
}
