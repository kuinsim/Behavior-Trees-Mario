package ch.idsia.agents.behaviortrees;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public interface Task {
	public boolean run(BehaviorTreeAgent b);
}
