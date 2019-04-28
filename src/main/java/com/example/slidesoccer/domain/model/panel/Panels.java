package com.example.slidesoccer.domain.model.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.Height;
import com.example.slidesoccer.domain.type.Width;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

public class Panels {
	List<Panel> panels;
	
	public Panels() {
		panels = new ArrayList<>();
	}
	
	public void addAll(List<? extends Panel> adder) {
		panels.addAll(adder);
	}
	public void add(Panel adder) {
		panels.add(adder);
	}
	
	public Spaces findSpaces(Height height, Width width) {
		List<Position> positions = new ArrayList<>();
		
		for(int x=1; x<=width.getNum();x++) {
			for(int y=1; y<=height.getNum();y++) {
				positions.add(new Position(X.of(x), Y.of(y)));
			}
		}
		
		panels.forEach(p -> {
			positions.removeAll(p.positions());
//			System.out.println("positions");
//			p.positions().stream().forEach(System.out::println);
			});
		
		
		return new Spaces(positions.stream()
				.map(p -> new Space(p))
				.collect(Collectors.toList()));
	}
}
