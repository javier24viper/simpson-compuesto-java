package dif_e_Integracion;

public class TrapecioCompuesto {

    // Función a integrar: f(x) (Ejemplo: f(x) = e^(x^2) o f(x) = 1 / (1 + x^2))
    public static double funcion(double x) {
        return Math.exp(-Math.pow(x, 2)); // Cambiar según la función vista en clase
    }

    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    public static double calcularTrapecio(double a, double b, int n) {
        double h = calcularH(a, b, n);
        double sumaIntermedios = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;
            sumaIntermedios += funcion(xk);
        }

        return (h / 2.0) * (funcion(a) + 2.0 * sumaIntermedios + funcion(b));
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0;
        int iteracion = 1;

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularTrapecio(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
            iteracion++;
        }

        System.out.printf("Trapecio Compuesto -> Iteraciones: %d | Subintervalos (n): %d | Resultado: %.8f\n", 
                          iteracion, n, integralAnterior);
        return integralAnterior;
    }
}