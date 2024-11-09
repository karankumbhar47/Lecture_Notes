# <Center>JackAnalyzer Project</Center>

### Project Overview

JackAnalyzer is a Java-based project that serves as a compiler front-end for the Jack programming language. It reads
`.jack` files, tokenizes them, and generates an XML file with a structured representation of the source code. This project
uses Java for implementation and Maven for build automation and dependency management. The JackAnalyzer processes `.jack`
files and outputs the corresponding `.xml` files in the specified output directory or, if unspecified, in the current
directory.

### Tools Used

- **Java** : The programming language used for implementation.
- **Maven** : For project management and build automation.
- **JUnit** : For unit testing.

### Installation

To install Maven on your system, use the following command:
```bash
sudo apt install maven
```

### Building the Project

To build and package the JackAnalyzer project, follow these steps:

1. **Ensure Maven is Installed**
 
   Verify that Maven is installed on your system by running:
    
   ```bash
   mvn -version
   ```
   
2. **Build the Project**

   In the root directory of the project, execute the following Maven command to compile the code and package it into a JAR file:
 
   ```bash
    mvn clean package
   ```

    This command will compile the project, run tests, and create a JAR file in the target directory.

### Running the Project Using the JAR Package

After building the project, you can run the JackAnalyzer tool using the generated JAR file. Here’s how:

1. **Navigate to the Target Directory**

    The JAR file is located in the target directory. Navigate to this directory:
   ```bash
   cd target
   ```

2. Run the JAR File

   Use the following command to run the JackAnalyzer tool, replacing <file-path> with the path to your .jack file or directory of .jack files:

   ```bash
    java -jar JackAnalyzer-1.0.jar <file-path> [output-path]
   ```

   **Parameters**:
   - `<file-path>` : Path to a single .jack file or a directory containing multiple .jack files.
   - `[output-path]` : Optional path to a directory where output files should be stored. If omitted, the output files are saved to the current directory.

   **Note**:
    1. Each .jack file in /src/main/resources/JackFiles/ is used for testing and verification. You can use these files to validate the generated XML files.
    2. XML output files are generated in the same directory as the input files if no output path is specified.
    3. Two files will be generated with filenames as follows
       - <fileName>.xml 
       - <fileName>T.xml

3. **Important Notes**
- For single .jack files, provide the file path. For an entire directory, ensure it only contains .jack files.
- The output files will have the same name as the .jack files but with the .xml extension.
- You can find test .jack files in the /src/main/resources/JackFiles/ directory, useful for verifying the generated XML files.
- All unit tests for functionality are located in the test directory and can be run as specified below.

### Running Test Cases Using Maven

To run the test cases for the project, use the Maven test command. This command will compile and execute all tests:

```bash
mvn test
```

### Using JackAnalyzer Without Maven

If you prefer not to use Maven, you can compile and run the project manually using a provided script. Ensure you are in the root directory of the project and follow these steps:

1. **Change Directory**
 
   Change the current directory to the root directory of the project.

2. **Ensure the Script is Executable**

    The root directory contains a script named `JackAnalyzer`. Change the script file permissions to make it executable:
   ```bash
   chmod +x JackAnalyzer
   ```

3. **Run the Script**

   Use the script to compile and run the JackAnalyzer tool:
   
   ```bash
    ./JackAnalyzer <file-path> [output-path]
   ```

   This command will compile the project and run the JackAnalyzer tool with the specified .jack file or directory as
   input and output the XML files accordingly.

