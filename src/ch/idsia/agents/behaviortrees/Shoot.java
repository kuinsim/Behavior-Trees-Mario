package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class Shoot implements Task {
	public boolean run(BehaviorTreeAgent bta) {
		bta.shootKey();
		
		return true;
	}
}
