import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MiRadioTest {

    @Test
    public void testGuardarEmisora() {
        MiRadio miRadio = new MiRadio();
        miRadio.encender();

        int indice = 1;
        float frecuencia = 95.5f;

        miRadio.guardarEmisora(indice, frecuencia);
        miRadio.seleccionarEmisora(indice);
        assertEquals(frecuencia, miRadio.getEmisora(), "La emisora no se guardó correctamente");
    }

    @Test
    public void testSubirEmisoraFM() {
        MiRadio miRadio = new MiRadio();
        miRadio.encender();
        miRadio.cambiarBanda(Radio.FM);

        float frecuenciaInicial = miRadio.getEmisora();

        miRadio.subirEmisora();

        float frecuenciaSubida = miRadio.getEmisora();

        assertTrue(frecuenciaSubida > frecuenciaInicial, "La frecuencia no se incrementó correctamente");
        assertEquals(frecuenciaInicial +0.2f, miRadio.getEmisora() );
    }

    @Test
    public void testSubirEmisoraAM() {
        MiRadio miRadio = new MiRadio();
        miRadio.encender();
        miRadio.cambiarBanda(Radio.AM);

        float frecuenciaInicial = miRadio.getEmisora();

        miRadio.subirEmisora();

        float frecuenciaSubida = miRadio.getEmisora();

        assertTrue(frecuenciaSubida > frecuenciaInicial, "La frecuencia no se incrementó correctamente");
        assertEquals(frecuenciaInicial + 10f, frecuenciaSubida);
    }

    @Test
    public void testSubirEmisoraApagada() {
        MiRadio miRadio = new MiRadio();
        miRadio.apagar();
        float frecuenciaInicial = miRadio.getEmisora();

        miRadio.subirEmisora();

        float frecuenciaDespuesSubirApagada = miRadio.getEmisora();

        assertEquals(frecuenciaInicial, frecuenciaDespuesSubirApagada, "La frecuencia no debería cambiar si la radio está apagada");
    }

    @Test
    public void testGetBanda() {
        MiRadio miRadio = new MiRadio();
        miRadio.encender();

        int bandaFM = 1;

        assertEquals(bandaFM, miRadio.getBanda(), "La banda no se obtuvo correctamente");
    }
}
