/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.aljavalib.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.mds.sdk.gestoreesiti.modelli.Esito;
import lombok.Value;

import java.sql.Timestamp;
import java.util.List;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvioMdsResponse {

    protected String esito;
    protected EsitoServizioEnum esitoServizio;
    protected String descrizioneEsitoServizio;
    protected EsitoType tipoEsito;
    protected DettaglioType dettagli;
    protected List<Esito> esitiValidazione;
    protected String identificativoSoggettoAlimentante;
    protected Timestamp dataEmissioneRicevuta;

    @JsonCreator
    public InvioMdsResponse(
            @JsonProperty("esito") String esito,
            @JsonProperty("esitoServizio") EsitoServizioEnum esitoServizio,
            @JsonProperty("descrizioneEsitoServizio") String descrizioneEsitoServizio,
            @JsonProperty("tipoEsito") EsitoType tipoEsito,
            @JsonProperty("dettagli") DettaglioType dettagli,
            @JsonProperty("esitiValidazione") List<Esito> esitiValidazione,
            @JsonProperty("identificativoSoggettoAlimentante") String identificativoSoggettoAlimentante,
            @JsonProperty("dataEmissioneRicevuta") Timestamp dataEmissioneRicevuta) {
        this.esito = esito;
        this.esitoServizio = esitoServizio;
        this.descrizioneEsitoServizio = descrizioneEsitoServizio;
        this.tipoEsito = tipoEsito;
        this.dettagli = dettagli;
        this.esitiValidazione = esitiValidazione;
        this.identificativoSoggettoAlimentante = identificativoSoggettoAlimentante;
        this.dataEmissioneRicevuta = dataEmissioneRicevuta;
    }

    /*@Builder(setterPrefix = "with")
    public InvioMdsResponse(String esito, EsitoServizioEnum esitoServizio, String descrizioneEsitoServizio, EsitoType tipoEsito, DettaglioType dettagli, List<Esito> esitiValidazione, String identificativoSoggettoAlimentante, Timestamp dataEmissioneRicevuta) {
        this.esito = esito;
        this.esitoServizio = esitoServizio;
        this.descrizioneEsitoServizio = descrizioneEsitoServizio;
        this.tipoEsito = tipoEsito;
        this.dettagli = dettagli;
        this.esitiValidazione = esitiValidazione;
        this.identificativoSoggettoAlimentante = identificativoSoggettoAlimentante;
        this.dataEmissioneRicevuta = dataEmissioneRicevuta;
    }*/
}
