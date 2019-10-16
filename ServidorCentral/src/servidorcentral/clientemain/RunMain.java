/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral.clientemain;

import servidorcentral.servicio.CentralServer;

public class RunMain {

    public static void main(String[] args) {
        CentralServer objServidor = new CentralServer();
        objServidor.iniciar();
    }
}
