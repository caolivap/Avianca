package com.devco.avianca.tasks;

import com.devco.avianca.ui.AviancaHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class Abrir implements Task{

  private AviancaHomePage aviancaHomePage;

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.browserOn(aviancaHomePage));
  }

  public static Abrir laPaginaDeAvianca() {
    return Tasks.instrumented(Abrir.class);
  }

}
