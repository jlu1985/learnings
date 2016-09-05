package jl.learnings.gwt.ui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import jl.learnings.gwt.ui.client.hello.HelloWorld;

public class UiBinding implements EntryPoint {

	@Override
	public void onModuleLoad() {

		RootPanel.get().add(new HelloWorld());

	}

}
