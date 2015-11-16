package net.elenx.modules.spring;

import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class BeansManager {

    @Autowired
    private VerticalLayout sidebar;

    @Autowired
    private Set<Injectable> injectables = new HashSet();

    public VerticalLayout getSidebar() {
        return sidebar;
    }

    public void setSidebar(VerticalLayout sidebar) {
        this.sidebar = sidebar;
    }

    @PostConstruct
    private void inject() {
        for (Injectable injectableItem : injectables) {
            injectableItem.inject(this);
        }
    }
}

