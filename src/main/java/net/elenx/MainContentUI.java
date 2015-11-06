package net.elenx;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Panel;

public class MainContentUI {

    private Panel mainContentPanel;

    //Create main panel for web content
    public Panel initMainPanel() {
        mainContentPanel = new Panel();
        mainContentPanel.setHeight(100, Sizeable.Unit.PERCENTAGE);
        return mainContentPanel;
    }
}
