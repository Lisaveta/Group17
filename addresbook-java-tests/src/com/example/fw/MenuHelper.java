package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper {

	public final ApplicationManager manager;

	public MenuHelper(ApplicationManager applicationManager) {
		this.manager = applicationManager;
		// TODO Auto-generated constructor stub
	}

	public void pushCreateFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(manager.getApplication());
		menu.pushMenuNoBlock("File|New folder...");
	}

}
