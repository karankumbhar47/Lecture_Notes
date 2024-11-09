package com.compiler;

import com.compiler.CustomExceptions.SyntaxExceptions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JackAnalyzerTest {

    private static final Path RESOURCES_PATH = Paths.get("src/main/resources");
    private static final Path OUTPUT_BASE_PATH = Paths.get("out").toAbsolutePath();

    @BeforeEach
    void setUp() throws IOException {
        if (Files.exists(OUTPUT_BASE_PATH)) {
            Files.walk(OUTPUT_BASE_PATH)
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
        Files.createDirectories(OUTPUT_BASE_PATH);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.walk(OUTPUT_BASE_PATH)
                .map(Path::toFile)
                .forEach(File::delete);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "ArrayTest",
            "ExpressionLessSquare",
            "Square"
    })
    void testJackAnalyzerWithDirectories(String folderName) throws IOException, SyntaxExceptions {
        Path folder = RESOURCES_PATH.resolve(folderName);
        System.out.println("Testing directory: " + folder.getFileName());

        JackAnalyzer.main(new String[]{folder.toString(),OUTPUT_BASE_PATH.toString()});
        List<Path> expectedFiles = Files.walk(folder)
                .filter(path -> path.toString().endsWith(".jack"))
                .collect(Collectors.toList());

        for (Path expectedFile : expectedFiles) {
            Path generatedFile = OUTPUT_BASE_PATH.resolve(folder.getFileName() + "_Out").resolve(expectedFile.getFileName().toString().replace(".jack",".xml"));
            Path actualPath = folder.resolve(expectedFile.getFileName().toString().replace(".jack",".xml"));

            System.out.println(generatedFile.toAbsolutePath());
            assertTrue(Files.exists(generatedFile), "Generated file not found: " + generatedFile);

            String expectedContent = Files.readString(actualPath)
                    .replace("\r\n", "\n")
                    .replace("\r", "\n")
                    .replace("<symbol> < </symbol>", "<symbol> &lt; </symbol>")
                    .replace("<symbol> > </symbol>", "<symbol> &gt; </symbol>")
                    .replace("<symbol> & </symbol>", "<symbol> &amp; </symbol>");

            String generatedContent = Files.readString(generatedFile)
                    .replace("\r\n", "\n")
                    .replace("\r", "\n")
                    .replace("<symbol> < </symbol>", "<symbol> &lt; </symbol>")
                    .replace("<symbol> > </symbol>", "<symbol> &gt; </symbol>")
                    .replace("<symbol> & </symbol>", "<symbol> &amp; </symbol>");

            assertEquals(expectedContent, generatedContent, "Mismatch in contents for file: " + generatedFile);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ArrayTest/Main.jack",
            "ExpressionLessSquare/Main.jack",
            "ExpressionLessSquare/Square.jack",
            "ExpressionLessSquare/SquareGame.jack",
            "Square/Main.jack",
            "Square/Square.jack",
            "Square/SquareGame.jack",
    })

    void testJackAnalyzerWithFiles(String filePathString) throws IOException, SyntaxExceptions {
        Path filePath = RESOURCES_PATH.resolve(filePathString);
        String outputFileName = filePath.getFileName().toString().replace(".jack", ".xml");
        JackAnalyzer.main(new String[]{filePath.toAbsolutePath().toString(),OUTPUT_BASE_PATH.toString()});

        Path generatedFile = OUTPUT_BASE_PATH.resolve(outputFileName);
        Path expectedFile = RESOURCES_PATH.resolve(filePathString.split("/")[0]).resolve(outputFileName);

        assertTrue(Files.exists(generatedFile), "Generated file not found: " + generatedFile);

        String expectedContent = Files.readString(expectedFile)
                .replace("\r\n", "\n")
                .replace("\r", "\n")
                .replace("<symbol> < </symbol>", "<symbol> &lt; </symbol>")
                .replace("<symbol> > </symbol>", "<symbol> &gt; </symbol>")
                .replace("<symbol> & </symbol>", "<symbol> &amp; </symbol>");

        String generatedContent = Files.readString(generatedFile)
                .replace("\r\n", "\n")
                .replace("\r", "\n")
                .replace("<symbol> < </symbol>", "<symbol> &lt; </symbol>")
                .replace("<symbol> > </symbol>", "<symbol> &gt; </symbol>")
                .replace("<symbol> & </symbol>", "<symbol> &amp; </symbol>");

        assertEquals(expectedContent, generatedContent, "Mismatch in contents for file: " + generatedFile);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "ArrayTest/Main.jack",
            "ExpressionLessSquare/Main.jack",
            "ExpressionLessSquare/Square.jack",
            "ExpressionLessSquare/SquareGame.jack",
            "Square/Main.jack",
            "Square/Square.jack",
            "Square/SquareGame.jack",
    })

    void testJackAnalyzerTokensWithFiles(String filePathString) throws IOException, SyntaxExceptions {
        Path filePath = RESOURCES_PATH.resolve(filePathString);
        String outputFileName = filePath.getFileName().toString().replace(".jack", "T.xml");
        JackAnalyzer.main(new String[]{filePath.toAbsolutePath().toString(),OUTPUT_BASE_PATH.toString()});

        Path generatedFile = OUTPUT_BASE_PATH.resolve(outputFileName);
        Path expectedFile = RESOURCES_PATH.resolve(filePathString.split("/")[0]).resolve(outputFileName);

        assertTrue(Files.exists(generatedFile), "Generated file not found: " + generatedFile);

        String expectedContent = Files.readString(expectedFile)
                .replace("\r\n", "\n")
                .replace("\r", "\n")
                .replace("<symbol> < </symbol>", "<symbol> &lt; </symbol>")
                .replace("<symbol> > </symbol>", "<symbol> &gt; </symbol>")
                .replace("<symbol> & </symbol>", "<symbol> &amp; </symbol>");

        String generatedContent = Files.readString(generatedFile)
                .replace("\r\n", "\n")
                .replace("\r", "\n")
                .replace("<symbol> < </symbol>", "<symbol> &lt; </symbol>")
                .replace("<symbol> > </symbol>", "<symbol> &gt; </symbol>")
                .replace("<symbol> & </symbol>", "<symbol> &amp; </symbol>");

        assertEquals(expectedContent, generatedContent, "Mismatch in contents for file: " + generatedFile);
    }
}