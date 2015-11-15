package net.elenx;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class MainView {

    @Bean
    VerticalLayout mainView(@Qualifier("nameLabel") Label nameLabel, @Qualifier("nickLabel") Label nickLabel, @Qualifier("mainViewFiller") VerticalLayout filler) {
        VerticalLayout mainView = new VerticalLayout();
        mainView.setSizeFull();
        mainView.addComponent(nameLabel);
        mainView.addComponent(nickLabel);
        mainView.addComponent(filler);
        mainView.setExpandRatio(filler, 1.0f);
        return mainView;
    }

    @Bean
    Label nameLabel() {
        Label label = new Label();
        label.setCaption("Kuba");
        return label;
    }

    @Bean
    Label nickLabel() {
        Label label = new Label();
        label.setCaption("Januszek");
        return label;
    }

    @Bean(name = "mainViewFiller")
    VerticalLayout mainViewFiller() {
        VerticalLayout filler = new VerticalLayout();
        filler.setSizeFull();
        return filler;
    }
}
