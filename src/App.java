import java.nio.file.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // Imports file

        Path input = Path.of(args[0]); 
        String file = Files.readString(input);


        
        Machine machine = new Machine();
        
        machine.loadFile(file);
        
        machine.run();




    }
}
