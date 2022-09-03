package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class CanMoveRight implements Task {
	@Override
	public boolean run(BehaviorTreeAgent bta) {
		return bta.canMoveRight();
	}
}
