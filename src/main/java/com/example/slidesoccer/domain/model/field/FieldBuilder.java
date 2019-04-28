package com.example.slidesoccer.domain.model.field;

import java.util.ArrayList;
import java.util.List;

import com.example.slidesoccer.domain.model.panel.GoalPanel;
import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.model.panel.TallPanel;
import com.example.slidesoccer.domain.model.panel.WidePanel;
import com.example.slidesoccer.domain.type.Height;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;
import com.example.slidesoccer.domain.type.Width;

public class FieldBuilder {
	Height height;
	Width width;
	List<SmallPanel> smallPanels = new ArrayList<>();
	List<TallPanel> tallPanels = new ArrayList<>();
	List<WidePanel> widePanels = new ArrayList<>();
	GoalPanel goalPanel;
	FieldBuilder(Height height, Width width) {
		this.height = height;
		this.width = width;
	}
	
	FieldBuilder small(X x, Y y) {
		smallPanels.add(new SmallPanel(new Position(x, y)));
		return this;
	}
	
	FieldBuilder tall(X x, Y y) {
		tallPanels.add(new TallPanel(new Position(x, y)));
		return this;
	}
	
	FieldBuilder goal(X x, Y y) {
		goalPanel = new GoalPanel(new Position(x, y));
		return this;
	}
	
	FieldBuilder wide(X x, Y y) {
		widePanels.add(new WidePanel(new Position(x, y)));
		return this;
	}
	
	Field create() {
		Field field = new Field(this);
		return field;
	}
}
