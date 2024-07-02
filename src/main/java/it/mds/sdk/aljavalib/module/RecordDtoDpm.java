/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.aljavalib.module;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvBindByPosition;
import it.mds.sdk.aljavalib.module.deserializer.CustomDeserializer;
import it.mds.sdk.libreriaregole.dtos.RecordDtoGenerico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDtoDpm extends RecordDtoGenerico {
    //dpm/donatoreMinorenne~dpm/tipoAtto~dpm/tipoDisponente~dpm/formatoAtto~dpm/donatore/luogoNascita/codiceNazione~dpm/donatore/luogoNascita/codiceRegione~dpm/donatore/luogoNascita/codiceProvincia~dpm/donatore/luogoNascita/codiceComune~dpm/donatore/luogoResidenza/codiceNazione~dpm/donatore/luogoResidenza/codiceRegione~dpm/donatore/luogoResidenza/codiceProvincia~dpm/donatore/luogoResidenza/codiceComune~dpm/donatore/nome~dpm/donatore/cognome~dpm/donatore/codiceFiscale~dpm/donatore/dataNascita~dpm/donatore/indirizzoResidenza~dpm/donatore/capResidenza~dpm/disponenti[1]/consensoEmail~dpm/disponenti[1]/luogoNascita/codiceNazione~dpm/disponenti[1]/luogoNascita/codiceRegione~dpm/disponenti[1]/luogoNascita/codiceProvincia~dpm/disponenti[1]/luogoNascita/codiceComune~dpm/disponenti[1]/luogoResidenza/codiceNazione~dpm/disponenti[1]/luogoResidenza/codiceRegione~dpm/disponenti[1]/luogoResidenza/codiceProvincia~dpm/disponenti[1]/luogoResidenza/codiceComune~dpm/disponenti[1]/nome~dpm/disponenti[1]/cognome~dpm/disponenti[1]/codiceFiscale~dpm/disponenti[1]/dataNascita~dpm/disponenti[1]/indirizzoResidenza~dpm/disponenti[1]/capResidenza~dpm/disponenti[1]/email~dpm/disponenti[2]/consensoEmail~dpm/disponenti[2]/luogoNascita/codiceNazione~dpm/disponenti[2]/luogoNascita/codiceRegione~dpm/disponenti[2]/luogoNascita/codiceProvincia~dpm/disponenti[2]/luogoNascita/codiceComune~dpm/disponenti[2]/luogoResidenza/codiceNazione~dpm/disponenti[2]/luogoResidenza/codiceRegione~dpm/disponenti[2]/luogoResidenza/codiceProvincia~dpm/disponenti[2]/luogoResidenza/codiceComune~dpm/disponenti[2]/nome~dpm/disponenti[2]/cognome~dpm/disponenti[2]/codiceFiscale~dpm/disponenti[2]/dataNascita~dpm/disponenti[2]/indirizzoResidenza~dpm/disponenti[2]/capResidenza~dpm/disponenti[2]/email~dpm/fiduciari[1]/consensoEmail~dpm/fiduciari[1]/luogoNascita/codiceNazione~dpm/fiduciari[1]/luogoNascita/codiceRegione~dpm/fiduciari[1]/luogoNascita/codiceProvincia~dpm/fiduciari[1]/luogoNascita/codiceComune~dpm/fiduciari[1]/luogoResidenza/codiceNazione~dpm/fiduciari[1]/luogoResidenza/codiceRegione~dpm/fiduciari[1]/luogoResidenza/codiceProvincia~dpm/fiduciari[1]/luogoResidenza/codiceComune~dpm/fiduciari[1]/nome~dpm/fiduciari[1]/cognome~dpm/fiduciari[1]/codiceFiscale~dpm/fiduciari[1]/dataNascita~dpm/fiduciari[1]/indirizzoResidenza~dpm/fiduciari[1]/capResidenza~dpm/fiduciari[1]/email~dpm/fiduciari[2]/consensoEmail~dpm/fiduciari[2]/luogoNascita/codiceNazione~dpm/fiduciari[2]/luogoNascita/codiceRegione~dpm/fiduciari[2]/luogoNascita/codiceProvincia~dpm/fiduciari[2]/luogoNascita/codiceComune~dpm/fiduciari[2]/luogoResidenza/codiceNazione~dpm/fiduciari[2]/luogoResidenza/codiceRegione~dpm/fiduciari[2]/luogoResidenza/codiceProvincia~dpm/fiduciari[2]/luogoResidenza/codiceComune~dpm/fiduciari[2]/nome~dpm/fiduciari[2]/cognome~dpm/fiduciari[2]/codiceFiscale~dpm/fiduciari[2]/dataNascita~dpm/fiduciari[2]/indirizzoResidenza~dpm/fiduciari[2]/capResidenza~dpm/fiduciari[2]/email~dpm/soggettoAlimentante/regioneSoggettoAlimentante~dpm/soggettoAlimentante/cap~dpm/soggettoAlimentante/codiceSoggettoAlimentante~dpm/soggettoAlimentante/indirizzo~dpm/idSoggettoAlimentante~dpm/dataSottoscrizione

    @CsvBindByPosition(position = 0)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreMinorenne;

    @CsvBindByPosition(position = 1)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String tipoAtto;

    @CsvBindByPosition(position = 2)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String tipoDisponente;

    @CsvBindByPosition(position = 3)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String formatoAtto;

    @CsvBindByPosition(position = 4)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoNascitaCodiceNazione;

    @CsvBindByPosition(position = 5)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoNascitaCodiceRegione;

    @CsvBindByPosition(position = 6)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoNascitaCodiceProvincia;

    @CsvBindByPosition(position = 7)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoNascitaCodiceComune;

    @CsvBindByPosition(position = 8)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoResidenzaCodiceNazione;

    @CsvBindByPosition(position = 9)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoResidenzaCodiceRegione;

    @CsvBindByPosition(position = 10)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoResidenzaCodiceProvincia;

    @CsvBindByPosition(position = 11)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreLuogoResidenzaCodiceComune;

    @CsvBindByPosition(position = 12)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreNome;

    @CsvBindByPosition(position = 13)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreCognome;

    @CsvBindByPosition(position = 14)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreCF;

    @CsvBindByPosition(position = 15)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreDataNascita;

    @CsvBindByPosition(position = 16)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreIndirizzoResidenza;

    @CsvBindByPosition(position = 17)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String donatoreCapResidenza;

    @CsvBindByPosition(position = 18)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1ConsensoEmail;

    @CsvBindByPosition(position = 19)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoNascitaCodiceNazione;

    @CsvBindByPosition(position = 20)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoNascitaCodiceRegione;

    @CsvBindByPosition(position = 21)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoNascitaCodiceProvincia;

    @CsvBindByPosition(position = 22)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoNascitaCodiceComune;

    @CsvBindByPosition(position = 23)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoResidenzaCodiceNazione;

    @CsvBindByPosition(position = 24)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoResidenzaCodiceRegione;

    @CsvBindByPosition(position = 25)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoResidenzaCodiceProvincia;

    @CsvBindByPosition(position = 26)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1LuogoResidenzaCodiceComune;

    @CsvBindByPosition(position = 27)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1Nome;

    @CsvBindByPosition(position = 28)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1Cognome;

    @CsvBindByPosition(position = 29)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1CF;

    @CsvBindByPosition(position = 30)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1DataNascita;

    @CsvBindByPosition(position = 31)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1IndirizzoResidenza;

    @CsvBindByPosition(position = 32)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1CapResidenza;

    @CsvBindByPosition(position = 33)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti1Email;

    @CsvBindByPosition(position = 34)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2ConsensoEmail;

    @CsvBindByPosition(position = 35)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoNascitaCodiceNazione;

    @CsvBindByPosition(position = 36)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoNascitaCodiceRegione;

    @CsvBindByPosition(position = 37)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoNascitaCodiceProvincia;

    @CsvBindByPosition(position = 38)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoNascitaCodiceComune;

    @CsvBindByPosition(position = 39)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoResidenzaCodiceNazione;

    @CsvBindByPosition(position = 40)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoResidenzaCodiceRegione;

    @CsvBindByPosition(position = 41)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoResidenzaCodiceProvincia;

    @CsvBindByPosition(position = 42)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2LuogoResidenzaCodiceComune;

    @CsvBindByPosition(position = 43)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2Nome;

    @CsvBindByPosition(position = 44)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2Cognome;

    @CsvBindByPosition(position = 45)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2CF;

    @CsvBindByPosition(position = 46)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2DataNascita;

    @CsvBindByPosition(position = 47)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2IndirizzoResidenza;

    @CsvBindByPosition(position = 48)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2CapResidenza;

    @CsvBindByPosition(position = 49)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String disponenti2Email;

    @CsvBindByPosition(position = 50)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1ConsensoEmail;

    @CsvBindByPosition(position = 51)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoNascitaCodiceNazione;

    @CsvBindByPosition(position = 52)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoNascitaCodiceRegione;

    @CsvBindByPosition(position = 53)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoNascitaCodiceProvincia;

    @CsvBindByPosition(position = 54)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoNascitaCodiceComune;

    @CsvBindByPosition(position = 55)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoResidenzaCodiceNazione;

    @CsvBindByPosition(position = 56)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoResidenzaCodiceRegione;

    @CsvBindByPosition(position = 57)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoResidenzaCodiceProvincia;

    @CsvBindByPosition(position = 58)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1LuogoResidenzaCodiceComune;

    @CsvBindByPosition(position = 59)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1Nome;

    @CsvBindByPosition(position = 60)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1Cognome;

    @CsvBindByPosition(position = 61)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1CF;

    @CsvBindByPosition(position = 62)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1DataNascita;

    @CsvBindByPosition(position = 63)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1IndirizzoResidenza;

    @CsvBindByPosition(position = 64)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1CapResidenza;

    @CsvBindByPosition(position = 65)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari1Email;

    @CsvBindByPosition(position = 66)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2ConsensoEmail;

    @CsvBindByPosition(position = 67)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoNascitaCodiceNazione;

    @CsvBindByPosition(position = 68)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoNascitaCodiceRegione;

    @CsvBindByPosition(position = 69)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoNascitaCodiceProvincia;

    @CsvBindByPosition(position = 70)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoNascitaCodiceComune;

    @CsvBindByPosition(position = 71)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoResidenzaCodiceNazione;

    @CsvBindByPosition(position = 72)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoResidenzaCodiceRegione;

    @CsvBindByPosition(position = 73)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoResidenzaCodiceProvincia;

    @CsvBindByPosition(position = 74)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2LuogoResidenzaCodiceComune;

    @CsvBindByPosition(position = 75)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2Nome;

    @CsvBindByPosition(position = 76)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2Cognome;

    @CsvBindByPosition(position = 77)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2CF;

    @CsvBindByPosition(position = 78)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2DataNascita;

    @CsvBindByPosition(position = 79)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2IndirizzoResidenza;

    @CsvBindByPosition(position = 80)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2CapResidenza;

    @CsvBindByPosition(position = 81)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String fiduciari2Email;

    @CsvBindByPosition(position = 82)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String soggettoAlimentanteRegioneSoggettoAlimentante;

    @CsvBindByPosition(position = 83)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String soggettoAlimentanteCap;

    @CsvBindByPosition(position = 84)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String soggettoAlimentanteCodiceSoggettoAlimentante;

    @CsvBindByPosition(position = 85)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String soggettoAlimentanteIndirizzo;

    @CsvBindByPosition(position = 86)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String idSoggettoAlimentante;

    @CsvBindByPosition(position = 87)
    @JsonDeserialize(using = CustomDeserializer.class)
    private String dataSottoscrizione;

}
