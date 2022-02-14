import Theater.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ticketTest {
  Ticket t1;
  Ticket t2;
  Ticket t3;
  ArrayList<String> seatList;

  @Before
  public void setup() {
    t1 = new Ticket("ROO1");
    t2 = new Ticket("ROO2");
    t3 = new Ticket("ROO3");
    t1.addSeat("A1");
    seatList = new ArrayList<>();
    seatList.add("A1");
  }

  @Test
  public void testTicket() {
    setup();
    assertEquals(t1.getTicketNum(), "ROO1");
    assertEquals(seatList, t1.getSeat());
    t1.addSeat("A2");
    seatList.add("A2");
    assertEquals(seatList, t1.getSeat());
  }
}
