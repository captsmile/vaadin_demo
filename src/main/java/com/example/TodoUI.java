package com.example;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vitalii on 25.03.2017.
 */
@SpringUI
public class TodoUI extends UI {

    private VerticalLayout root;
    @Autowired
    TodoLayout todoLayout;

    @Override
    protected void init(VaadinRequest request){
        setupLayot();
        addHeader();
        addForm();
        addTodoList();
        addDeleteButton();
    }
    private void setupLayot() {
        root = new VerticalLayout();
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }
    private void addHeader() {
        root.addComponent(new Label("TODOs"));
    }
    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        TextField task = new TextField();
        Button add = new Button("Add");
        formLayout.addComponents(task,add);
        root.addComponent(formLayout);


    }
    private void addTodoList() {
        root.addComponent(todoLayout);
    }
    private void addDeleteButton() {
        root.addComponent(new Button("Delete completed"));
    }
}
