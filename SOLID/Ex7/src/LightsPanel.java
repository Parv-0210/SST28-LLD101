public class LightsPanel implements PowerOff, Brightness {
    @Override public void powerOff() { System.out.println("Lights OFF"); }
    @Override public void setBrightness(int pct) { System.out.println("Lights set to " + pct + "%"); }
}
