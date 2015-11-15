package net.elenx;

import com.vaadin.server.FontIcon;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import org.vaadin.teemu.VaadinIcons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuButtons {

    public List<Button> menuButtons() {
        Map<String, FontIcon> buttons = new HashMap<>();
        List<Button> menuButtons = new ArrayList<>();
        buttons.put("Strona główna", VaadinIcons.MENU);
        buttons.put("Plan zajęć", VaadinIcons.OPEN_BOOK);
        buttons.put("Oceny", VaadinIcons.BELL);
        buttons.put("Dydaktyka", VaadinIcons.LAPTOP);
        buttons.put("Materiały", VaadinIcons.FACEBOOK);
        for (String caption : buttons.keySet()) {
            menuButtons.add(menuButton(caption, buttons.get(caption)));
        }
        return menuButtons;
    }

    public Button menuButton(String caption, FontIcon icon) {
        Button button = new Button();
        button.setIcon(icon);
        button.setCaption(caption);
        button.setWidth(250, Sizeable.Unit.PIXELS);
        button.addStyleName("sidebar-button");
        return button;
    }
}
