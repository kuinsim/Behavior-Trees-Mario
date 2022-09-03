package ch.idsia.agents.behaviortrees;

import java.util.ArrayList;
import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class BehaviorTree {
	private ArrayList<Task> nodes;
	BehaviorTreeAgent bta;
	
	public BehaviorTree(BehaviorTreeAgent _bta) {
		nodes = new ArrayList<Task>();
		bta = _bta;
	}
	
	public void runBehaviorTree() {
		for (int i = 0; i < nodes.size(); i++) {
			
			if (nodes.get(i).run(bta) == true) {
				break;
			}
		}
	}
	
	public void addTask(Task task) {
		nodes.add(task);
	}
}