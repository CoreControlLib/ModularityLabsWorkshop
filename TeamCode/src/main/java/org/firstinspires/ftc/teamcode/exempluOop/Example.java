package org.firstinspires.ftc.teamcode.exempluOop;

public class Example {
    Human eu = new Human();

    public void init() {
        eu.varsta = 20;
        eu.nume = "ion";
        eu.notaLaSport = 4.65;

        Integer sumaADouaNumere;

        eu.respira();
        eu.ziOGluma();
        eu.ziMiNumeleTau();
        sumaADouaNumere = eu.adunaDouaNumere(2, 4);
    }
}
