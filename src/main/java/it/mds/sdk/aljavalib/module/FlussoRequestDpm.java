/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.aljavalib.module;

import it.mds.sdk.gestoreesiti.modelli.ModalitaOperativa;
import lombok.Data;

@Data
public class FlussoRequestDpm {

    ModalitaOperativa modalitaOperativa;
    String idClient;
    RecordDtoDpm recordDto;
}
