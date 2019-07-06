package com.example.slidesoccer.domain.model.panel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.slidesoccer.domain.model.move.Move;
import com.example.slidesoccer.domain.model.move.Moved;
import com.example.slidesoccer.domain.model.space.Space;
import com.example.slidesoccer.domain.model.space.Spaces;
import com.example.slidesoccer.domain.type.Height;
import com.example.slidesoccer.domain.type.Width;
import com.example.slidesoccer.domain.type.position.Position;
import com.example.slidesoccer.domain.type.position.X;
import com.example.slidesoccer.domain.type.position.Y;

public class GeneralPanels {
	Set<Panel> panels;
	ArrayList<Move> movedHistory = new ArrayList<>();
	
	Panels<SmallPanel> smallPanels = new Panels<>();
	Panels<TallPanel> tallPanels = new Panels<>();
	Panels<WidePanel> widePanels = new Panels<>();
	GoalPanel goalPanel;
	
	
	public GeneralPanels(List<SmallPanel> smallList
			,List<TallPanel> tallList
			,List<WidePanel> wideList
			,GoalPanel goal) {
		smallPanels = new Panels<>(smallList);
		tallPanels = new Panels<>(tallList);
		widePanels = new Panels<>(wideList);
		goalPanel = goal;
		
		panels = new HashSet<>();
		panels.addAll(smallList);
		panels.addAll(tallList);
		panels.addAll(wideList);
		panels.add(goal);
	}
	
	
	public boolean isGoal() {
		return goalPanel.isGoal();
	}
	
	int size() {
		return panels.size();
	}
	
	public Spaces findSpaces(Height height, Width width) {
		List<Position> positions = new ArrayList<>();
		
		for(int x=1; x<=width.getNum();x++) {
			for(int y=1; y<=height.getNum();y++) {
				positions.add(new Position(X.of(x), Y.of(y)));
			}
		}
		
		panels.forEach(p ->positions.removeAll(p.positions()));
		
		return new Spaces(positions.stream()
				.map(p -> new Space(p))
				.collect(Collectors.toList()));
	}
	
	private Optional<Move> getLastMove() {
		if(movedHistory.size()>0)
			return Optional.of(movedHistory.get(movedHistory.size()-1));
		
		return Optional.empty();
	}
	
	public List<Move> getCanMoves(Spaces spaces) {
		Optional<Move> lastMove = getLastMove();
		ArrayList<Move> moves = new ArrayList<>();
		panels.forEach(p -> {
			moves.addAll(p.getCanMove(spaces));
		});
		
		if(!lastMove.isPresent())
			return moves;
		
		// 直前に戻すのは除外
		for(Move m: moves) {
			if(m.isReverse(lastMove.get())) {
				moves.remove(m);
				break;
			}
		}
		
		return moves;
	}
	
	public boolean equals(GeneralPanels target) {
		if((size()!=target.size())) return false;
		
		if(!smallPanels.isSameList(target.smallPanels)) return false;
		
		if(!tallPanels.isSameList(target.tallPanels)) return false;
		
		if(!widePanels.isSameList(target.widePanels)) return false;
		
		for(Panel p:target.panels) {
			if(!panels.contains(p)) return false;
		}
		
		return true;
	}
	
	public Spaces move(Move move, Spaces spaces) {
		for(Panel p: panels) {
			if(move.isMatch(p)) {
				Moved moved = move.move(spaces);
				panels.remove(p);
				panels.add(moved.getMovedPanel());
				movedHistory.add(move);
				return moved.getSpaces();
			}
		}
		
		throw new RuntimeException("Movable panels is not found.");
	}
	
	// 
	public Spaces undo(Spaces spaces) {
		Optional<Move> lastMove = getLastMove();
		if(lastMove.isEmpty()) {
			throw new RuntimeException("undo対象なし");
		}
		
		Move reverse = lastMove.get().getReverse();
		movedHistory.remove(movedHistory.size()-1);
		return move(reverse, spaces);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((panels == null) ? 0 : panels.hashCode());
		return result;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Panel p: panels) {
			sb.append("[" + p.getClass().getSimpleName() + "]" + p.position.toString());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}
