package net.elenx;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

@EnableVaadin
public class Template {

    @Bean
    public VerticalLayout template(@Qualifier("navigationBar") HorizontalLayout navigationBar, @Qualifier("content") HorizontalLayout content) {
        VerticalLayout template = new VerticalLayout();
        template.setMargin(false);
        template.setSpacing(false);
        template.setHeight("100%");
        template.addComponent(navigationBar);
        template.addComponent(content);
        template.setExpandRatio(content, 1.0f);
        return template;
    }
}
