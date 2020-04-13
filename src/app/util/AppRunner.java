package app.util;

import java.util.Scanner;

/**
 * Bootstraps the code to select a data structure in a loop and run it
 * 
 * @author Prateek Singh
 */
public class AppRunner {
    public static void run() throws Exception {    
        try(Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.println("Select the Id of the data structure to run or press 0 to exit");
                for(DSInstances dsInstances : DSInstances.getList()) {
                    System.out.println(String.format("%d : %s", dsInstances.getId(), dsInstances.getName()));
                }
                int id = scanner.nextInt();
                if (id == 0) {
                    break;
                } else {
                    Class dsToInstantiate = DSInstances.getClass(id);
                    Runner run = (Runner) dsToInstantiate.newInstance();
                    run.run();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } 
    }
}