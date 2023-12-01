package frc.robot.subsystems;

public abstract class HolonomicDrivetrain extends Drivetrain {

    private double m_AdjustmentAngle = 0;
    private boolean m_FieldOriented = true;

    public HolonomicDrivetrain(double width, double length) {
        super(width, length);
    }

    public double getAdjustmentAngle() {
        return m_AdjustmentAngle;
    }

    public abstract double getGyroAngle();

    public abstract double getRawGyroAngle();

    public void holonomicDrive(double forward, double strafe, double rotation) {
		holonomicDrive(forward, strafe, rotation, isFieldOriented());
	}

	public abstract void holonomicDrive(double forward, double strafe, double rotation, boolean fieldOriented);

	public boolean isFieldOriented() {
		return m_FieldOriented;
	}

	public void setAdjustmentAngle(double adjustmentAngle) {
		System.out.printf("New Adjustment Angle: % .3f\n", adjustmentAngle);
		m_AdjustmentAngle = adjustmentAngle;
	}

	public void setFieldOriented(boolean fieldOriented) {
		m_FieldOriented = fieldOriented;
	}

	public abstract void stopDriveMotors();

	public void zeroGyro() {
		setAdjustmentAngle(getRawGyroAngle());
	}
    
}