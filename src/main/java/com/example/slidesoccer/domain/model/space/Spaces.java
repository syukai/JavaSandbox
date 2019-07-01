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
	
	public boolean hasUp(Position position) {
		return contains(position.up());
	}
	
	public boolean hasDown(Position position) {
		return contains(position.down());
	}
	
	public boolean hasRight(Position position) {
		return contains(position.right());
	}
	
	public boolean hasLeft(Position position) {
		return contains(position.left());
	}
	
	public boolean hasWideUp(Position position) {
		return contains(position.up())
				&& contains(position.up().right());
	}
	
	public boolean hasWideDown(Position position) {
		return contains(position.down())
				&& contains(position.down().right());
	}
	public boolean hasTallRight(Position position) {
		return contains(position.right())
				&& contains(position.right().down());
	}
	public boolean hasTallLeft(Position position) {
		return contains(position.left())
				&& contains(position.left().down());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Spaces]");
		for(Space s:spaces) {
			sb.append(s.toString());
			sb.append(",");
		}
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}
}
