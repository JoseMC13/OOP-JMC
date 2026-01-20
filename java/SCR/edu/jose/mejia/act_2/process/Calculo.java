package edu.jose.mejia.act_2.process;

public class Calculo {

    public int suma(int op1,int op2){
        int res=0;

        res=op1+op2;
        return res;
    }
    public int resta(int op1,int op2){
        int res=0;

        res=op1-op2;
        return res;
    }
    public int multi(int op1,int op2){
        int res=op1;
        for (int i = 1; i < op2; i++) {
            res=res+op1;
        }

        return res;
    }

    public int potencia(int op1,int op2){
        int res=op1;

        for (int i = 1; i < op2; i++) {
            res = multi(res,op1);
        }

        return res;
    }

    public int raiz(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        int contador = 0; // Contará cuántas restas se han hecho (la raíz)
        int resto = numero; // El número al que le vamos restando
        int impar = 1; // El número impar que restamos

        while (resto >= impar) {
            resto = resto - impar; // Restamos el número impar
            contador++;            // Incrementamos el contador (la raíz)
            impar = impar + 2;     // Pasamos al siguiente número impar
        }
        // 'contador' es la raíz entera, 'resto' es el residuo
        System.out.println("Raíz (entera): " + contador + ", Residuo: " + resto);
        return contador;
    }

    public double logar(int op1){
        double num = op1;
        double logNatural = Math.log(num); // Calcula ln(10)

        return logNatural;
    }

    public double divi(int op1,int op2){
        int res=op1;
        int itera=1;
        int iteraRes=1;
        int resid=0;
        String sResult="";
        double dResult=0.0;

        while (res > op2) {
            res=res-op2;
            itera++; // Important: update the variable to avoid an infinite loop
            if(res<op2){
                resid=res;
                itera--;}
        }

        if(resid>0){
            res=resid*10;
            while (res > op2) {
                res=res-op2;
                iteraRes++; // Important: update the variable to avoid an infinite loop
                if(res<op2){
                    resid=res;
                    iteraRes--;}
            }
        }else{iteraRes--;}
        sResult= itera + "." + iteraRes;

        if(iteraRes>0){
            return Double.parseDouble(sResult);
        }
        else {return itera;}

    }

    public int modulo(int op1,int op2){
        int res=op1;
        int itera=1;
        int iteraRes=1;
        int resid=0;
        String sResult="";
        double dResult=0.0;

        while (res > op2) {
            res=res-op2;
            itera++; // Important: update the variable to avoid an infinite loop
            if(res<op2){
                resid=res;
                itera--;}
        }

        if(resid>0){
            res=resid*10;
            while (res > op2) {
                res=res-op2;
                iteraRes++; // Important: update the variable to avoid an infinite loop
                if(res<op2){
                    resid=res;
                    iteraRes--;}
            }
        }else{iteraRes--;}
        sResult= itera + "." + iteraRes;

        return iteraRes;
    }

    public String getopera(int opera){
        String res="";
        int sumRes = 0;

        switch (opera) {
            case 1:
                return "suma";
            case 2:
                return "resta";
            case 3:
                return "multiplicacion";
            case 4:
                return "division";
            case 5:
                return "modulo";
            case 6:
                return "potencia";
            case 7:
                return "raiz";
            case 8:
                return "logaritmo";
        }
        return res;
    }
}

