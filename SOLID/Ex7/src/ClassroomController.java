public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        PowerOn pj = reg.get(Projector.class);
        pj.powerOn();
        Input input = reg.get(Projector.class);
        input.connectInput("HDMI-1");

        Brightness lights = reg.get(LightsPanel.class);
        lights.setBrightness(60);

        Temperature ac = reg.get(AirConditioner.class);
        ac.setTemperatureC(24);

        Attendance scan = reg.get(AttendanceScanner.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.get(Projector.class).powerOff();
        reg.get(LightsPanel.class).powerOff();
        reg.get(AirConditioner.class).powerOff();
    }
}
