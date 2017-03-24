package org.astoret.sweethome3d.plugin;

import java.net.URL;

import javax.swing.JOptionPane;

import com.eteks.sweethome3d.model.Content;
import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.Polyline;
import com.eteks.sweethome3d.model.Polyline.DashStyle;
import com.eteks.sweethome3d.model.UserPreferences;
import com.eteks.sweethome3d.plugin.PluginAction;
import com.eteks.sweethome3d.tools.URLContent;

public class SumAction extends PluginAction {

    private Home home;
    private UserPreferences userPreferences;
 
    public SumAction(Home home, UserPreferences userPreferences) {
        this.home = home;
        this.userPreferences = userPreferences;

        URL url = getClass().getClassLoader().getResource("org/astoret/sweethome3d/plugin/resources/sum.png");
        Content content = new URLContent(url);
        putPropertyValue(Property.SMALL_ICON, content);
        putPropertyValue(Property.NAME, "Polyline's Length");
        putPropertyValue(Property.MENU, "Tools");
        putPropertyValue(Property.TOOL_BAR, Boolean.TRUE);
        setEnabled(true);
     }

    @Override
    public void execute() {
        int length = 0;
        for (Polyline polyline : home.getPolylines()) {
            polyline.setDashStyle(DashStyle.DASH);
            polyline.setThickness(3);
            polyline.setColor(0xFF0000);
            home.deselectItem(polyline);
            length += polyline.getLength();
        }
        JOptionPane.showMessageDialog(null, "Sum of Polyline's Length: " + String.valueOf(length)
            + " " + userPreferences.getLengthUnit().getName());

    }
}
