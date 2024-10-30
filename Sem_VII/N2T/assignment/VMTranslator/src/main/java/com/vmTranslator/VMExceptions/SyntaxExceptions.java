package com.vmTranslator.VMExceptions;

import com.vmTranslator.SuggestionUtils;

public class SyntaxExceptions extends Exception {
    private static String formatMessage(String message, int lineNumber, String currentLine) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error: ").append(message).append("\n");
        sb.append("Exception occurred at line number: ").append(lineNumber).append("\n");
        sb.append("Line content: ").append(currentLine != null ? "\"" + currentLine + "\"" : "N/A").append("\n");
        return sb.toString();
    }
    public SyntaxExceptions(String message,int lineNumber,String currentLine) {
        super(formatMessage(message,lineNumber,currentLine));
    }

    public static class InvalidCommandException extends SyntaxExceptions {
        public InvalidCommandException(String command,int lineNumber,String currentLine) {
            super("Invalid command: " + command+
                    "\n Do you mean \""+ SuggestionUtils.findClosestCommand(command,SuggestionUtils.commandList)
                    +"\" instead of \""+command+"\"",lineNumber,currentLine);
        }
    }


    public static class InvalidSegmentException extends SyntaxExceptions {
        public InvalidSegmentException(String segment,int lineNumber,String currentLine) {
            super("Invalid memory segment: " + segment+
            "\n Do you mean \""+ SuggestionUtils.findClosestCommand(segment,SuggestionUtils.segmentList)
                    +"\" instead of \""+segment+"\"",lineNumber,currentLine);
        }
    }


    public static class InvalidPushPopAddSegmentException extends SyntaxExceptions {
        public InvalidPushPopAddSegmentException(String segment,int lineNumber,String currentLine) {
            super("Searching for Segment among {local, argument, this, that} But found "+segment,lineNumber,currentLine);
        }
    }

    public static class InvalidPushPopSegmentException extends SyntaxExceptions {
        public InvalidPushPopSegmentException(String segment,int lineNumber,String currentLine) {
            super("Searching for Segment among {temp, static, pointer} But found "+segment,lineNumber,currentLine);
        }
    }

    public static class IndexOutOfBondException extends SyntaxExceptions {
        public IndexOutOfBondException(int index, int min, int max, int lineNumber,String currentLine) {
            super("Invalid index: " + index + ". Expected between " + min + " and " + max + "(Inclusive).",lineNumber,currentLine);
        }
    }

    public static class NegativeIndexException extends SyntaxExceptions {
        public NegativeIndexException(int lineNumber,String currentLine) {
            super("Index should not be negative",lineNumber,currentLine);
        }
    }

    public static class InstructionNotHandled extends SyntaxExceptions {
        public InstructionNotHandled(String instruction,int lineNumber,String currentLine) {
            super("Instruction Not handled" +instruction,lineNumber,currentLine);
        }
    }

    public static class MissingFirstArgumentException extends SyntaxExceptions {
        public MissingFirstArgumentException(String command,int lineNumber,String currentLine) {
            super("Missing First argument for command: " + command,lineNumber,currentLine);
        }
    }

    public static class MissingSecondArgumentException extends SyntaxExceptions {
        public MissingSecondArgumentException(String command,int lineNumber,String currentLine) {
            super("Missing Second argument for command: " + command,lineNumber,currentLine);
        }
    }

    public static class InvalidArithmeticCommandException extends SyntaxExceptions {
        public InvalidArithmeticCommandException(String command,int lineNumber,String currentLine) {
            super("Invalid arithmetic command: " + command,lineNumber,currentLine);
        }
    }

    public static class InvalidBinaryOperationException extends SyntaxExceptions {
        public InvalidBinaryOperationException(String operation,int lineNumber,String currentLine) {
            super("Searching for binary operators among {add,sub,and,or}, but found " + operation,lineNumber,currentLine);
        }
    }

    public static class InvalidCompOperationException extends SyntaxExceptions {
        public InvalidCompOperationException(String operation,int lineNumber,String currentLine) {
            super("Searching for Comparison operators among {gt, lt, eq} , but found "+operation,lineNumber,currentLine);
        }
    }

    public static class InvalidUnaryOperationException extends SyntaxExceptions {
        public InvalidUnaryOperationException(String operation,int lineNumber,String currentLine) {
            super("Searching for Unary operators among {not, neg}, but found "+operation,lineNumber,currentLine);
        }
    }

//    public static class InvalidFunctionCallException extends SyntaxExceptions {
//        public InvalidFunctionCallException(String command) {
//            super("Invalid function call format: " + command);
//        }
//    }
//
//    public static class UnexpectedEndOfFileException extends SyntaxExceptions {
//        public UnexpectedEndOfFileException() {
//            super("Unexpected end of file.");
//        }
//    }
//
//    public static class InvalidLabelNameException extends SyntaxExceptions {
//        public InvalidLabelNameException(String label) {
//            super("Invalid label name: " + label);
//        }
//    }
//
//    public static class ExcessiveArgumentsException extends SyntaxExceptions {
//        public ExcessiveArgumentsException(String command) {
//            super("Too many arguments for command: " + command);
//        }
//    }
//
//    public static class InvalidGotoCommandException extends SyntaxExceptions {
//        public InvalidGotoCommandException(String command) {
//            super("Invalid 'goto' command format: " + command);
//        }
//    }

    public static class NuLLCommandFoundException extends SyntaxExceptions {
        public NuLLCommandFoundException(int lineNumber,String currentLine) {
            super("No command found on current line.",lineNumber,currentLine);
        }
    }

}


