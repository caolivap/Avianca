package com.devco.avianca.tasks;


import com.devco.avianca.ui.AviancaHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Elegir implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(AviancaHomePage.BOTON_SOLO_IDA));
  }

  public static Elegir soloViajeDeIda() {
    return Tasks.instrumented(Elegir.class);
  }

}
