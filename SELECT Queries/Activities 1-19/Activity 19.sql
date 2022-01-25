-- Activity 19
SELECT g.name, w.WorkoutID, wg.GoalId, g.GoalId FROM Workout AS w, workoutgoal AS wg, Goal as g
WHERE w.Name = 'This Is Parkour' AND w.WorkoutId = wg.WorkoutId AND g.GoalId = wg.GoalId;