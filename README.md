In this project, I worked with a Java Super Mario engine. I implemented a controller that tries to collect as many coins as possible, kill as many enemies as possible, and finish the game using behavior trees.

I implemented my behavior tree as a package with various classes that define the behavior tree's conditions, actions, and composites. The condition and action classes implement the task class and serve as the nodes of the behavior tree. The sequence class implements the composite class and is used to pair conditions with actions in the behavior tree. I implemented selectors in my behavior tree controller class.

I was able to get my behavior tree controller to finish a game of Super Mario with the following results:  
[~ Mario AI Benchmark ~ 0.1.9]  
  
[MarioAI] ~ Evaluation Results for Task: BasicTask  
        Evaluation lasted : 51619 ms  
         Weighted Fitness : 8834  
             Mario Status : WIN!  
               Mario Mode : small  
Collisions with creatures : 2  
     Passed (Cells, Phys) : 256 of 256, 4096 of 4096 (100% passed)  
 Time Spent(marioseconds) : 84  
  Time Left(marioseconds) : 116  
             Coins Gained : 100 of 285 (35% collected)  
      Hidden Blocks Found : 0 of 0 (0% found)  
       Mushrooms Devoured : 0 of 0 found (0% collected)  
         Flowers Devoured : 0 of 2 found (0% collected)  
              kills Total : 23 of 40 found (57%)  
            kills By Fire : 7  
           kills By Shell : 0  
           kills By Stomp : 16  
    PunJ : 0  
  
 min = 7.0  
 max = 7.0  
 ave = 7.0  
 sd  = NaN  
 n   = 1  
