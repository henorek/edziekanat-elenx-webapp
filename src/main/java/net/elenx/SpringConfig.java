package net.elenx;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.ui.VerticalLayout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableVaadin
public class SpringConfig {

    //Create whole view of MainView
    @Bean(name = "template")
    public VerticalLayout template() {
        VerticalLayout template = new VerticalLayout();
        NavigationBar navigationBar = new NavigationBar();
        Sidebar sidebar = new Sidebar();
        template.setMargin(false);
        template.setSpacing(false);
        template.setHeight("100%");
        template.addComponent(navigationBar.getNavigationBar());
        template.addComponent(sidebar.getSidebar());
        template.setExpandRatio(sidebar.getSidebar(), 1.0f);
        return template;
    }
}
