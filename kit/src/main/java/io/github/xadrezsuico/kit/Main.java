package io.github.xadrezsuico.kit;

import io.github.xadrezsuico.kit.util.SoftwareProperties;
import io.github.xadrezsuico.kit.view.DefaultView;

public class Main {
	private DefaultView defaultView;
	private SoftwareProperties softwareProperties;
	public Main(){
		softwareProperties = new SoftwareProperties();
		defaultView = new DefaultView(this);
		defaultView.setVisible(true);
	}
	
	public SoftwareProperties getSoftwareProperties(){
		return this.softwareProperties;
	}
	
	public static void main(String[] args){
		new Main();
	}
}
