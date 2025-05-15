package com.worldline.interview.Engine;

import java.util.Arrays;

import com.worldline.interview.Fuel.FuelType;

/**
 * The type Steam engine.
 * Base on Engine
 */
public abstract class AbstractEngineBase implements Engine {

    protected boolean running;
    protected int fuelLevel;
    protected final FuelType requiredFuelType;
    protected final int batchSize;
    protected final FuelType[] engineFuelTypes;

    public AbstractEngineBase(FuelType requiredFuelType, int batchSize, FuelType[] engineFuelTypes) {
        this.requiredFuelType = requiredFuelType;
        this.batchSize = batchSize;
        this.engineFuelTypes = engineFuelTypes;
        


        if (!isFuelAvailable(requiredFuelType)) {
            throw new IllegalStateException("Unsupported fuel type: " + requiredFuelType.getName());
        }

        this.running = false;
        this.fuelLevel = 0;
    }

    @Override
    public void start() {
        if (fuelLevel > 0) {
            running = true;
        } else {
            throw new IllegalStateException("Fuel level is zero. Cannot start engine.");
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(FuelType fuelType, int amount) {
        if (!fuelType.equals(requiredFuelType)) {
            throw new IllegalStateException("Please fill " + requiredFuelType.getName() + " fuel");
        }

        fuelLevel = Math.min(100, fuelLevel + Math.max(0, amount));
    }

    @Override
    public FuelType getFuelType() {
        return requiredFuelType;
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public int getBatchSize() {
        return batchSize;
    }

    @Override
    public FuelType[] getAvailableFuelTypes() {
        return engineFuelTypes;
    }

    @Override
    public boolean isFuelAvailable(FuelType fuelType) {
        return Arrays.asList(engineFuelTypes).contains(fuelType);
    }
}
