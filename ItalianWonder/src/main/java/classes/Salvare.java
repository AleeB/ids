package classes;

import classes.POI.Divertimento;
import classes.POI.Itinerario;
import classes.POI.Ristorante;
import classes.users.Contributor;
import classes.users.ContributorAutorizzato;
import classes.users.TuristaAutorizzato;
import jakarta.persistence.*;

@Entity
@Table
public class Salvare {

    @Id


    @SequenceGenerator(
            name = "salvare_sequence",
            sequenceName = "salvare_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            generator = "salvare_sequence",
            strategy = GenerationType.SEQUENCE
    )

    //region Vars

    private int id;

    @ManyToOne
    @JoinColumn(name = "divertimento_id")
    private Divertimento divertimento;

    @ManyToOne
    @JoinColumn(name = "itinerario_id")
    private Itinerario itinerario;

    @ManyToOne
    @JoinColumn(name = "ristorante_id")
    private Ristorante ristorante;

    @ManyToOne
    @JoinColumn(name = "contributor_id")
    private Contributor contributor;

    @ManyToOne
    @JoinColumn(name = "contributorAutorizzato_id")
    private ContributorAutorizzato contributorAutorizzato;

    @ManyToOne
    @JoinColumn(name = "turistaAutorizzato_id")
    private TuristaAutorizzato turistaAutorizzato;

    //endregion

    //region Props

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Divertimento getDivertimento() {
        return divertimento;
    }

    public void setDivertimento(Divertimento divertimenti) {
        this.divertimento = divertimenti;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public ContributorAutorizzato getContributorAutorizzato() {
        return contributorAutorizzato;
    }

    public void setContributorAutorizzato(ContributorAutorizzato contributorAutorizzato) {
        this.contributorAutorizzato = contributorAutorizzato;
    }

    //endregion

    public Salvare() {
    }



}
