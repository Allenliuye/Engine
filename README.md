        +------------------+
        |    <<interface>> |
        |      Engine      |
        +------------------+
        | +start()         |
        | +stop()          |
        | +isRunning()     |
        | +fill(...)       |
        | +getFuelType()   |
        | +getFuelLevel()  |
        | +getBatchSize()  |
        | +getAvailable... |
        | +isFuelAvailable |
        +--------^---------+
                 |
        +--------|-------------+
        | AbstractEngineBase   |
        +----------------------+
        | - running            |
        | - fuelLevel          |
        | - requiredFuelType   |
        | - batchSize          |
        | - engineFuelTypes    |
        | + implements Engine  |
        +--------^-------------+
                 |
        +--------|----------------------+     
        | InternalCombustionEngine     |
        +------------------------------+
        | + BATCH_SIZE = 8             |
        | + FUEL_TYPES = {...}         |
        +------------------------------+

        +--------|----------------------+
        |       SteamEngine            |
        +------------------------------+
        | + BATCH_SIZE = 2             |
        | + FUEL_TYPES = {...}         |
        +------------------------------+

        +---------------------+
        |   WidgetMachine     |
        +---------------------+
        | - engine: Engine    |
        | + produceWidgets()  |
        +---------------------+
