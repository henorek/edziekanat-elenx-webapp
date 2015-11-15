package net.elenx;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.vaadin.teemu.VaadinIcons;

import java.util.List;

public class Sidebar {

    @Bean
    VerticalLayout sidebar(@Qualifier("filler") VerticalLayout filler, Button logoutButton) {
        VerticalLayout sidebar = new VerticalLayout();
        MenuButtons menuButtonsDelegation = new MenuButtons();
        List<Button> menuButtons = menuButtonsDelegation.menuButtons();
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
        sidebar.addComponent(logoutButton);
        return sidebar;
    }

    @Bean
    VerticalLayout filler() {
        VerticalLayout filler = new VerticalLayout();
        filler.setHeightUndefined();
        return filler;
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
