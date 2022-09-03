package ch.idsia.agents.behaviortrees;

import java.util.ArrayList;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class Sequence implements Composite{
	private ArrayList<Task> children; 
	
	public Sequence() {
		children = new ArrayList<Task>();
	}
	
	@Override
	public boolean run(BehaviorTreeAgent bta) {		
		for (int i = 0; i < children.size(); i++) {
			
			if (children.get(i).run(bta) != true) {
				return false;
			}
		}
		
		return true;
	}
	
	public ArrayList<Task> getChildren() {
		return children;
	}
	
	public void addChild(Task task) {
		children.add(task);
	}
}
