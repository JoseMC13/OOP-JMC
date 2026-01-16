package edu.jose.mejia.act_1.ui;

import edu.jose.mejia.act_1.process.Switch;

public class CLI {
    public static void start(){
        Switch switch_wifi=new Switch();
        System.out.println("Bienvenido al programa");
        System.out.println("El switch esta "+switch_wifi.isOn());
        if (switch_wifi.isOn()){
            System.out.println("desea apagar el switch");
        }
        else{
            System.out.println("desea prender el switch");
        }
        System.out.println("el switch esta "+switch_wifi.isOn());
    }
}
