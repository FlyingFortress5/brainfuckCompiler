import java.util.ArrayList;

public class Machine {
    ArrayList<Integer> memory = new ArrayList<>();
    int pointerPOS = 0;
    int codePointer = 0;
    int currentChar;
    String file;
    ArrayList<Character> code = new ArrayList<>();

    public Machine(){ 
        memory.add(0);

    }

    public void loadFile(String file) {
        String allowedChars = "<>-+.,[]";
        for(int i = 0; i<file.length(); i++){
            char inputChar = file.charAt(i);
            if (allowedChars.indexOf(inputChar) >= 0){
                code.add(inputChar);
            }

        }
    }

    public void run() {
        while (codePointer < code.size()){
            char inputChar = code.get(codePointer);
            Interpreter.BF(inputChar, this);
            codePointer++;
            currentChar = inputChar;
            System.out.println("Code Pointer: " + codePointer + " Memory Pointer: " + pointerPOS + " Memory Value: " + memoryRead());
        }
    }

    public void movePointer(int direction){
        if (direction == 1){
            pointerPOS++;
        } else if (direction == -1){
            pointerPOS--;
        }
        if (pointerPOS >= memory.size()) {
            memory.add(0);
        }
        if (pointerPOS < 0) {
            pointerPOS = 0;
            System.err.println("Pointer out of bounds");
        }

    }
    public void memoryIncrement(int amount){
        memory.set(pointerPOS, memory.get(pointerPOS) + amount);
        if (memory.get(pointerPOS) > 255) {
            memory.set(pointerPOS, 0);
        } else if (memory.get(pointerPOS) < 0) {
            memory.set(pointerPOS, 255);
        }
    }
    public int memoryRead(){
        return memory.get(pointerPOS);
    }

}
