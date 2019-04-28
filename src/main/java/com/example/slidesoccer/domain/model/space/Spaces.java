package com.example.slidesoccer.domain.model.space;

import java.util.ArrayList;
import java.util.List;

import com.example.slidesoccer.domain.type.position.Position;

public class Spaces {
	List<Space> spaces;
	
	public Spaces(Space space1, Space space2) {
		this.spaces = new ArrayList<Space>();
		this.spaces.add(space1);
		this.spaces.add(space2);
	}
	public Spaces(List<Space> list) {
		this.spaces = list;
	}

	public boolean contains(Position position) {
		return spaces.contains(new Space(position));
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Space s:spaces) {
			sb.append(s.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
