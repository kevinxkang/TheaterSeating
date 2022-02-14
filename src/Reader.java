import Commands.Commands;
import Commands.reserve;
import Theater.Ticket;
import Theater.theater;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Reader {
  private HashMap<String, Commands> commands;
  final String filePath;
  private theater theater;

  public Reader(String filePath, theater t) {
    this.filePath = filePath;
    this.commands = new HashMap<String, Commands>();
    this.theater = t;
  }
  public void setCommand(String name, Commands command) {
    commands.put(name, command);
  }

  public void populateCommands() {
    setCommand("R", new reserve(this.theater));
  }
  public void read(){
    File file = new File(filePath);
    if (file.exists()) {
      try (Scanner input = new Scanner(file)) {
        while (input.hasNext()) {
          String[] splitString = input.nextLine().split(" ");
          String command = splitString[0].substring(0,1);
          if (commands.containsKey(command)) {
            commands.get(command).run(splitString);
          } else {
            System.err.println("ERROR: no such command found: " + command);
            return;
          }
        }
      } catch (IOException e) {
        System.err.println("ERROR: scanning input file");
      }
    }
    else {
      System.err.println("ERROR: input file does not exist");
      return;
    }
  }

  public void writeHelper(String name){
    ArrayList<String> x = new ArrayList<>();
    for (Ticket t : reserve.ticketList) {
      String y = t.getTicketNum()+" "+ helper(t.getSeat());
      x.add(y);
    }
    writeReserve(name, x);
  }

  public String helper(ArrayList<String> seats){
    String str = "";
    int len = seats.size();
    for (int i = 0; i < len;i++){
      str += seats.get(i);
      if (i != len-1){
        str += ",";
      }
    }
    return str;
  }

  public void writeReserve(String name, ArrayList<String> line) {
    try {
      Files.write(Paths.get("/Users/kevinkang/Desktop/cs_projects/Walmart/TheaterSeating/output/"+name),
              line, StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
