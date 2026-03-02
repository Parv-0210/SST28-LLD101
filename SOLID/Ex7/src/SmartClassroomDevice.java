// Split into capability interfaces
interface PowerOn {
    void powerOn();
}
interface PowerOff {
    void powerOff();
}
interface Brightness {
    void setBrightness(int pct);
}
interface Temperature {
    void setTemperatureC(int c);
}
interface Attendance {
    int scanAttendance();
}
interface Input {
    void connectInput(String port);
}

