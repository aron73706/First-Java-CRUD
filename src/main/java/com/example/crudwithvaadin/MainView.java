package com.example.crudwithvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import org.springframework.util.StringUtils;

@Route
public class MainView extends VerticalLayout {

	private final CustomerRepository repo;

	private final CustomerEditor editor;

	final Grid<Customer> grid;

	final TextField filter;

	private final Button addNewBtn;

	public MainView(CustomerRepository repo, CustomerEditor editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid<>(Customer.class);
		this.filter = new TextField();
		this.addNewBtn = new Button("New customer", VaadinIcon.PLUS.create());

		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		add(actions, grid, editor);

		grid.setHeight("300px");
		grid.setColumns("id", "firstName", "lastName");
		grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

		filter.setPlaceholder("Filter by last name (Added by Manuel)");

		// Re-filter the grid while the user types
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listCustomers(e.getValue()));

		// Selecting a row opens it in the editor
		grid.asSingleSelect().addValueChangeListener(e -> editor.editCustomer(e.getValue()));

		addNewBtn.addClickListener(e -> editor.editCustomer(new Customer("", "")));

		// Refresh the grid after the editor saves or deletes
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listCustomers(filter.getValue());
		});

		listCustomers(null);
	}

	void listCustomers(String filterText) {
		if (StringUtils.hasText(filterText)) {
			grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
		}
		else {
			grid.setItems(repo.findAll());
		}
	}

}
