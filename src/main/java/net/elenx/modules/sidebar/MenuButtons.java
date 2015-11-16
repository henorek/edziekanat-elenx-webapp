package net.elenx.modules.sidebar;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import org.vaadin.teemu.VaadinIcons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuButtons {

    public List<Button> menuButtons() {
        Map<String, MenuButtonModel> buttons = new HashMap<>();
        List<Button> menuButtons = new ArrayList<>(5);
        buttons.put("Strona główna", new MenuButtonModel(VaadinIcons.MENU, clickEvent -> onHomeButtonClick()));
        buttons.put("Plan zajęć", new MenuButtonModel(VaadinIcons.OPEN_BOOK, clickEvent -> onScheduleButtonClick()));
        buttons.put("Oceny", new MenuButtonModel(VaadinIcons.BELL, clickEvent -> onGradesButtonClick()));
        buttons.put("Dydaktyka", new MenuButtonModel(VaadinIcons.LAPTOP, clickEvent -> onDidacticsButtonClick()));
        buttons.put("Materiały", new MenuButtonModel(VaadinIcons.FACEBOOK, clickEvent -> onMaterialsButtonClick()));
        buttons.forEach((k, v) -> menuButtons.add(menuButton(k, v)));
        return menuButtons;
    }

    private Button menuButton(String caption, MenuButtonModel model) {
        Button button = new Button();
        button.setIcon(model.getIcon());
        button.setCaption(caption);
        button.addClickListener(model.getListener());
        button.setWidth(250, Sizeable.Unit.PIXELS);
        button.addStyleName("sidebar-button");
        return button;
    }

    private void onHomeButtonClick() {
    }

    private void onScheduleButtonClick() {
    }

    private void onGradesButtonClick() {
    }

    private void onDidacticsButtonClick() {
    }

    private void onMaterialsButtonClick() {
    }
}
