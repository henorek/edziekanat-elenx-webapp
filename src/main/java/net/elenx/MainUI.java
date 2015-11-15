package net.elenx;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
@SpringUI
@Widgetset("net.elenx.MyAppWidgetset")
public class MainUI extends UI {

    @Autowired
    private VerticalLayout template;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.setContent(template);
    }

    @WebListener
    public static class MyContextLoaderListener extends ContextLoaderListener {
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MyUIServlet extends SpringVaadinServlet {
    }

}

