package com.example.slidesoccer.domain.model.field;

import java.util.ArrayList;
import java.util.List;

import com.example.slidesoccer.domain.model.panel.GoalPanel;
import com.example.slidesoccer.domain.model.panel.Panel;
import com.example.slidesoccer.domain.model.panel.Panels;
import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.model.panel.TallPanel;
import com.example.slidesoccer.domain.model.panel.WidePanel;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.Height;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.Width;

public class Field {
	Height height;
	Width width;

	Panels panels = new Panels();
	List<SmallPanel> smallPanels;
	List<TallPanel> tallPanels;
	List<WidePanel> widePanels;
	GoalPanel goalPanel;
	Spaces spaces;
	Field() {
		this.height = Height.of(5);
		this.width = Width.of(4);
	}
	public Field(FieldBuilder builder) {
		this.height = builder.height;
		this.width = builder.width;
		this.smallPanels = builder.smallPanels;
		this.tallPanels = builder.tallPanels;
		this.widePanels = builder.widePanels;
		this.goalPanel = builder.goalPanel;
		
		this.panels.addAll(this.smallPanels);
		this.panels.addAll(this.tallPanels);
		this.panels.addAll(this.widePanels);
		this.panels.add(this.goalPanel);
		
		spaces = panels.findSpaces(height, width);
		System.out.println(spaces.toString());
	}
	public void setSmallPanel(int x, int y) {
//		cubes.add(new SmallCube(new Coordinate(1, 1)));
	}
	public void setGoalPanel(Position position) {
		this.goalPanel = new GoalPanel(position);
	}
	public boolean isGoal() {
		return goalPanel.isGoal();
	}
	public void setSpaces(Space space, Space space2) {
		this.spaces = new Spaces(space, space2);
	}
	public static FieldBuilder builder() {
		return new FieldBuilder(Height.of(5), Width.of(4));
	}
	public boolean hasSpace(Position position) {
		return this.spaces.contains(position);
	}

}
