package net.elenx.modules.sidebar;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.vaadin.teemu.VaadinIcons;

import java.util.List;

public class Sidebar {

    @Bean(name = "sidebar")
    VerticalLayout sidebar(@Qualifier("sidebarFiller") VerticalLayout sidebarFiller, @Qualifier("logoutButton") Button logoutButton) {
        VerticalLayout sidebar = new VerticalLayout();
        MenuButtons menuButtonsDelegation = new MenuButtons();
        List<Button> menuButtons = menuButtonsDelegation.menuButtons();
        sidebar.setWidth(250, Sizeable.Unit.PIXELS);
        sidebar.setHeight("100%");
        sidebar.setMargin(false);
        sidebar.setSpacing(false);
        menuButtons.forEach(sidebar::addComponent);
        sidebar.addComponent(sidebarFiller);
        sidebar.setExpandRatio(sidebarFiller, 1.0f);
        sidebar.addStyleName("sidebar");
        sidebar.addComponent(logoutButton);
        return sidebar;
    }

    @Bean
    VerticalLayout sidebarFiller() {
        VerticalLayout sidebarFiller = new VerticalLayout();
        sidebarFiller.setHeightUndefined();
        return sidebarFiller;
    }

    @Bean
    Button logoutButton() {
        Button logoutButton = new Button();
        logoutButton.setIcon(VaadinIcons.SIGN_OUT);
        logoutButton.setCaption("Wyloguj");
        logoutButton.setWidth(250, Sizeable.Unit.PIXELS);
        logoutButton.addStyleName("logout-button");
        return logoutButton;
    }
}
