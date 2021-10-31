package com.example.demo.views;

import com.example.demo.client.BackendClient;
import com.example.demo.domain.Currency;
import com.example.demo.domain.Rates;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@Route("")
@PWA(name = "Konwereter Walut", shortName = "Konwerter Walut")
public class MainView extends VerticalLayout {

    @Autowired
    BackendClient backendClient;
    @Autowired
    Currency currency;

    HorizontalLayout layout1 = new HorizontalLayout();
    Component component1 = new Text("KONWERTER WALUT");

    HorizontalLayout layout2 = new HorizontalLayout();
    IntegerField insertField = new IntegerField();
    Select<String> currencyTwoSelect = new Select<>();
    Select<String> labelSelect2 = new Select<>();
    Button executeBtn = new Button();
    TextField resultField = new TextField();

    Grid<Rates> grid1 = new Grid<>(Rates.class);

    HorizontalLayout layout3 = new HorizontalLayout();
    Component component2 = new Text("Wszystkie podane kursy i wyliczenia opierają się na danych udostępnionych przez NBP");

    public MainView(BackendClient backendClient) {
        this.backendClient=backendClient;

        layout1.setWidth("100%");
        layout1.getStyle().set("border", "1px solid #52565b");
        layout1.getElement().getStyle().set("padding", "10px");
        layout1.getElement().getStyle().set("font-size", "24px");
        layout1.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout1.add(component1);
        add(layout1);

        layout2.setWidth("100%");
        layout2.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        insertField.setLabel("Wprowadź kwotę: ");
        currencyTwoSelect.setLabel("Konwertuj z: ");
        labelSelect2.setLabel("Konwertuj na: ");
        executeBtn.setText("Przelicz");
        executeBtn.getElement().getStyle().set("margin", "36px 0px 0px 15px");
        executeBtn.getElement().getStyle()
                .set("color", "#ffffff")
                .set("background", "#33ab4b");
        resultField.setLabel("Wynik: ");
        resultField.setReadOnly(true);
        layout2.add(insertField, currencyTwoSelect, labelSelect2, executeBtn, resultField);
        add(layout2);

        grid1.getStyle().set("border", "1px solid #52565b");
        grid1.setColumns("currency", "code", "bid", "ask");
        grid1.getColumnByKey("currency").setHeader("Nazwa waluty");
        grid1.getColumnByKey("code").setHeader("Symbol waluty");
        grid1.getColumnByKey("bid").setHeader("Kupno");
        grid1.getColumnByKey("ask").setHeader("Sprzedaż");
        grid1.setItems(backendClient.fetchAllCurrencies());
        add(grid1);

        layout3.setWidth("100%");
        layout3.getStyle().set("border", "1px solid #52565b");
        layout3.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout3.getElement().getStyle().set("padding", "10px");
        layout3.getElement().getStyle().set("font-size", "12px");
        layout3.add(component2);
        add(layout3);
    }
}
