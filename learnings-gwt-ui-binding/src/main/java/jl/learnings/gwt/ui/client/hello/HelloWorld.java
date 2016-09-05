package jl.learnings.gwt.ui.client.hello;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld extends Composite {

	interface HelloWorldUIBinder extends UiBinder<Widget, HelloWorld> {
	};

	private static HelloWorldUIBinder uiBinder = GWT
			.create(HelloWorldUIBinder.class);

	@UiField
	ListBox listBox;

	public HelloWorld() {
		initWidget(uiBinder.createAndBindUi(this));

		listBox.addItem("wow");

	}
}
