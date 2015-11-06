package net.elenx;


import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.vaadin.teemu.VaadinIcons;

public class NavigationBarUI {

    private HorizontalLayout navbar;
    private Button hamburgerButton;
    private Label logo;

    //Create Navigation Bar
    public HorizontalLayout initNavigationBar() {
        navbar = new HorizontalLayout();
        navbar.setWidth("100%");
        navbar.setMargin(true);
        navbar.setHeight(50, Sizeable.Unit.PIXELS);
        navbar.addComponent(createHamburgerButton());
        navbar.addComponent(createLogo());
        return navbar;
    }

    //Create Hamburger Button
    public Button createHamburgerButton() {
        hamburgerButton = new Button();

        //Added some styling to hamburger button
        hamburgerButton.addStyleName("hamburger-button");
        hamburgerButton.setIcon(VaadinIcons.MENU);

        return hamburgerButton;
    }

    //Create ElenX logo
    public Label createLogo() {
        logo = new Label("ElenX");
        logo.addStyleName("elenx-logo");
        logo.setWidthUndefined();
        logo.setEnabled(false);
        return logo;
    }
}
