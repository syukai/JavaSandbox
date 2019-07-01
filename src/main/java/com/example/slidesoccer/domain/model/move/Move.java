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
	
	public boolean isReverse(Move other) {
		if(this.getClass() != other.getClass()) return false;
		
		if(this.source.isPosition(other.targetPosition) &&
				other.source.isPosition(this.targetPosition))
			return true;
		
		return false;
	}
	
//	public Panel getMoved() {
//		return source.getMoved(targetPosition);
//	}

	public Moved move(Spaces spaces) {
		return new Moved(source.getMoved(targetPosition),
				source.getMovedSpaces(spaces, targetPosition));
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((targetPosition == null) ? 0 : targetPosition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (!source.equals(other.source))
			return false;
		if (!targetPosition.equals(other.targetPosition))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + source.getClass().getSimpleName() + "]" +
				source.positions().toString() + " -> " +
				targetPosition.toString() + System.getProperty("line.separator");
	}
}
