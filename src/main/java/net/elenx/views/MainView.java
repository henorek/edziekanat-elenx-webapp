package net.elenx.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import net.elenx.modules.NavigationBar;
import net.elenx.modules.Sidebar;

import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
@Widgetset("net.elenx.MyAppWidgetset")
public class MainView extends UI {

    private VerticalLayout template = createView();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        this.setContent(template);
    }

    //Create whole view of MainView
    public VerticalLayout createView() {
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

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainView.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

