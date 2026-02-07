package edu.jose.mejia.act_2.calculadora_V2;

public class Calculo_V2 {

    public enum Operacion {

        SUMA(1, "suma"),
        RESTA(2, "resta"),
        MULTIPLICACION(3, "multiplicacion"),
        DIVISION(4, "division"),
        MODULO(5, "modulo"),
        POTENCIA(6, "potencia"),
        RAIZ(7, "raiz"),
        LOGARITMO(8, "logaritmo");

        private final int codigo;
        private final String nombre;

        Operacion(int codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public static Operacion fromCodigo(int codigo) {
            for (Operacion op : values()) {
                if (op.codigo == codigo) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Operación no válida");
        }
    }

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
        return Operacion.fromCodigo(opera).getNombre();
    }

    public abstract class Calculadora {

        public abstract int suma(int a, int b);
        public abstract int resta(int a, int b);
    }

    public abstract class CalculadoraBasica extends Calculadora {

        public abstract int multi(int a, int b);
        public abstract double divi(int a, int b);
        public abstract int modulo(int a, int b);
    }

    public abstract class CalculadoraAvanzada extends CalculadoraBasica {

        public abstract int potencia(int a, int b);
        public abstract int raiz(int a);
        public abstract double logar(int a);
    }

    public interface OperacionesBasicas {

        int suma(int a, int b);
        int resta(int a, int b);
    }

    public interface OperacionesAritmeticas {

        int multi(int a, int b);
        double divi(int a, int b);
        int modulo(int a, int b);
    }

    public interface OperacionesAvanzadas {

        int potencia(int a, int b);
        int raiz(int a);
        double logar(int a);
    }



    public class Calculo extends CalculadoraAvanzada {

        @Override
        public int suma(int op1, int op2) {
            return op1 + op2;
        }

        @Override
        public int resta(int op1, int op2) {
            return op1 - op2;
        }

        @Override
        public int multi(int op1, int op2) {
            int res = op1;
            for (int i = 1; i < op2; i++) {
                res += op1;
            }
            return res;
        }

        @Override
        public double divi(int op1, int op2) {
            return (double) op1 / op2;
        }

        @Override
        public int modulo(int op1, int op2) {
            return op1 % op2;
        }

        @Override
        public int potencia(int op1, int op2) {
            int res = op1;
            for (int i = 1; i < op2; i++) {
                res = multi(res, op1);
            }
            return res;
        }

        @Override
        public int raiz(int numero) {
            return (int) Math.sqrt(numero);
        }

        @Override
        public double logar(int op1) {
            return Math.log(op1);
        }
    }

    public class CalculoAvanzado extends Calculo {

        public double seno(double x){
            return Math.sin(x);
        }
    }

}
