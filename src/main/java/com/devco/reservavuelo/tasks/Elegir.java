package com.devco.reservavuelo.tasks;


import com.devco.reservavuelo.ui.AviancaHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Elegir implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(AviancaHomePage.BOTON_SOLO_IDA));
  }

  public static Elegir SoloViajeDeIda() {
    return Tasks.instrumented(Elegir.class);
  }

}
