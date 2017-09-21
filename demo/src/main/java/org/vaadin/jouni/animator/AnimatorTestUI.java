package org.vaadin.jouni.animator;

import javax.servlet.annotation.WebServlet;

import org.vaadin.jouni.dom.client.Css;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
public class AnimatorTestUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = AnimatorTestUI.class, widgetset = "org.vaadin.jouni.animator.DemoWidgetSet")
    public static class Servlet extends VaadinServlet {
        private static final long serialVersionUID = 1L;
    }

    @Override
    public void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();

        Label label = new Label("Animated label");
        Button button = new Button("Click me");

        button.addClickListener(clickEvent -> {
            Animator.animate(button, new Css().rotate(30)).duration(500);
            Animator.animate(label, new Css().translateX("100px")).delay(200).duration(2000);
        });

        layout.addComponents(label, button);

        setContent(layout);
    }
}
