package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class IsEnemyNear implements Task{
	@Override
	public boolean run(BehaviorTreeAgent bta) {
		return bta.isEnemyNear();
	}
}
