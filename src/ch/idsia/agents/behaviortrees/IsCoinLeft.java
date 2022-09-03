package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class IsCoinLeft implements Task {
	@Override
	public boolean run(BehaviorTreeAgent bta) {
		return bta.isCoinLeft();
	}
}
