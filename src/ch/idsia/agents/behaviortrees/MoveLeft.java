package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class MoveLeft implements Task{
	public boolean run(BehaviorTreeAgent bta) {
		bta.leftKey();
		
		return true;
	}
}
