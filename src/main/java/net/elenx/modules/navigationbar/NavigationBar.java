package net.elenx.modules.navigationbar;


import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import net.elenx.modules.spring.BeansManager;
import net.elenx.modules.spring.Injectable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.vaadin.teemu.VaadinIcons;

public class NavigationBar implements Injectable {


    VerticalLayout sidebar;

    //method to inject all the beans which were previously were injected by Spring
    public void inject(BeansManager beansManager) {
        this.sidebar = beansManager.getSidebar();
    }

    @Bean
    HorizontalLayout navigationBar(@Qualifier("hamburgerButton") Button hamburgerButton, @Qualifier("elenxLogo") Label elenxLogo) {
        HorizontalLayout navbar = new HorizontalLayout();
        navbar.setWidth("100%");
        navbar.setMargin(true);
        navbar.setHeight(50, Sizeable.Unit.PIXELS);
        navbar.addComponent(hamburgerButton);
        navbar.addComponent(elenxLogo);
        navbar.addStyleName("navigation-bar");
        return navbar;
    }

    @Bean
    Button hamburgerButton() {
        Button button = new Button(null, clickEvent -> onHamburgerButtonClick());
        button.addStyleName("hamburger-button");
        button.setIcon(VaadinIcons.MENU);
        return button;
    }

    @Bean
    Label elenxLogo() {
        Label label = new Label("ElenX");
        label.addStyleName("elenx-logo");
        label.setWidthUndefined();
        label.setEnabled(false);
        return label;
    }

    private void onHamburgerButtonClick() {
        sidebar.setWidth("1%");
    }
}
