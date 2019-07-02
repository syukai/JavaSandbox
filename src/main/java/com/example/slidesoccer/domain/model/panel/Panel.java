package com.example.slidesoccer.domain.model.panel;

import java.util.List;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

/**
 * パネル
 * @author hirayamadaisuke
 *
 */
public abstract class Panel {
	Position position;
	PanelType type;
	public Panel(PanelType type, Position position){
		this.position = position;
		this.type = type;
	}
	
	public boolean isPosition(Position position) {
		return this.position.is(position);
	}
	
	public abstract List<Position> positions();

	public boolean isMatch(Panel source) {
		if(!this.getClass().getName().equals(source.getClass().getName())) return false;
		
		if(!isPosition(source.position)) return false;
		
		return true;
	}
	
	public abstract List<Move> getCanMove(Spaces spaces);
	
	public abstract Panel getMoved(Position position);

	public Spaces getMovedSpaces(Spaces spaces, Position target) {
		// Panel種類毎に移動後のスペースを取るようにする（ここはabstractに変更する）
		Spaces movedSpaces = new Spaces(
				new Space(new Position(X.of(1), Y.of(2)))
				, new Space(new Position(X.of(2), Y.of(3)))
				);
		return movedSpaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Panel other = (Panel) obj;
		if (!position.equals(other.position))
			return false;
		return true;
	}
	
	
}
