package Theater;

import java.util.ArrayList;

public class Ticket {
  private ArrayList<String> seats;
  private String ticketNum;

  public Ticket(String ticketNum){
    this.ticketNum = ticketNum;
    this.seats = new ArrayList<>();
  }
  public String getTicketNum(){
    return this.ticketNum;
  }

  public  ArrayList<String> getSeat(){
    return this.seats;
  }

  public void setTicketNum(String ticketNum){
    this.ticketNum = ticketNum;
  }

  public void addSeat(String seat){
    this.seats.add(seat);
  }

  public void print(){
    System.out.println("Reservation Number: " + this.ticketNum);
  }
}
