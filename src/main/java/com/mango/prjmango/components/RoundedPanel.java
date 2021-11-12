package com.mango.prjmango.components;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RoundedPanel extends JPanel {

    protected int strokeSize = 1;
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 150;

    protected boolean shady = true;
    protected boolean highQuality = true;

    protected Color shadowColor = Color.black;

    protected Dimension arcs = new Dimension(150, 150);

    /**
     * Creates a JPanel with rounded edges.
     * @see <a href="https://www.codeproject.com/Articles/114959/Rounded-Border-JPanel-JPanel-graphics-improvements">
     *          https://www.codeproject.com/Articles/114959/Rounded-Border-JPanel-JPanel-graphics-improvements</a>
     * @see <a href="https://stackoverflow.com/questions/14364291/jpanel-gradient-background">
     *          https://stackoverflow.com/questions/14364291/jpanel-gradient-background</a>
     */
    public RoundedPanel() {
        super();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height  = getHeight();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(),
                shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;

        //Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Draws shadow borders if any.
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }

        //Draws the rounded opaque panel with borders.
        int w = getWidth();
        int h = getHeight();
        Color color2 = new Color(186,85,3);
        Color color1 = new Color(47,79,78);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        graphics.setPaint(gp);
        graphics.fillRoundRect(0, 0, w - shadowGap, h - shadowGap, arcs.width, arcs.height);

        graphics.fillRoundRect(0, 0, width - shadowGap,
                height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap,
                height - shadowGap, arcs.width, arcs.height);

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
}
