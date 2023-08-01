package S6D2.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Workstation {

	private int id;
	private String city;
	private TypeOfWorkstation typeOfWorkstation;
	private int maxSeat;

//	private List<Reservation> listaPrenotazioni;

}
