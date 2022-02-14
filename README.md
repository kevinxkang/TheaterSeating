# TheaterSeating
README for Walmart 2022 SWE Internship take-home coding assessment.
##Intructions
1. Enter src folder with Main.java 
2. Run `javac Main.java`
3. Run `java Main <input file path> <output file name>`



##Assumptions
- Seats booked under one reservation would prefer to be seated in a contiguous format. Meaning that we opt not, ideally, to separate groups if not needed. 
- Customers, due to safety restrictions, do not hold a preference over seating location relative to the screen or row order.
- Individuals under one reservation do not hold a preference over how they are split between rows.
- There is no predetermined limit per reservation, baring they exceed the total number of seats.
- Individuals under one reservation need not operate under the single-row 3 seat buffer, but will have to follow the at least one row buffer.
- Reservations that are earlier numerically are given priority

##Potential Improvement
- Should customer satisfaction be impacted by seating location (relative to both screen and row ordering), update algorithm to reflect such.
- Program leaves room for addition commands beyond `R###`, for instance `C###` could be implemented as a command to remove reservations.


