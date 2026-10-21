package com.fitness.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.application.entity.User;
import com.fitness.application.entity.Workout;
import com.fitness.application.repository.UserRepository;
import com.fitness.application.repository.WorkoutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public Workout createWorkout(Long userId, Workout workout) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkoutsByUser(Long userId) {
        return workoutRepository.findByUserId(userId);
    }
}