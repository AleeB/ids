package it.unicam.cs.ItalianWonder.controllers;

import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.mediator.ServiceMediator;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.classes.users.TuristaAutorizzato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class InitializerController {

  private final ServiceMediator serviceMediator;

  Turista turista1, turistaAutorizzato1, contributor1, contributorAutorizzato1, curatore1;

  public InitializerController(ServiceMediator serviceMediator) {
    this.serviceMediator = serviceMediator;
  }

  @RequestMapping(value = "/initialize", method = RequestMethod.POST)
  public ResponseEntity<String> initializeApp() {
    InitUtenti();
    return ResponseEntity.ok("Initializzato");
  }

  private void InitUtenti() {
    turista1 = new Turista();
    turista1.setNome("NomeTurista1");
    turista1.setCognome("CognomeTurista1");
    turista1.setPassword("");
    turista1.setPunteggio(0);
    turista1.setID_UserName("");
    turista1.setUserName("UsernameTurista1");
    turista1.setTipoUser(enumTipoUtente.Turista);

    turistaAutorizzato1 = new Turista();
    turistaAutorizzato1.setNome("NomeTuristaAutorizzato1");
    turistaAutorizzato1.setCognome("CognomeTuristaAutorizzato1");
    turistaAutorizzato1.setPassword("");
    turistaAutorizzato1.setPunteggio(0);
    turistaAutorizzato1.setID_UserName("UsernameTuristaAutorizzato1");
    turistaAutorizzato1.setTipoUser(enumTipoUtente.TuristaAutorizzato);

    contributor1 = new Turista();
    contributor1.setNome("NomeContributor1");
    contributor1.setCognome("CognomeContributor1");
    contributor1.setPassword("");
    contributor1.setPunteggio(0);
    contributor1.setID_UserName("UsernameContributor1");
    contributor1.setTipoUser(enumTipoUtente.Contributor);

    contributorAutorizzato1 = new Turista();
    contributorAutorizzato1.setNome("NomeContributorAutorizzato1");
    contributorAutorizzato1.setCognome("CognomeContributorAutorizzato1");
    contributorAutorizzato1.setPassword("");
    contributorAutorizzato1.setPunteggio(0);
    contributorAutorizzato1.setID_UserName("UsernameContributorAutorizzato1");
    contributorAutorizzato1.setTipoUser(enumTipoUtente.ContributorAutorizzato);

    curatore1 = new Turista();
    curatore1.setNome("NomeCuratore1");
    curatore1.setCognome("CognomeCuratore1");
    curatore1.setPassword("");
    curatore1.setPunteggio(0);
    curatore1.setID_UserName("UsernameCuratore1");
    curatore1.setTipoUser(enumTipoUtente.Curatore);

    serviceMediator.post(turista1);
    serviceMediator.post(turistaAutorizzato1);
    serviceMediator.post(contributor1);
    serviceMediator.post(contributorAutorizzato1);
    serviceMediator.post(curatore1);
  }
}
