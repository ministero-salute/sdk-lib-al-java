package it.mds.sdk.aljavalib.service;

import it.mds.sdk.aljavalib.exception.AccessLayerException;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.gestoreesiti.modelli.ModalitaOperativa;
import it.mds.sdk.rest.persistence.entity.FlussoRequest;
import it.mds.sdk.rest.persistence.entity.RisultatoInizioValidazione;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;


@Disabled
public class FlussoServiceTest {

    private FlussoService flussoService;
    private String url = "http://localhost:8088";

    @BeforeEach
    void init() {
        flussoService = new FlussoService(url, HttpClient.newHttpClient(), "avn");
    }

    @Test
    void eseguiFlussoOK() throws AccessLayerException {
        FlussoRequest flussoRequest = new FlussoRequest();
        flussoRequest.setIdClient("11");
        flussoRequest.setAnnoRiferimento("2022");
        flussoRequest.setCodiceRegione("035");
        flussoRequest.setModalitaOperativa(ModalitaOperativa.P);
        flussoRequest.setPeriodoRiferimento("S1");
        flussoRequest.setNomeFile("AVN_NSM.csv");

        RisultatoInizioValidazione flussoRequestExp = new RisultatoInizioValidazione(true, "", "12", "11");

        RisultatoInizioValidazione flussoResActual = flussoService.eseguiFlusso(flussoRequest);

        Assertions.assertEquals(flussoRequestExp, flussoResActual);

    }

    @Test
    void eseguiFlussoErroreInputKO() {
        Assertions.fail();
    }

    @Test
    void eseguiFlussoDPMAPI1OK() {
        Assertions.fail();
    }

    @Test
    void eseguiFlussoDPMAPI2OK() {
        Assertions.fail();
    }

    @Test
    void eseguiFlussoDPMAPI3OK() {
        Assertions.fail();
    }
    @Test
    void getInfoRunGenericoOK() throws AccessLayerException {
        String idRun = "2";
        String idClient = "45";
        InfoRun infoRunExp = InfoRun.builder()
                .withIdRun("23")
                .withIdClient("45")
                .build();

        InfoRun infoRunActual = flussoService.getInfoRun(idRun, idClient);

        Assertions.assertEquals(infoRunExp, infoRunActual);
    }
}
