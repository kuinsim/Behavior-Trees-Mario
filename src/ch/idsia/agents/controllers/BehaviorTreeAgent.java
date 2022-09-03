package ch.idsia.agents.controllers;

import ch.idsia.agents.behaviortrees.*;
import ch.idsia.agents.Agent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.engine.sprites.Sprite;
import ch.idsia.benchmark.mario.environments.Environment;

public class BehaviorTreeAgent extends BasicMarioAIAgent implements Agent{
	int trueJumpCounter = 0;
	int trueSpeedCounter = 0;
	BehaviorTree bt;
	
	public BehaviorTreeAgent() {
		super("BehaviorTreeAgent");
		reset();
		
		bt = new BehaviorTree(this);
		
		Sequence s1 = new Sequence();
	    s1.addChild(new IsCoinLeft());
	    s1.addChild(new JumpLeft());
	    
	    Sequence s2 = new Sequence();
	    s1.addChild(new IsCoinRight());
	    s1.addChild(new JumpRight());
	    
	    Sequence s3 = new Sequence();
	    s2.addChild(new IsEnemyNear());
	    s2.addChild(new Shoot());
	    
	    Sequence s4 = new Sequence();
	    s3.addChild(new CanMoveRight());
	    s3.addChild(new MoveRight());
	    
	    Sequence s5 = new Sequence();
	    s4.addChild(new CanJumpRight());
	    s4.addChild(new JumpRight());
	    
	    Sequence s6 = new Sequence();
	    s5.addChild(new CanMoveLeft());
	    s5.addChild(new MoveLeft());
	    
	    Sequence s7 = new Sequence();
	    s6.addChild(new CanJumpLeft());
	    s6.addChild(new JumpLeft());
	    
	    bt.addTask(s1);
	    bt.addTask(s2);
	    bt.addTask(s3);
	    bt.addTask(s4);
	    bt.addTask(s5);
	    bt.addTask(s6);
	    bt.addTask(s7);
	}
	
	public void reset()
	{
	    action = new boolean[Environment.numberOfKeys];
	    //action[Mario.KEY_RIGHT] = true;
	    //action[Mario.KEY_SPEED] = true;
	    trueJumpCounter = 0;
	    trueSpeedCounter = 0;
	}
	
	public boolean isCreature(int creature)
	{
	    switch (creature)
	    {
	        case Sprite.KIND_GOOMBA:
	        case Sprite.KIND_RED_KOOPA:
	        case Sprite.KIND_RED_KOOPA_WINGED:
	        case Sprite.KIND_GREEN_KOOPA_WINGED:
	        case Sprite.KIND_GREEN_KOOPA:
	            return true;
	    }
	    return false;
	}
	
	public boolean isCoin(int coin)
	{
	    switch (coin)
	    {
	        case -24:
	            return true;
	    }
	    return false;
	}
	
	public boolean canMoveRight() {
		boolean objectIsRight = false;
	    
	    for (int i = 0; i < 3; i++) {
	    	if (levelScene[marioEgoRow + i][marioEgoCol]!= 0) {
	    		objectIsRight = true;
	    		
	    		break;
	    	}
	    }
	    
	    boolean enemyIsRight = false;
	    
	    for (int i = 0; i < 3; i++) {
	    	if (isCreature(enemies[marioEgoRow + i][marioEgoCol])) {
	    		enemyIsRight = true;
	    		
	    		break;
	    	}
	    }

		return !objectIsRight && !enemyIsRight;
	}
	
	public boolean canMoveLeft() {
		boolean objectIsLeft = false;
	    
		for (int i = 0; i < 3; i++) {
	    	if (levelScene[marioEgoRow - i][marioEgoCol]!= 0) {
	    		objectIsLeft = true;
	    		
	    		break;
	    	}
	    }
		
	    boolean enemyIsLeft = false;
	    
	    for (int i = 0; i < 3; i++) {
	    	if (isCreature(enemies[marioEgoRow - i][marioEgoCol])) {
	    		enemyIsLeft = true;
	    		
	    		break;
	    	}
	    }
		
		return !objectIsLeft && !enemyIsLeft;
	}
	
	public boolean canJumpRight() {
boolean objectIsRight = false;
	    
	    for (int i = 0; i < 3; i++) {
	    	if (levelScene[marioEgoRow + i][marioEgoCol]!= 0) {
	    		objectIsRight = true;
	    		
	    		break;
	    	}
	    }
	    
		boolean enemyInJump = false;
		
		if (isCreature(enemies[marioEgoRow][marioEgoCol + 2]) || isCreature(enemies[marioEgoRow + 2][marioEgoCol])) {
			enemyInJump = true;
		}
		
		return (isMarioAbleToJump || !isMarioOnGround) && !enemyInJump && objectIsRight;
	}
	
	public boolean canJumpLeft() {
		boolean objectIsLeft = false;
		
		for (int i = 0; i < 3; i++) {
	    	if (levelScene[marioEgoRow - i][marioEgoCol]!= 0) {
	    		objectIsLeft = true;
	    		
	    		break;
	    	}
	    }
		boolean enemyInJump = false;
		
		if (isCreature(enemies[marioEgoRow][marioEgoCol + 2]) || isCreature(enemies[marioEgoRow + 2][marioEgoCol])) {
			enemyInJump = true;
		}
		
		return (isMarioAbleToJump || !isMarioOnGround) && !enemyInJump && objectIsLeft;
	}
	
	public boolean isCoinLeft() {
		boolean coinIsLeft = false;
		
		if (isCoin(mergedObservation[marioEgoRow - 2][marioEgoCol + 0])) {
		    coinIsLeft = true;
		    	
		}

		return coinIsLeft;
	}
	
	public boolean isCoinRight() {
		boolean coinIsRight = false;
		
		for (int i = 0; i < 3; i++) {
			if (isCoin(mergedObservation[marioEgoRow + 2][marioEgoCol + 0])) {
		    	coinIsRight = true;
		    	
		    	break;
			}
		}

		return coinIsRight;
	}
	
	public boolean isEnemyNear() {
		boolean enemyNear = false;
		
		for (int i = 0; i < 3; i++) {
	    	if ((isCreature(getEnemiesCellValue(marioEgoRow + i, marioEgoCol)) || isCreature(getEnemiesCellValue(marioEgoRow, marioEgoCol + i)) || isCreature(getEnemiesCellValue(marioEgoRow + i, marioEgoCol + i)))) {
	    		enemyNear = true;
	    		break;
	    	}
	    }
		
		return enemyNear && isMarioAbleToShoot;
	}
	
	public void leftKey() {
		action[Mario.KEY_LEFT] = true;
	}
	
	public void rightKey() {
		action[Mario.KEY_RIGHT] = true;
	}
	
	public void jumpKey() {
		action[Mario.KEY_JUMP] = true;
	}
	
	public void shootKey() {
		action[Mario.KEY_SPEED] = true;
	}
	
	public boolean[] getAction()
	{	
		reset();
		
		bt.runBehaviorTree();
	    
	    return action;
	}
}
