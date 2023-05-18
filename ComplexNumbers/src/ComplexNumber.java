public class ComplexNumber {

	public static final double EPSILON = 0.001;
	private double realPart;
	private double imaginaryPart;
	private double radius;
	private double argument;
	
	public ComplexNumber(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
		this.radius = getRadiusFromCartesian(realPart, imaginaryPart);
		this.argument = getArgumentFromCartesian(realPart, imaginaryPart);
	}
	
	public double getRealPart() {
		return this.realPart;
	}
	
	public double getImaginaryPart() {
		return this.imaginaryPart;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getArgument() {
		return this.argument;
	}
	
	public ComplexNumber plus(ComplexNumber other) {
		double sumRealPart = this.realPart + other.realPart;
		double sumImaginaryPart = this.imaginaryPart + other.imaginaryPart;
		return new ComplexNumber(sumRealPart, sumImaginaryPart);
	}
	
	public ComplexNumber minus(ComplexNumber other) {
		double differenceRealPart = this.realPart - other.realPart;
		double differenceImaginaryPart = this.imaginaryPart - other.imaginaryPart;
		return new ComplexNumber(differenceRealPart, differenceImaginaryPart);
	}
	
	public ComplexNumber times(ComplexNumber other) { 
		double productRadius = this.radius * other.radius;
		double productArgument = this.argument + other.argument;
		return fromPolarCoordinates(productRadius, productArgument);
	}
	
	public ComplexNumber divide(ComplexNumber other) {
		double divisionRadius = this.radius / other.radius;
		double divisionArgument = this.argument - other.argument;
		return fromPolarCoordinates(divisionRadius, divisionArgument);
	}
	
	public boolean almostEquals(ComplexNumber other) {
		return Math.abs(this.radius - other.radius) < EPSILON;
	}
	
	public static ComplexNumber fromPolarCoordinates(double radius, double argument) {
		double realPart = radius * Math.cos(argument);
		double imaginaryPart = radius * Math.sin(argument);
		return new ComplexNumber(realPart, imaginaryPart);
	}
	
	private static double getRadiusFromCartesian(double realPart, double imaginaryPart) {
		return Math.sqrt((realPart * realPart) + (imaginaryPart * imaginaryPart));
	}
	
	private static double getArgumentFromCartesian(double realPart, double imaginaryPart) {
		return Math.atan2(imaginaryPart, realPart);
	}
}
