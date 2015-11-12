package net.elenx;

import com.vaadin.server.FontIcon;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.teemu.VaadinIcons;

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
        Button logOutButton = createLogOutButton();
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
        sidebar.addComponent(logOutButton);
        return sidebar;
    }

    //Create side menu buttons
    public List<Button> createMenuButtons() {
        HashMap<String, FontIcon> buttons = new HashMap<>();
        List<Button> menuButtons = new ArrayList<>();
        buttons.put("Strona główna", VaadinIcons.MENU);
        buttons.put("Plan zajęć", VaadinIcons.OPEN_BOOK);
        buttons.put("Oceny", VaadinIcons.BELL);
        buttons.put("Dydaktyka", VaadinIcons.LAPTOP);
        buttons.put("Materiały", VaadinIcons.FACEBOOK);
        for (String caption : buttons.keySet()) {
            menuButtons.add(createMenuButton(caption, buttons.get(caption)));
        }
        return menuButtons;
    }

    //Create single menu button
    public Button createMenuButton(String caption, com.vaadin.server.FontIcon icon) {
        Button button = new Button();
        button.setIcon(icon);
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

    public Button createLogOutButton() {
        Button logOutButton = new Button();
        logOutButton.setIcon(VaadinIcons.SIGN_OUT);
        logOutButton.setCaption("Wyloguj");
        logOutButton.setWidth(250, Sizeable.Unit.PIXELS);
        logOutButton.addStyleName("logout-button");
        return logOutButton;
    }
}
