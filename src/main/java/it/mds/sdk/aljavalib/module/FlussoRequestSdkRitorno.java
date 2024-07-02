/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.aljavalib.module;

import lombok.Data;

import java.util.List;

@Data
public class FlussoRequestSdkRitorno {

    List<String> idsUpload;
    String nomeFlusso;
    String idClient;
}
