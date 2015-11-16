package net.elenx.modules.sidebar;

import com.vaadin.server.FontIcon;
import com.vaadin.ui.Button;

public class MenuButtonModel extends MenuButtons {

    private FontIcon icon;
    private Button.ClickListener listener;

    public MenuButtonModel(FontIcon icon, Button.ClickListener listener) {
        this.icon = icon;
        this.listener = listener;
    }

    public FontIcon getIcon() {
        return icon;
    }

    public Button.ClickListener getListener() {
        return listener;
    }
}
