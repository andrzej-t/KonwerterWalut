package com.example.demo.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@PWA(name = "Konwereter Walut", shortName = "Konwerter Walut")
public class MainView extends VerticalLayout {

    HorizontalLayout layout1 = new HorizontalLayout();
    Component component1 = new Text("KONWERTER WALUT");

    HorizontalLayout layout2 = new HorizontalLayout();
    IntegerField integerField1 = new IntegerField();
    Select<String> labelSelect1 = new Select<>();
    Select<String> labelSelect2 = new Select<>();
    Button button1 = new Button();

    public MainView() {

        layout1.setWidth("100%");
        layout1.getStyle().set("border", "1px solid #9E9E9E");
        layout1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout1.add(component1);
        add(layout1);

        layout2.setWidth("100%");
        layout2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        integerField1.setLabel("Wprowadź kwotę: ");
        labelSelect1.setLabel("Konwertuj z: ");
        labelSelect2.setLabel("Konwertuj na: ");
        button1.setText("Przelicz");
        button1.getElement().getStyle().set("margin", "36px 0px 0px 15px");
        layout2.add(integerField1, labelSelect1, labelSelect2, button1);
        add(layout2);
    }

//    getButtonInside2().getElement().getStyle().set("margin", "20% 30% 10% 38%");
}
