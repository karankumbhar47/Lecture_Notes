- sensors (40 secods)
- anamoly (koggle (production hamperd 40 minute))
- ML something happens in future (alert)
- look into issue if get alert
- Meta flow code (2000 sensors)
- mill devided into 14 regions
- 14 branches work in parallel
- workflow --> input data and filter signal want in production

# pipeline
- data from server
- then from postgreSQL
- dashboard for end user()


# workflow 
1. start
    - read input file (path from input data, directory,sensors id)
2. filter coloumn
    - filter selected signals 
3. read config file (each branch model path)
    - read json file (data for all regions)
4. (10 branches)
    - for each (regions mention in json file)
    - task id for each branch
    1. read data for each regions ()
    2. preprocessing
        - scaling , remove null values
    3.  implement pca 
        - load , transform
    4. prediction model
    5. anamoly score (2 branches divided)
        - only 16 treads available on system(4 should wait in queue)
        - greater than some score then cobble
        - for each
        - two measurement
        1. cobble
            - weather cobble or not
            - list of all sensors
        2. loss per signal
            -  
    6. join two branches
5. join all regions branches 
    - don't join all functions at once

# info 
- log file(debugging)
- influx db (time base data)
- push to influx( called again and again) (not step function can't came back)
- in flux db (measurement not table)

- retry (when connection error in database)
- track flow with id
- artifact for each branch (step name , then task id)



