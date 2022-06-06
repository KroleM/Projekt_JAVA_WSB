package program;

import java.util.concurrent.atomic.AtomicInteger;

public class Start {

	public static void main(String[] args) 
	{
		OknoGlowne okno = new OknoGlowne();
		AtomicInteger currentFiszka = new AtomicInteger();

		okno.addFiszkiNaukaButtonListener(e -> {
			OknoNauka on = new OknoNauka();
			on.wyswietlFiszke(OknoFiszki.paraSlow.get(0));
			on.addNextButtonListener( s-> {
				int i1 = currentFiszka.updateAndGet(i -> i == OknoFiszki.paraSlow.size() - 1 ? 0 : i + 1);
				on.wyswietlFiszke(OknoFiszki.paraSlow.get(i1));
			});

			on.addAddButtonListener( t -> {
				on.wyczyscPola();
			});

			on.addSaveButtonListener( u -> {
				ParaSlow ps = on.aktualnaFiszka();
				OknoFiszki.paraSlow.add(ps);
			});
		});


		//new RejestracjaiLogowanie();
	}

}
