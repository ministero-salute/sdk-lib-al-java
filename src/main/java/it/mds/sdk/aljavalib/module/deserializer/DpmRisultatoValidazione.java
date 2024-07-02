/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.aljavalib.module.deserializer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.mds.sdk.gestoreesiti.modelli.EsitiValidazione;
import it.mds.sdk.rest.persistence.entity.RisultatoValidazione;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DpmRisultatoValidazione extends RisultatoValidazione {

    private String xmlOutputPath;

    @JsonCreator
    public DpmRisultatoValidazione(
            @JsonProperty("xmlOutputPath") String xmlOutputPath,
            @JsonProperty("isValidato") Boolean isValidato,
            @JsonProperty("esitiValidazione") EsitiValidazione esitiValidazione,
            @JsonProperty("idRun") String idRun,
            @JsonProperty("idClient") String idClient) {
        super(isValidato, esitiValidazione, idRun, idClient);
        this.xmlOutputPath = xmlOutputPath;
    }

    public DpmRisultatoValidazione(Boolean isValidato, EsitiValidazione esitiValidazione, String idRun, String idClient, String xmlOutputPath) {
        super(isValidato, esitiValidazione, idRun, idClient);
        this.xmlOutputPath = xmlOutputPath;
    }

    public DpmRisultatoValidazione(Boolean isValidato, EsitiValidazione esitiValidazione, String idRun, String idClient) {
        super(isValidato, esitiValidazione, idRun, idClient);
    }

    public void setXmlOutputPath(String xmlOutputPath) {
        this.xmlOutputPath = xmlOutputPath;
    }

    public String getXmlOutputPath() {
        return xmlOutputPath;
    }
}
