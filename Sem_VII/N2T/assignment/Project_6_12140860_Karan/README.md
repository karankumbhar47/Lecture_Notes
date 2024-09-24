# <center> HackAssembler Project </center>

## Project Overview

HackAssembler is a Java project which provides tool like Assembler for processing asm file and return corresponding hack file. This project uses
Java for its main logic implementation and Maven for build automation and dependency management. The HackAssembler tool
reads Hack assembly files, processes them, and generates corresponding Hack binary files in current directory.

### Tools Used

- **Java**: The programming language used for implementation.
- **Maven**: For project management and build automation.
- **JUnit**: For unit testing.

## Installation

To install Maven in your system use following command

```bash
sudo apt install maven
```

## Building the Project

To build and package the HackAssembler project, follow these steps:

1. **Ensure Maven is Installed**

   Make sure you have Maven installed on your system. You can check this by running:

   ```bash
   mvn -version
   ```

2. Build the Project

   In the root directory of the project, execute the following Maven command to compile the code and package it into a JAR
   file:

   ```bash
   mvn clean package
   ```

   This command will compile the project, run tests, and create a JAR file in the target directory.

## Running the Project Using the JAR Package

After building the project, you can run the HackAssembler tool using the generated JAR file. Here's how:

1. **Navigate to the Target Directory**

   The JAR file is located in the target directory. Navigate to this directory:

   ```bash
   cd target
   ```

2. Run the JAR File

   Use the following command to run the HackAssembler tool, replacing file.asm with the path to your Hack assembly file:

   ```bash
   java -jar HackAssembler-1.0.jar <file-path>
   ```

   This command will execute the HackAssembler tool with the specified assembly file as input.

   **Note**:

   1. `/src/main/resources/AsmFiles/` this directory contains all Asm files in `Nand to Tetris` project from
      project 1 to this project.
   2. `/src/main/resources/HackFiles/` this directory contains all Hack files corresponding ot each asm file in
      `AsmFiles/` directory. You can use this to cross-check generated hack file.

## Running Test Cases Using Maven

To run the test cases for the project, use the Maven test command. This command will compile the tests and execute them:

```bash
mvn test
```

## Using HackAssembler Without Maven

If you don't want to install Maven, you can compile and run the project manually using a provided script. Ensure you are in the root directory of the project and follow these steps:

1. **Change directory**

   change the current directory and navigate to the root directory of a project

2. **Ensure the Script is Executable**

   Root directory contains Script with name `HackAssembler`. Change the script file permissions to make it executable:

   ```bash
   chmod +x run-hackassembler.sh
   ```

3. **Run the Script**

   Use the script to compile and run the HackAssembler tool:

   ```bash
   ./Hackassembler.sh <File-Path>
   ```

   This command will compile the project and run the HackAssembler tool with the specified assembly file as input.

