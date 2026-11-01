public class Interpreter {
    public static void BF(char input, Machine machine) {
        switch (input) {
            case '>':
                machine.movePointer(1);
                break;
            case '<':
                machine.movePointer(-1);
                break;
            case '+':
                machine.memoryIncrement(1);
                break;
            case '-':
                machine.memoryIncrement(-1);
                break;
            case '[':
                if (machine.memoryRead()  == 0) {
                    int loopDepth = 1;
                    while (loopDepth > 0) {
                        machine.movePointer(1);
                            if (machine.currentChar == '[') {
                                loopDepth++;
                            } else if (machine.currentChar == ']') {
                                loopDepth--;
                            }
                    }
                }
                break;
            case ']':
                if (machine.memoryRead() != 0) {
                    int loopDepth = 1;
                    while (loopDepth > 0) {
                        machine.codePointer--;
                        if (machine.currentChar == ']') {
                            loopDepth++;
                        } else if (machine.currentChar == '[') {
                            loopDepth--;
                        }
                    }
                }
                break;
        }

    }
    
}
