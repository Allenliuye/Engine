package com.worldline.interview.Engine;


import com.worldline.interview.Fuel.FuelType;

public interface Engine {

    void start();
    void stop();
    boolean isRunning();
    void fill(FuelType fuelType, int amount);

    FuelType getFuelType();
    int getFuelLevel();
    int getBatchSize();
    FuelType[] getAvailableFuelTypes();

    boolean isFuelAvailable(FuelType fuelType);
}
