// Split into capability interfaces
public interface PowerOn {
    void powerOn();
}
public interface PowerOff {
    void powerOff();
}
public interface Brightness {
    void setBrightness(int pct);
}
public interface Temperature {
    void setTemperatureC(int c);
}
public interface Attendance {
    int scanAttendance();
}
public interface Input {
    void connectInput(String port);
}

