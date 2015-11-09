package net.elenx.modules;


import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.vaadin.teemu.VaadinIcons;

public class NavigationBar {

    private HorizontalLayout navigationBar = createNavigationBar();

    public HorizontalLayout getNavigationBar() {
        return navigationBar;
    }

    //Create Navigation Bar
    public HorizontalLayout createNavigationBar() {
        HorizontalLayout navbar = new HorizontalLayout();
        Button hamburgerButton = createHamburgerButton();
        Label logo = createLogo();
        navbar.setWidth("100%");
        navbar.setMargin(true);
        navbar.setHeight(50, Sizeable.Unit.PIXELS);
        navbar.addComponent(hamburgerButton);
        navbar.addComponent(logo);
        navbar.addStyleName("navigation-bar");
        return navbar;
    }

    //Create Hamburger Button
    public Button createHamburgerButton() {
        Button hamburgerButton = new Button();
        hamburgerButton.addStyleName("hamburger-button");
        hamburgerButton.setIcon(VaadinIcons.MENU);
        return hamburgerButton;
    }

    //Create ElenX logo
    public Label createLogo() {
        Label logo = new Label("ElenX");
        logo.addStyleName("elenx-logo");
        logo.setWidthUndefined();
        logo.setEnabled(false);
        return logo;
    }
}
