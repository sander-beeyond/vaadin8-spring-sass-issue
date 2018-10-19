package com.example.demo;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("apptheme")
@SpringUI
public class myUI extends UI {
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addStyleName("testStyle");
        Label label = new Label("Hello World!");
        verticalLayout.addComponent(label);
        setContent(verticalLayout);
    }
}
