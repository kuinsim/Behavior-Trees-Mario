package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class CanMoveLeft implements Task{
	@Override
	public boolean run(BehaviorTreeAgent bta) {
		return bta.canMoveLeft();
	}
}
