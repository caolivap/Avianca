package com.devco.avianca.tasks;

import com.devco.avianca.interactions.Cambiar;
import com.devco.avianca.ui.AviancaHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarDatos implements Task {

  private String ciudadOrigen;
  private String ciudadDestino;
  private String fechaVuelo;

  public IngresarDatos(String ciudadOrigen, String ciudadDestino, String fechaVuelo) {
    this.ciudadOrigen = ciudadOrigen;
    this.ciudadDestino = ciudadDestino;
    this.fechaVuelo = fechaVuelo;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(AviancaHomePage.CAMPO_CIUDAD_ORIGEN),
        Enter.theValue(ciudadOrigen).into(AviancaHomePage.CAMPO_CIUDAD_ORIGEN),
        Click.on(AviancaHomePage.BOTON_SUGERENCIA_CIUDAD.of(ciudadOrigen)),
        Click.on(AviancaHomePage.CAMPO_CIUDAD_DESTINO),
        Enter.theValue(ciudadDestino).into(AviancaHomePage.CAMPO_CIUDAD_DESTINO),
        Click.on(AviancaHomePage.BOTON_SUGERENCIA_CIUDAD.of(ciudadDestino)),
        Cambiar.frame(AviancaHomePage.XPATH_FRAME_PUBLICIDAD_MILES),
        Click.on(AviancaHomePage.CERRAR_AD_MILES),
        Cambiar.frame(),
        Click.on(AviancaHomePage.CAMPO_INGRESAR_FECHA),
        Click.on(AviancaHomePage.FECHA_CALENDARIO.of(fechaVuelo)));
  }

  public static IngresarDatos deVuelo(String ciudadOrigen, String ciudadDestino, String fechaVuelo) {
    return Tasks.instrumented(IngresarDatos.class, ciudadOrigen, ciudadDestino, fechaVuelo);
  }

}
