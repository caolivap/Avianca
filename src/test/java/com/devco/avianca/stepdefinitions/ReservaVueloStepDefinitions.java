package com.devco.avianca.stepdefinitions;

import com.devco.avianca.tasks.Abrir;
import com.devco.avianca.tasks.Consultar;
import com.devco.avianca.tasks.Elegir;
import com.devco.avianca.tasks.IngresarDatos;
import com.devco.avianca.ui.ResultadoViajesPage;
import com.devco.avianca.utils.UtilidadesFechas;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

public class ReservaVueloStepDefinitions {

  @Managed(driver = "chrome")
  private WebDriver suNavegador;
  private Actor carlos = Actor.named("Carlos");
  private ResultadoViajesPage resultadoViajesPage = new ResultadoViajesPage();

  @Before
  public void configuracionInicial() {
    carlos.can(BrowseTheWeb.with(suNavegador));
  }

  @Dado("^que (.*) se encuentra en la página inicial de la aerolínea Avianca$")
  public void queCarlosSeEncuentraEnLaPáginaInicialDeLaAerolíneaAvianca(String nombreActor) {
    carlos.wasAbleTo(Abrir.laPaginaDeAvianca());
  }

  @Cuando("^busca vuelos solo de ida desde (.*) hacia (.*) para dentro de (.*) días$")
  public void buscaVuelosDeIdaDesdeOrigenHaciaDestino(String ciudadOrigen, String ciudadDestino,
      int dias) throws ParseException {
    String fechaVuelo = UtilidadesFechas.obtenerFechaDeVuelo(dias);
    carlos.attemptsTo(
        Elegir.soloViajeDeIda(),
        IngresarDatos.deVuelo(ciudadOrigen, ciudadDestino, fechaVuelo),
        Consultar.vuelos());
  }

  @Entonces("^se obtienen los vuelos disponibles para esa fecha$")
  public void seObtienenLosVuelosDisponiblesParaEsaFecha() {
    MatcherAssert.assertThat("No se encontraron viajes para la fecha", !resultadoViajesPage.getLstViajes().isEmpty());
  }


}
