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

    public double dmulti(double op1,double op2){
        double res=op1;
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
        if (op1 <= 0) {
            throw new IllegalArgumentException("ln solo existe para números positivos");
        }

        double x = op1;
        int k = 0;

        // NORMALIZACIÓN: dividir entre 2 usando solo restas
        while (x > 2) {
            x = x - x / 2;  // x = x / 2
            k++;
        }

        // Ahora x está cerca de 1
        double y = x - 1;
        double resultado = 0.0;
        double termino = y;
        int n = 1;

        // Serie ln(1+y) con varios términos
        while (n <= 10) {
            if (n % 2 == 1) {
                resultado = resultado + termino / n;
            } else {
                resultado = resultado - termino / n;
            }
            termino = dmulti(termino, y);
            n++;
        }

        return resultado + (dmulti(k,0.693));
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
                itera--;
            }
        }

        if(resid>0){
            res=0;
            int contador10=0;
            while (contador10<10){
                res=res+resid;
                contador10++;
            }
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

    public double ddivi(double op1,double op2){
        double res=op1;
        int itera=1;
        int iteraRes=1;
        double resid=0.0;
        String sResult="";
        double dResult=0.0;

        while (res > op2) {
            res=res-op2;
            itera++; // Important: update the variable to avoid an infinite loop
            if(res<op2){
                resid=res;
                itera--;
            }
        }

        if(resid>0){
            res=0;
            int contador10=0;
            while (contador10<10){
                res=res+resid;
                contador10++;
            }
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

    public int modulo(int op1, int op2) {

        int res = op1;
        int residuo;

        while (res >= op2) {
            res = res - op2;
        }

        residuo = res;

        res = 0;
        int contador = 0;
        while (contador < 10) {
            res = res + residuo;
            contador++;
        }

        int decimal = 0;
        while (res >= op2) {
            res = res - op2;
            decimal++;
        }

        return decimal;
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

