import Theater.theater;

public class Main {
  private String[] args;
  private final String inputPath;
  private final String outputName;
  private Main(String[] args) {

    //System.out.println("enter input file path:");
    //Scanner user = new Scanner(System.in);
    //this.inputPath = user.next();
    //System.out.println("enter output file name:");
    //this.outputName = user.next();

    this.inputPath = args[0];
    this.outputName = args[1];

    //"/Users/kevinkang/Desktop/cs_projects/Walmart/TheaterSeating/input/input_test1.txt";
  }

  public static void main(String[] args) {
    //System.out.println(args[0]);
    //if (args.length != 2){
    //System.err.println("ERROR: incorrect number of arguments");
    //return;
    //}
    new Main(args).run();
  }

  public void run() {
    theater tenTwenty = new theater(10, 20);
    tenTwenty.populateSeats();
    Reader scanner = new Reader(this.inputPath, tenTwenty);
    scanner.populateCommands();
    scanner.read();
    scanner.writeHelper(outputName);
  }
}
