/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.aljavalib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.mds.sdk.aljavalib.exception.AccessLayerException;
import it.mds.sdk.aljavalib.module.*;
import it.mds.sdk.aljavalib.module.deserializer.DpmRisultatoValidazione;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.rest.persistence.entity.FlussoRequest;
import it.mds.sdk.rest.persistence.entity.RisultatoInizioValidazione;
import it.mds.sdk.rest.persistence.entity.sdkritorno.RisultatoElaborazione;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class FlussoService {

    private final String url;
    private final HttpClient httpClient;
    private final String nomeFlusso;

    private final String FLUSSO_DPM = "donazionipostmortem";

    private final String SDK_RITORNO = "gestoreesitigaf";

    public FlussoService(String url, HttpClient httpClient, String nomeFlusso) {
        this.url = url;
        this.httpClient = httpClient;
        this.nomeFlusso = nomeFlusso;
    }

    public static FlussoService getInstanceDefaultHttpClient(String url, String nomeFlusso) {
        return new FlussoService(url, HttpClient.newHttpClient(), nomeFlusso);
    }

    public RisultatoInizioValidazione eseguiFlusso(FlussoRequest flussoRequest) throws AccessLayerException {
        String jsonReq = "{\n \"idClient\": \"IDCLIENT\",\n" +
                "\"nomeFile\": \"NOMEFILE\",\n" +
                "\"modalitaOperativa\": \"MODOPER\",\n" +
                "\"annoRiferimento\": \"ANNORIF\",\n" +
                "\"periodoRiferimento\": \"PERRIF\",\n" +
                "\"codiceRegione\": \"COD\"\n }";

        jsonReq = jsonReq.replace("IDCLIENT", flussoRequest.getIdClient())
                .replace("NOMEFILE", flussoRequest.getNomeFile())
                .replace("MODOPER", flussoRequest.getModalitaOperativa().name())
                .replace("ANNORIF", flussoRequest.getAnnoRiferimento())
                .replace("PERRIF", flussoRequest.getPeriodoRiferimento())
                .replace("COD", flussoRequest.getCodiceRegione());
        log.debug("Json da inviare come request {}", jsonReq);
        try {
            URI uriServizio = new URI(url + "/v1/flusso/" + nomeFlusso);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uriServizio)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonReq))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<InputStream> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            ObjectMapper om = new ObjectMapper();
            RisultatoInizioValidazione resOb = om.readValue(res.body(), RisultatoInizioValidazione.class);
            log.info("Risultato della request {} : {}", jsonReq, resOb);
            res.body().close();
            return resOb;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new AccessLayerException("Impossibile mandare la request " + flussoRequest, e);
        }
    }

    //Send Single Record
    public DpmRisultatoValidazione eseguiFlussoDPM(FlussoRequestDpm flussoRequestDpm) throws AccessLayerException, JsonProcessingException {

        ObjectMapper om = new ObjectMapper();

        log.debug("Json da inviare come request {}", flussoRequestDpm);
        try {
            URI uriServizio = new URI(url + "/v1/flusso/" + FLUSSO_DPM + "/record");
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uriServizio)
                    .POST(HttpRequest.BodyPublishers.ofString(om.writeValueAsString(flussoRequestDpm)))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<String> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            DpmRisultatoValidazione resOb = om.readValue(res.body(), DpmRisultatoValidazione.class);
            log.info("Risultato della request {} : {}", flussoRequestDpm, resOb);
            return resOb;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new AccessLayerException("Impossibile mandare la request " + flussoRequestDpm, e);
        }
    }

    public InfoRun getInfoRun(String idRun, String idClient) throws AccessLayerException {
        String urlServizio;
        if (idRun != null) {
            urlServizio = url + "/v1/flusso/" + nomeFlusso + "/info?idRun=" + idRun;
        } else if (idClient != null) {
            urlServizio = url + "/v1/flusso/" + nomeFlusso + "/info?idClient=" + idClient;
        } else {
            throw new IllegalArgumentException("idRun o idClient devono essere valorizzati");
        }
        try {
            log.debug("Viene mandata la request con url {}", urlServizio);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(urlServizio))
                    .GET()
                    .build();
            HttpResponse<InputStream> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            ObjectMapper om = new ObjectMapper();
            InfoRun infoRun = om.readValue(res.body(), InfoRun.class);
            log.info("Risposta alla request {} : {}", urlServizio, infoRun);
            res.body().close();
            return infoRun;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new AccessLayerException("Eccezione nel mandare la request per infoRun con idRun " + idRun + " e " +
                    "idClient " + idClient, e);
        }

    }

    // Invio File MDS
    public InvioMdsResponse api2(FlussoRequestDpmInvioFileMds flussoRequestDpmInvioFileMds) throws AccessLayerException {

        String jsonReq = "{\n \"idClient\": \"IDCLIENT\",\n" +
                "\"nomeFile\": \"NOMEFILE\"\n" +
                "}";

        jsonReq = jsonReq.replace("IDCLIENT", flussoRequestDpmInvioFileMds.getIdClient())
                .replace("NOMEFILE", flussoRequestDpmInvioFileMds.getNomeFile());
        ObjectMapper om = new ObjectMapper();

        try {
            System.out.println(om.readValue(jsonReq, FlussoRequestDpmInvioFileMds.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.debug("Json da inviare come request {}", jsonReq);
        try {
            URI uriServizio = new URI(url + "/v1/flusso/" + FLUSSO_DPM + "/record/invio");
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uriServizio)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonReq))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<InputStream> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

            InvioMdsResponse resOb = om.readValue(res.body(), InvioMdsResponse.class);
            log.info("Risultato della request {} : {}", jsonReq, resOb);
            return resOb;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new AccessLayerException("Impossibile mandare la request " + flussoRequestDpmInvioFileMds, e);
        }
    }

    public DpmVerificaStatoResponse getApi3(String identificativoSoggettoAlimentante, String regioneSoggettoAlimentante, String cap, String codiceSoggettoAlimentante, String indirizzo) throws AccessLayerException {
        String urlServizio;

        if (identificativoSoggettoAlimentante != null) {
            urlServizio = url + "/v1/flusso/" + FLUSSO_DPM + "/" + "stato" + "/" + identificativoSoggettoAlimentante + "?regioneSoggettoAlimentante=" + regioneSoggettoAlimentante
                    + "&cap=" + cap + "&codiceSoggettoAlimentante=" + codiceSoggettoAlimentante + "&indirizzo=" + URLEncoder.encode(indirizzo);
            System.out.println("urlServizio: " + urlServizio);
        } else {
            throw new IllegalArgumentException("identificativoSoggettoAlimentante deve essere valorizzato");
        }

        try {
            log.debug("Viene mandata la request con url {}", urlServizio);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(urlServizio))
                    .GET()
                    .build();
            HttpResponse<InputStream> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            ObjectMapper om = new ObjectMapper();
            DpmVerificaStatoResponse dpmVerificaStatoResponse = om.readValue(res.body(), DpmVerificaStatoResponse.class);
            log.info("Risposta alla request {} : {}", urlServizio, dpmVerificaStatoResponse);
            res.body().close();
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new AccessLayerException("Impossibile mandare la request per idSoggettoAlimentante = " + identificativoSoggettoAlimentante, e);
        }

    }

    public RisultatoElaborazione getStatoElaborazioniSdkRitorno(FlussoRequestSdkRitorno flussoRequestSdkRitorno) throws AccessLayerException {
        String urlServizio = url + "/v1/monitoraggio/" +SDK_RITORNO+"?idsUpload=" + URLEncoder.encode(String.join(",", flussoRequestSdkRitorno.getIdsUpload()))  +
                "&idClient=" + flussoRequestSdkRitorno.getIdClient() + "&nomeFlusso=" + flussoRequestSdkRitorno.getNomeFlusso();
        try {
            log.debug("Viene mandata la request con url {}", urlServizio);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(urlServizio))
                    .GET()
                    .build();
            HttpResponse<InputStream> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            ObjectMapper om = new ObjectMapper();
            RisultatoElaborazione sdkVerificaStatoResponse = om.readValue(res.body(), RisultatoElaborazione.class);
            log.info("Risposta alla request {} : {}", urlServizio, sdkVerificaStatoResponse);
            res.body().close();
            return null;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new AccessLayerException("Impossibile mandare la request ", e);
        }
    }

    public RisultatoInizioValidazione eseguiFlussoDispoVig(FlussoRequestDispoVig flussoRequest) throws AccessLayerException {
        String jsonReq = "{\n \"idClient\": \"IDCLIENT\",\n" +
                "\"nomeFile\": \"NOMEFILE\",\n" +
                "\"modalitaOperativa\": \"MODOPER\"\n }";

        jsonReq = jsonReq.replace("IDCLIENT", flussoRequest.getIdClient())
                .replace("NOMEFILE", flussoRequest.getNomeFile())
                .replace("MODOPER", flussoRequest.getModalitaOperativa().name());

        log.debug("Json da inviare come request {}", jsonReq);
        try {
            URI uriServizio = new URI(url + "/v1/flusso/" + nomeFlusso);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uriServizio)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonReq))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<InputStream> res = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            ObjectMapper om = new ObjectMapper();
            RisultatoInizioValidazione resOb = om.readValue(res.body(), RisultatoInizioValidazione.class);
            log.info("Risultato della request {} : {}", jsonReq, resOb);
            res.body().close();
            return resOb;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new AccessLayerException("Impossibile mandare la request " + flussoRequest, e);
        }
    }

}
