package net.elenx.modules;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sidebar {

    private VerticalLayout sidebar = createSidebar();

    public VerticalLayout getSidebar() {
        return sidebar;
    }

    //Create Sidebar
    public VerticalLayout createSidebar() {
        VerticalLayout sidebar = new VerticalLayout();
        List<Button> menuButtons = createMenuButtons();
        VerticalLayout filler = createFiller();
        sidebar.setWidth(250, Sizeable.Unit.PIXELS);
        sidebar.setHeight("100%");
        sidebar.setMargin(false);
        sidebar.setSpacing(false);
        for (Button button : menuButtons) {
            sidebar.addComponent(button);
            sidebar.setComponentAlignment(button, Alignment.TOP_LEFT);
        }
        sidebar.addComponent(filler);
        sidebar.setExpandRatio(filler, 1.0f);
        sidebar.addStyleName("sidebar");
        return sidebar;
    }

    //Create side menu buttons
    public List<Button> createMenuButtons() {
        HashMap<String, Button> buttons = new HashMap<>();
        List<Button> menuButtons = new ArrayList<>();
        buttons.put("Strona główna", new Button());
        buttons.put("Plan zajęć", new Button());
        buttons.put("Oceny", new Button());
        buttons.put("Dydaktyka", new Button());
        buttons.put("Materiały", new Button());
        for (String caption : buttons.keySet()) {
            menuButtons.add(createMenuButton(caption, buttons.get(caption)));
        }
        return menuButtons;
    }

    //Create single menu button
    public Button createMenuButton(String caption, Button button) {
        button.setCaption(caption);
        button.setWidth(250, Sizeable.Unit.PIXELS);
        button.addStyleName("sidebar-button");
        return button;
    }

    //Create transparent filler that fix another components placement
    public VerticalLayout createFiller() {
        VerticalLayout filler = new VerticalLayout();
        filler.setHeightUndefined();
        return filler;
    }
}
