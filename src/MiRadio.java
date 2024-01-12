public class MiRadio implements Radio {
    public MiRadio() {
        this.encendido = true;
        this.banda = fm;
        this.frecuencia = 101.1f;
        this.vol = 50;
    }

    private boolean encendido;
    private boolean banda; //true => FM
    private boolean fm = true;
    private float frecuencia;
    private int vol;
    float emisoras[] = new float[12];


    /**
     *
     */
    @Override
    public void encender() {
        this.encendido = true;
    }

    /**
     *
     */
    @Override
    public void apagar() {
        this.encendido = false;
    }

    /**
     * @param i
     */
    @Override
    public void setVolume(int i) {
        this.vol = i %10;

    }

    /**
     * @param banda
     */
    @Override
    public void cambiarBanda(int banda) {
        if (banda == AM){
            this.banda = !fm;
            this.frecuencia = 101.1f;
        }
        else {
            this.banda = fm;
            this.frecuencia = 660f;
        }
    }

    /**
     *
     */
    @Override
    public void subirEmisora() {
        if (banda = fm){
            frecuencia += 0.2f;
        }
        else{
            frecuencia += 10f;
        }
    }

    /**
     *
     */
    @Override
    public void bajarEmisora() {
        if (banda = fm){
            frecuencia -= 0.2f;
        }
        else{
            frecuencia -= 10f;
        }
    }

    /**
     * @param i
     * @param frec
     */
    @Override
    public void guardarEmisora(int i, float frec) {
        i = i%12;
        emisoras[i] = frec;
    }

    /**
     * @param i
     */
    @Override
    public void seleccionarEmisora(int i) {
        this.frecuencia = emisoras[i];
        if (i < 107.9 ){
            this.banda = fm;
        }
        else{
            this.banda = !fm;
        }
    }


}
