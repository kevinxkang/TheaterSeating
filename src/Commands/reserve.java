package Commands;

import Theater.Ticket;
import Theater.theater;

import java.util.ArrayList;
import java.util.HashSet;

public class reserve implements Commands {
  public static ArrayList<Ticket> ticketList = new ArrayList<>();
  int[][] layout;
  private Integer numRequest;
  private final theater theater;
  private int currRow = 0;
  private int currIndex = 0;
  private Ticket ticket;
  private int first = 0;
  private final HashSet<String> unique = new HashSet<>();


  public reserve(theater t) {
    this.theater = t;
    this.layout = theater.getSeating();
  }

  @Override
  public void run(String[] commands) {
    //check if command if valid
    if (commands.length != 2) {
      System.err.println("ERROR: command has incorrect amount of inputs");
    }
    String commandType = commands[0].substring(0, 1);
    String commandNum = commands[0].substring(1, 4);
    Integer commandQuantity = Integer.parseInt(commands[1]);
    if (commandQuantity <= 0) {
      System.err.println("ERROR: number of tickets must be greater than 0");
      return;
    }
    //System.out.println(theater.getNumCols());
    this.ticket = new Ticket(commands[0]);
    ticketList.add(ticket);
    if (unique.contains(ticket.getTicketNum())) {
      System.err.println("ERROR: reservations must be unique");
      return;
    }
    unique.add(ticket.getTicketNum());
    //System.out.println(commandQuantity);
    this.numRequest = commandQuantity;
    assignSeat(numRequest);
  }

  public void assignSeat(Integer numRequest) {
    if (this.currRow >= theater.getNumRows() - 1) {
      //System.err.println("ERROR: no more tickets");
      return;
    } else {
      if (currIndex + numRequest > theater.getNumCols() && first != 0) {
        currIndex = 0;
        currRow += 2;
      }
      while (numRequest != 0) {
        if (currRow == 10) {
          System.err.println("ERROR: no more tickets");
          return;
        }
        int[] cord = findSeat();
        if (cord[0] == -1) {
          System.err.println("ERROR: no more tickets");
          return;
        }
        String ticketSeat = getCharForNumber(cord[0] + 1) + currIndex;
        this.ticket.addSeat(ticketSeat);
        numRequest--;
      }
      if (currIndex + 3 < theater.getNumCols()) {
        this.currIndex += 3;
      } else {
        this.currIndex = 0;
        this.currRow += 2;
      }
      first = 1;
      System.out.println(this.ticket.getSeat().toString());
    }
  }

  public int[] findSeat() {
    int[] row = layout[currRow];
    //System.out.println(theater.getNumCols());
    int avalRow = findOpen(row);
    if (avalRow == -1) {
      return new int[]{-1};
    }
    //System.out.println(avalRow);
    int temp = avalRow;
    layout[currRow][temp] = 1;
    currIndex++;
    return new int[]{currRow, currIndex};
  }

  public int findOpen(int[] row) {
    if (this.currIndex == theater.getNumCols()) {
      this.currIndex = 0;
      if (this.currRow + 2 >= theater.getNumRows()-1) {
        return -1;
      } else {
        this.currRow += 2;
      }
    }

    for (int i = this.currIndex; i < row.length - 1; i++) {
      if (row[i] != 1) {
        return i;
      }
    }
    return 0;
  }

  public String getCharForNumber(int i) {
    return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
  }

}
