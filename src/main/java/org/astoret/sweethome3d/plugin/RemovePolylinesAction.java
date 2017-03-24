package org.astoret.sweethome3d.plugin;

import java.net.URL;

import javax.swing.JOptionPane;

import com.eteks.sweethome3d.model.Content;
import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.Polyline;
import com.eteks.sweethome3d.plugin.PluginAction;
import com.eteks.sweethome3d.tools.URLContent;

public class RemovePolylinesAction extends PluginAction {

    private static final String DEL_PNG = "org/astoret/sweethome3d/plugin/resources/del.png";
    private Home home;

    public RemovePolylinesAction(Home home) {
        this.home = home;
        URL url = getClass().getClassLoader().getResource(DEL_PNG);
        Content content = new URLContent(url);
        putPropertyValue(Property.SMALL_ICON, content);
        putPropertyValue(Property.NAME, "Remove Polylines");
        putPropertyValue(Property.MENU, "Tools");
        putPropertyValue(Property.TOOL_BAR, Boolean.TRUE);
        
        // Enables the action by default
        setEnabled(true);
     }

    @Override
    public void execute() {
        int option = JOptionPane.showConfirmDialog(null, "Remove All Polylines?");
        if (option == JOptionPane.YES_OPTION) {
            for (Polyline polyline : home.getPolylines()) {
                home.deletePolyline(polyline);
            }
        }
    }

}
