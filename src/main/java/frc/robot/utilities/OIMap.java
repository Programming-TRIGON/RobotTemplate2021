package frc.robot.utilities;

public enum OIMap {
    rightStick(1), leftStick(2), right1(3), right2(4), right3(5), left1(6), left2(7), left3(9), xButton(10),
    squareButton(11), triangleButton(12), circleButton(13), dPadUpButton(14), dPadRightButton(15), dPadDownButton(16),
    dPadLeftButton(17), touchPad(18), selectButton(19), startButton(20), playStationButton(21);

    private int port;

    private OIMap(int port) {
        this.port = port;
    }

    public int getPort() {
        return this.port;
    }
}
