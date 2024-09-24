
## Chapter 7: Data Preprocessing

- where to store data output and also input data(moniker==data warehouse)
- database (csv, postgres, multiple database(trino=query engine),cloud base database
 (apache flink==query engine, apache iceberg/ Hive==meta-data management,apache spark==data processing))
- dataset (structure(relational table),un-structure(images,text,semi-structure(schema/json))
- concerns(performance,data selection,feature engineering)
- helper libraries, feature store, batch processing
- data science --> simple query (lot of data) from data ware house

## S3
- local file(quick,no change,easy use) vs  (not in production, security, update manually)
- s3 (faster loading data)
  - increase performance, fast loading memory, special s3 client in meta-flow
- tabular data(csv,parquet(Apache Arrow), don't use python object) 
- parquet format (storage(binary),column base(storage type),column query)(more fast than panda, csv)
- metaflow.s3 --> pyArrow --> numpy,pandas --> ML libraries
- @memory_profile (memory peak of step(mem_usage)) 
- Integration with Existing Data Infrastructure:

- techniques for integrating data science workflows with existing data infrastructure, leveraging methods.
  I addresses both technical concerns, such as moving data, and organizational considerations, such as dividing work
  between data engineers, who focus on data infrastructure, and ML engineers and data scientists, who work on data
  science infrastructure.

## Modern dataset

1. data --> csv/parquet 
2. durable storage --> s3, postgres, data lake [data warehouse]
3. query engine --> Trino, Apache Spark , Apache Druid, Pinot  
4. extract and load data --> Snow flake / spark / DBT/ Great Expectation 
5. workflow orchestrator -->Apache( Airflow and flink ) [job scheduler] (metaflow step)
6. data management 
     - data catalogue --> Amundsen (organisation) [feature engineering],[versioning] (meta-flow artifact)
     - data governance
     - data monitor [model operation]

- data engineer (raw data --> ETL --> fact)
- data scientist (ETL(project specific --> project specific table--> workflow))

- data preprocessing --> 1] Processing Separate Subsets of Data
                         2] Efficient Data Preprocessing
- distributed data preprocessing
  (CTAS extract project specific data) split(into shards) --> mapper --> reduce
- facts (observation reality / data engineer) vs features (interpretation transformation/ data scientist)
- Feature encoding, or featurization, converts facts into features using individual feature encoding functions, or
  feature encoders.

## data to feature 
- raw data to suitable input

## Tech
- spark - sql search query
- feature store 
- parquet format --> Apache Arrow 
- Tera data, postgres --> data warehouse
- Trino, apache spark --> query engine
- Apache Druid, Pinot --> query engine(Streaming data)
- snowFlake and spark --> ETL(load --> transform)
- DBT --> express dataset and manage
- Great Expectation --> data quality
- Apache Airflow and Apache Flink --> workflow orchestrator(data)
- Amundsen --> data catalogue(data management)
- Amazon Athena --> search engine (Apache Hive format)