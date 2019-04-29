package com.example.slidesoccer.domain.model.panel;

import java.util.ArrayList;
import java.util.List;

public class Panels<T extends Panel > {
	List<T> list;
	
	Panels() {
		list = new ArrayList<T>();
	}
	
	Panels(List<T> panels) {
		list = panels;
	}
	
	void add(T panel) {
		list.add(panel);
	}
	
	public boolean isSameList(Panels<T> target) {
//		@SuppressWarnings("unchecked")
//		List<T> target = (List<T>)object;
		
		if(list.size()!=target.list.size()) return false;
		
		for(T p:target.list) {
			if(!list.contains(p)) return false;
		}
		
		return true;
	}
}
