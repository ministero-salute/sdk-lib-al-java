/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.aljavalib.module;

import it.mds.sdk.gestoreesiti.modelli.ModalitaOperativa;
import lombok.Data;

@Data
public class FlussoRequestDispoVig {

    ModalitaOperativa modalitaOperativa;
    String idClient;
    String nomeFile;
}
