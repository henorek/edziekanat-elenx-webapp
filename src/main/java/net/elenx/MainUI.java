package net.elenx;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@Theme("mytheme")
@Widgetset("net.elenx.MyAppWidgetset")
public class MainUI extends UI {

    private NavigationBarUI navigationBarUI = new NavigationBarUI();
    private MainContentUI mainContentUI = new MainContentUI();
    private VerticalLayout template = new VerticalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        template.setMargin(false);
        template.setSpacing(false);
        
        //Place all elements together
        template.addComponent(navigationBarUI.initNavigationBar());
        template.addComponent(mainContentUI.initMainPanel());
        this.setContent(template);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
