package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class MoveRight implements Task{
	public boolean run(BehaviorTreeAgent bta) {
		bta.rightKey();
		
		return true;
	}
}
