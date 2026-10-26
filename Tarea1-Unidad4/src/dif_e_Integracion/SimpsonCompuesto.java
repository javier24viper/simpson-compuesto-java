package dif_e_Integracion;

public class SimpsonCompuesto {

    private static double calcularSimpson(double a, double b, int n) {
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            
            // TODO COMPLETADO: Condición y acumulación para términos impares (x4) y pares (x2)
            if (k % 2 != 0) {
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        double sumaTotal = TrapecioCompuesto.funcion(a) 
                         + 4.0 * sumaImpares 
                         + 2.0 * sumaPares 
                         + TrapecioCompuesto.funcion(b);

        return (h / 3.0) * sumaTotal;
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;
        int iteracion = 1;

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularSimpson(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
            iteracion++;
        }

        System.out.printf("Simpson 1/3 Compuesto -> Iteraciones: %d | Subintervalos (n): %d | Resultado: %.8f\n", 
                          iteracion, n, integralAnterior);
        return integralAnterior;
    }
}