package frc.robot;

public class MathUtil {

    public static int calcDirection(double currentAngle, double desiredAngle) {

        if (currentAngle == desiredAngle) {
            return 0;
        } else if ((Math.abs(currentAngle) + Math.abs(desiredAngle)) == 180) {
            return 0;
        }

        if ((currentAngle > 0 && desiredAngle > 0) || (currentAngle < 0 && desiredAngle < 0)) {
            double dist = desiredAngle - currentAngle;
            if (dist > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (currentAngle < 0) {
            double x = Math.abs(currentAngle) + desiredAngle;
            if (x > 180) {
                return -1;
            } else {
                return 1;
            }
        } else if (currentAngle > 0) {
            double x = currentAngle + Math.abs(desiredAngle);
            if (x > 180) {
                return 1;
            } else {
                return -1;
            }
        }

        throw new RuntimeException();
    }

}
