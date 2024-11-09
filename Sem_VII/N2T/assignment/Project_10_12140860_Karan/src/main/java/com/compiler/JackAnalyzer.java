package com.compiler;

import com.compiler.CustomExceptions.SyntaxExceptions;
import com.compiler.Utils.TokenizerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class JackAnalyzer {
    public static void main(String[] args) throws IOException, SyntaxExceptions {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: JackAnalyzer <input> [output]");
            return;
        }

        Path inputPath = Paths.get(args[0]);
        Path outputPath;

        if (args.length == 2) {
            outputPath = Paths.get(args[1]).toAbsolutePath();
        } else {
            outputPath = Paths.get("").toAbsolutePath();
        }

        if (Files.isDirectory(inputPath)) {
            Path outputFolderPath = outputPath.resolve(inputPath.getFileName() + "_Out");
            Files.createDirectories(outputFolderPath);

            List<Path> jackFiles = Files.walk(inputPath)
                    .filter(path -> path.toString().endsWith(".jack"))
                    .collect(Collectors.toList());

            for (Path filePath : jackFiles) {
                processFile(filePath,outputFolderPath);
            }
        } else if (Files.isRegularFile(inputPath) && inputPath.toString().endsWith(".jack")) {
            processFile(inputPath,outputPath);
        } else {
            System.out.println("Invalid input. Provide a .jack file or a folder containing .jack files.");
        }
    }

    private static void processFile(Path filePath,Path outputFolderPath) throws IOException, SyntaxExceptions {
        String outputFileName = filePath.getFileName().toString().replace(".jack", ".xml");
        String outputTokenFileName = filePath.getFileName().toString().replace(".jack", "T.xml");
        Path outputFilePath = outputFolderPath.resolve(outputFileName);
        Path outputTokenFilePath = outputFolderPath.resolve(outputTokenFileName);

        TokenizerUtils.writeTokensToFile(new JackTokenizer(filePath),outputTokenFilePath);
        System.out.println("Processed Tokens " + filePath + " -> " + outputTokenFilePath);

        JackTokenizer tokenizer = new JackTokenizer(filePath);
        CompilationEngine engine = new CompilationEngine(outputFilePath, tokenizer);

        if(tokenizer.hasMoreTokens()) {
            tokenizer.advance();
            engine.compileClass();
            engine.closeFile();
        }
        else
            System.out.println("Empty file : "+filePath);

        System.out.println("Processed " + filePath + " -> " + outputFilePath);
    }
}
