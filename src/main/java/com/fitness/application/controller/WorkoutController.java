package com.fitness.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitness.application.entity.Workout;
import com.fitness.application.service.WorkoutService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users/{userId}/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@PathVariable Long userId,
                                                 @RequestBody Workout workout) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(workoutService.createWorkout(userId, workout));
    }

    @GetMapping
    public List<Workout> getUserWorkouts(@PathVariable Long userId) {
        return workoutService.getWorkoutsByUser(userId);
    }
}