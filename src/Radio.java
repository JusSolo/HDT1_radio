public interface Radio {

        final int AM = 0;
        final int FM = 1;
        public void encender();

        public void apagar();

        public void setVolume(int i);

        public void cambiarBanda(int banda);

        public void subirEmisora();
        public  void bajarEmisora();

        public void guardarEmisora(int i, float frec);
        public void seleccionarEmisora(int i);
        public float getEmisora();
        public int getVolumen();
        public int getBanda();


}
