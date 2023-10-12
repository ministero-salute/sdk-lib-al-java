package it.mds.sdk.aljavalib.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.sql.Timestamp;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DpmVerificaStatoResponse {

    protected EsitoServizioEnum esitoServizio;
    protected String descrizioneEsitoServizio;
    protected String numeroAtto;
    protected String identificativoSoggettoAlimentante;
    protected EsitoType tipoEsito;
    protected DettaglioType dettagli;
    protected String idRun;
    protected Timestamp dataEmissioneRicevuta;

    @JsonCreator
    public DpmVerificaStatoResponse(
            @JsonProperty("esitoServizio") EsitoServizioEnum esitoServizio,
            @JsonProperty("descrizioneEsitoServizio") String descrizioneEsitoServizio,
            @JsonProperty("numeroAtto") String numeroAtto,
            @JsonProperty("identificativoSoggettoAlimentante") String identificativoSoggettoAlimentante,
            @JsonProperty("tipoEsito") EsitoType tipoEsito,
            @JsonProperty("dettagli") DettaglioType dettagli,
            @JsonProperty("idRun") String idRun,
            @JsonProperty("dataEmissioneRicevuta") Timestamp dataEmissioneRicevuta) {
        this.esitoServizio = esitoServizio;
        this.descrizioneEsitoServizio = descrizioneEsitoServizio;
        this.numeroAtto = numeroAtto;
        this.identificativoSoggettoAlimentante = identificativoSoggettoAlimentante;
        this.tipoEsito = tipoEsito;
        this.dettagli = dettagli;
        this.idRun = idRun;
        this.dataEmissioneRicevuta = dataEmissioneRicevuta;
    }

    /*@Builder(setterPrefix = "with")
    public DpmVerificaStatoResponse(EsitoServizioEnum esitoServizio, String descrizioneEsitoServizio, String numeroAtto, String identificativoSoggettoAlimentante, EsitoType tipoEsito, DettaglioType dettagli, String idRun, Timestamp dataEmissioneRicevuta) {
        this.esitoServizio = esitoServizio;
        this.descrizioneEsitoServizio = descrizioneEsitoServizio;
        this.numeroAtto = numeroAtto;
        this.identificativoSoggettoAlimentante = identificativoSoggettoAlimentante;
        this.tipoEsito = tipoEsito;
        this.dettagli = dettagli;
        this.idRun = idRun;
        this.dataEmissioneRicevuta = dataEmissioneRicevuta;
    }*/
}
