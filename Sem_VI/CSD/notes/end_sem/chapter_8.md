## Chapter 8

- Common architectural patterns for deploying models are discussed, including precomputing results (batch predictions)
  and real-time predictions via web services.
- Model operations are explored, covering retraining, continuous testing, and performance monitoring

## Model Prediction

- scale, change, integration, failure (not all project needed all strictly)
- ML_Ops --> model monitor /model hosting and serving/ feature store
- input response gap --> input known and prediction needed
- Processing
    1. batch processing --> Hadoop and Apache Spark  (15min) (all easy)
        - push to api (output)
    2. streaming processing -->kafka (30sec-15min)       -- (not easy to scale,monitor,development,processing)
        - push to api (output)
    3. realtime processing --> Apache Spark(<30sec) --
        - pull from api(user called this/invoke this prediction)

## Tech

- Kafka,flink (data sending to consumer)
- Fargate, Google App Engine --> model serving/hosting
- Amazon Sagemaker Hosting, Google AI Platform
  Ray Serve, Seldon --> model serving