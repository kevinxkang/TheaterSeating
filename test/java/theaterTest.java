import Theater.theater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class theaterTest {
  @Test
  public void testTheater() {
    theater t = new theater(5, 10);
    t.populateSeats();
    assertEquals(t.getNumCols(), 10);
    assertEquals(t.getNumRows(), 5);
  }
}
