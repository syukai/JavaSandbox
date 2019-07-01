package com.example.slidesoccer.domain.model.move;

import java.util.List;

import com.example.slidesoccer.domain.model.panel.Panel;
import com.example.slidesoccer.domain.model.panel.SmallPanel;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

public class Move {
	Panel source;
	Position targetPosition;
	
	public Move(Panel source, Position target) {
		this.source = source;
		this.targetPosition = target;
	}
	
	public boolean isMatch(Panel target) {
		return this.source.isMatch(source);
	}
	
//	public Panel getMoved() {
//		return source.getMoved(targetPosition);
//	}

	public Moved move(Spaces spaces) {
		return new Moved(source.getMoved(targetPosition),
				source.getMovedSpaces(spaces, targetPosition));
	}
	
	@Override
	public String toString() {
		return "[" + source.getClass().getSimpleName() + "]" +
				source.positions().toString() + " -> " +
				targetPosition.toString() + System.getProperty("line.separator");
	}
}
