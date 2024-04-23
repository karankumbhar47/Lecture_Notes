-   Metaflow automatically persists all instance variables assigned to self in the step code.
-   These persisted instance variables are called artifacts.
-   Artifacts can include scalar variables, models, data frames, or any other Python object serializable with Python's pickle library.
-   Artifacts are stored in a common data repository called a datastore, managed by Metaflow.
-   Each step in Metaflow may produce any number of artifacts.
-   After completion, artifacts are stored as immutable units of data in the datastore, bound to the step that produced them.
-   This ensures an accurate and unmodifiable audit trail for experiment tracking.
-   Subsequent steps may read the artifact and produce their own version of it.

- Artifacts can be accessed programmatically using the Metaflow Client API, providing flexibility in working with data.


   -  Metaflow's datastore stores artifacts, which are serialized objects created by user code after task evaluation.
   -  Artifacts are stored in a content-addressed storage system similar to Git, with each artifact named using the hash of its contents.
   -  When a task creates new artifacts, they are serialized and stored in the datastore as immutable blobs.
   -  Metadata is updated to track the relationship between variables and artifacts, ensuring consistency and traceability.
   -  MetaSteps in a Metaflow workflow should serve as checkpoints where artifacts are persisted.flow automatically de-duplicates artifacts, optimizing disk space usage and simplifying artifact management.


   - Steps in a Metaflow workflow should serve as checkpoints where artifacts are persisted.


   NOTE
- Parameters are constant, immutable values. You can’t change them in your code. If you want to mutate a parameter, create a copy of the parameter value, and assign it to another artifact.
- export METAFLOW_RUN_CREATURE=dinosaur
- python json_parameter.py run --mapping '{"mykey": "myvalue"}'
- data = IncludeFile('csv',
help="CSV file to be parsed",
is_text=True)
delimiter = Parameter('delimiter',
help="delimiter",
default=',')    
-  python csv_file.py run --csv test.csv
- myfile = IncludeFile(
        'myfile',
        is_text=False,
        help='My input',
        default='/Users/bob/myinput.bin')

-Using branches not only improves performance but also enhances readability by highlighting data flow and step interdependencies.

- In Metaflow, a step that fans out branches is called a split step, while a step that fans in branches is called a join step.
- Every split step must have a corresponding join step to maintain a valid data flow structure.
- Split steps and join steps can be nested to any depth as needed.
- A join step can only join steps that have a common split parent.
- The presence of an equal number of splits and joins is not sufficient for validity; the steps must also adhere to the rule that a join step can only join steps with a common split parent
- join steps act as barriers in the data flow. You must explicitly merge all
artifacts except parameters to let data flow through downstream.    
