package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class JumpRight implements Task{
	public boolean run(BehaviorTreeAgent bta) {
		bta.jumpKey();
		bta.rightKey();
		
		return true;
	}
}