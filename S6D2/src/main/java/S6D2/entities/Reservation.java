package S6D2.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Reservation {

	private int id;
	private User User;
	private Workstation workstation;
	private LocalDate reservationDate;
}
