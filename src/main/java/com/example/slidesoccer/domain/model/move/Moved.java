package com.example.slidesoccer.domain.model.move;

import com.example.slidesoccer.domain.model.panel.Panel;
import com.example.slidesoccer.domain.model.space.Spaces;

public class Moved {
	private final Panel panel;
	private final Spaces spaces;
	
	Moved(Panel panel, Spaces spaces) {
		this.panel = panel;
		this.spaces = spaces;
	}
	
	public Panel getMovedPanel() {
		return panel;
	}
	public Spaces getSpaces() {
		return spaces;
	}
}
