/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabAssistantRole;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.renderer.category.BarRenderer3D;

/**
 *
 * @author vish1
 */
public class CustomRenderer extends BarRenderer3D {

    private Paint[] colors;
    public CustomRenderer(final Paint[] colors) {
        this.colors = colors;
    }

    public Paint getItemPaint(final int row, final int column) {
        if(column==0)
            return Color.RED;
        else if(column==1)
            return Color.BLUE;
        else if(column==2)
            return Color.GREEN;
        else if(column==3)
            return Color.RED;
        else if(column==4)
            return Color.BLUE;
        else if(column==5)
            return Color.GREEN;
        else if(column==6)
            return Color.RED;
        else if(column==7)
            return Color.BLUE;
        else  
            return Color.GREEN;
   }
}
