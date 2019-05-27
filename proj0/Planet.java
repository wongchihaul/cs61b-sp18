import java.util.List;

public class Planet{
    public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
    public String imgFileName;
    
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName= p.imgFileName;
    }

    public double calcDistance(Planet q){
        double distance;
        distance = Math.sqrt((this.xxPos - q.xxPos)*(this.xxPos - q.xxPos) + (this.yyPos - q.yyPos)*(this.yyPos - q.yyPos));
        return distance;
    }

    public double calcForceExertedBy(Planet q){
        double force;
        force = 6.67 * Math.pow(10, -11) * this.mass * q.mass / Math.pow(calcDistance(q), 2);
        return force;
    }

    public double calcForceExertedByX(Planet q){
        double force_X, distance_X;
        distance_X = q.xxPos - this.xxPos;
        force_X = calcForceExertedBy(q) * distance_X / calcDistance(q);
        return force_X;
    }

    public double calcForceExertedByY(Planet q){
        double force_Y, distance_Y;
        distance_Y = q.yyPos - this.yyPos;
        force_Y = (calcForceExertedBy(q) * distance_Y / calcDistance(q);
        return force_Y;
    }

    public double calcNetForceExertedByX(Planet[] lst){
        double netforce_X = 0;
        for(int i = 0; i < lst.length; i++){
            if (this.equals(lst[i])){
                continue;
            }
            netforce_X += this.calcForceExertedByX(lst[i]);
        }
        return netforce_X;
    }

    public double calcNetForceExertedByY(Planet[] lst){
        double netforce_Y = 0;
        for(int i = 0; i < lst.length; i++){
            if (this.equals(lst[i])){
                continue;
            }
            netforce_Y += this.calcForceExertedByY(lst[i]);
        }
        return netforce_Y;
    }

    public void update(double dt, double fX, double fY) {
        double xxAcc = fX / this.mass;
        double yyAcc = fY / this.mass;
        this.xxVel += dt * xxAcc;
        this.yyVel += dt * yyAcc;
        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
      }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
    }
}