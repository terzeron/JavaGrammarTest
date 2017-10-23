package net.terzeron.test.awt_menu;

import java.awt.*;
import java.applet.*;

public class MenuApplication extends Object
{
	public static void main(String[] args)
	{
		Frame myFrame = new Frame("Menu Example");
		MenuBar myMenuBar =new MenuBar();

		myFrame.setMenuBar(myMenuBar);

		Menu fileMenu = new Menu("File");
		myMenuBar.add(fileMenu);

		fileMenu.add(new MenuItem("New"));
		fileMenu.add(new MenuItem("Open"));

		MenuItem saveMenuItem = new MenuItem("Save");
		fileMenu.add(saveMenuItem);
		saveMenuItem.setEnabled(false);

		fileMenu.add(new CheckboxMenuItem("Auto Save"));
		fileMenu.addSeparator();

		Menu printSubmenu = new Menu("Print");
		fileMenu.add(printSubmenu);
		printSubmenu.add("Print Preview");
		printSubmenu.add("Print Document");

		myFrame.setSize(300, 200);
		myFrame.show();
	}
}
