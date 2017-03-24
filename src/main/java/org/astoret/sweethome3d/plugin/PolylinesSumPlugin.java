package org.astoret.sweethome3d.plugin;

import com.eteks.sweethome3d.plugin.Plugin;
import com.eteks.sweethome3d.plugin.PluginAction;

public class PolylinesSumPlugin extends Plugin {

    @Override
    public PluginAction[] getActions() {
        return new PluginAction [] {
                new SumAction(getHome(), getUserPreferences()), 
                new RemovePolylinesAction(getHome())};
    }
}