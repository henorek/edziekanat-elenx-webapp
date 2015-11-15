package net.elenx;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.context.annotation.Bean;

public class MainView {

    @Bean
    VerticalLayout mainView(Label nameLabel, Label nickLabel) {
        VerticalLayout mainView = new VerticalLayout();
        mainView.setSizeFull();
        mainView.addComponent(nameLabel);
        mainView.addComponent(nickLabel);
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
        label.setCaption("Chujuszek");
        return label;
    }
}
