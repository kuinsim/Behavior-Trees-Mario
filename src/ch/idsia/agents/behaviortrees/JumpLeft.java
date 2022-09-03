package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class JumpLeft implements Task{
	public boolean run(BehaviorTreeAgent bta) {
		bta.jumpKey();
		bta.leftKey();
		
		return true;
	}
}
