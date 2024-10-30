# <Center>VMTranslator Project</Center>

### Project Overview

VMTranslator is a Java project that serves as a translator, converting VM code into corresponding assembly (ASM) files. 
This project uses Java for implementation and Maven for build automation and dependency management. 
The VMTranslator tool reads VM files, processes them, and generates the corresponding ASM files in the current directory.

### Tools Used

- **Java**: The programming language used for implementation.
- **Maven**: For project management and build automation.
- **JUnit**: For unit testing.

## Installation
To install Maven on your system, use the following command:
```bash
sudo apt install maven
```

## Building the Project

To build and package the VMTranslator project, follow these steps:

1. **Ensure Maven is Installed**

    Verify that Maven is installed on your system by running:

    ```bash
    mvn -version
    ```

2. Build the Project

    In the root directory of the project, execute the following Maven command to compile the code and package it into a JAR file:

    ```bash
    mvn clean package
   ```

    This command will compile the project, run tests, and create a JAR file in the target directory.
 
## Running the Project Using the JAR Package

After building the project, you can run the VMTranslator tool using the generated JAR file. Here's how:

1. **Navigate to the Target Directory**

    The JAR file is located in the target directory. Navigate to this directory:

    ```bash
    cd target
   ```

2. Run the JAR File

    Use the following command to run the VMTranslator tool, replacing <file-path> with the path to your VM file:

    ```bash
    java -jar VMTranslator-1.0.jar <file-path>
   ```

    This command will execute the VMTranslator tool with the specified VM file as input.

    **Note**:
    1. The `/src/main/resources/VMFiles/` directory contains all VM files used for testing and verification. You can use these files to validate the generated ASM files.
    2. Also `src/main/resources/VMFiles/` directory contains all test files corresponding to vm files; You can use it to verify the `asm` files
    3. The generated ASM files will be placed in the same directory as the input VM files.

## Running Test Cases Using Maven

To run the test cases for the project, use the Maven test command. This command will compile the tests and execute them:

```bash
mvn test
```

## Using VMTranslator Without Maven

If you prefer not to install Maven, you can compile and run the project manually using a provided script. Ensure you are in the root directory of the project and follow these steps:

1. **Change Directory**

    Change the current directory to the root directory of the project.

2. **Ensure the Script is Executable**

    The root directory contains a script named `VMTranslator`. Change the script file permissions to make it executable:

    ```bash
    chmod +x VMTranslator
    ```
   
3. **Run the Script**

    Use the script to compile and run the VMTranslator tool:

    ```bash
    ./VMTranslator <File-Path>
   ```

    This command will compile the project and run the VMTranslator tool with the specified VM file as input.