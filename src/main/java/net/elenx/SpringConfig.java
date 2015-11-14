package net.elenx;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableVaadin
public class SpringConfig {

    @Bean
    public VerticalLayout template(HorizontalLayout navigationBar) {
        VerticalLayout template = new VerticalLayout();
        Sidebar sidebar = new Sidebar();
        template.setMargin(false);
        template.setSpacing(false);
        template.setHeight("100%");
        template.addComponent(navigationBar);
        template.addComponent(sidebar.getSidebar());
        template.setExpandRatio(sidebar.getSidebar(), 1.0f);
        return template;
    }
}
