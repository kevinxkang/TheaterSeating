import Theater.theater;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //System.out.println(args[0]);
    new Main(args).run();
  }

  private String[] args;
  private String inputPath;
  private String outputName;
  private Main(String[] args) {
    //System.out.println("enter input file path:");
    //Scanner user = new Scanner(System.in);
    //this.inputPath = user.next();
    //System.out.println("enter output file name:");
    //this.outputName = user.next();

    this.inputPath = args[0];
    this.outputName = args[1];

    //this.path = "/Users/kevinkang/Desktop/cs_projects/Walmart/input/input_test1.txt";
  }
// /Users/kevinkang/Desktop/cs_projects/Walmart/tests/input_test1.txt
  public void run() {
    theater tenTwenty = new theater(10,20);
    tenTwenty.populateSeats();
    Reader scanner = new Reader(this.inputPath, tenTwenty);
    scanner.populateCommands();
    scanner.read();
    scanner.writeHelper(outputName);
  }
}
