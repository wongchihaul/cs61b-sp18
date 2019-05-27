import java.util.Arrays;

public class NBody{

	public static double readRadius(String filename){
        In in = new In(filename);
		int num_of_planets = in.readInt();
		double radius = in.readDouble();
		return radius;
    }
    
    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num_of_planets = in.readInt();
        Planet[] res = new Planet[num_of_planets];
        double radius = in.readDouble();
        for(int i = 0; i < num_of_planets; i++){
            double x = in.readDouble();
            double y = in.readDouble();
            double v_X = in.readDouble();
            double v_Y = in.readDouble();
            double mass = in.readDouble();
            String image_of_planet = in.readString();
            res[i] = new Planet(x, y, v_X, v_Y, mass, image_of_planet);
        }
        return res;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] allPlanets = readPlanets(filename);
        Double radius = readRadius(filename);
        /* First,set the scale so that it matches the radius of the universe,
         Then draw the image starfield.jpg as the background.*/
        StdDraw.setScale(-2 * radius, 2 * radius);
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for (int i = 0; i < allPlanets.length; i++){
            allPlanets[i].draw();
        }

        for(double t = 0; t <= T; t += dt) {
        	double[] xForces = new double [allPlanets.length];
        	double[] yForces = new double [allPlanets.length];
        	for(int i = 0; i < allPlanets.length; i++) {
        		xForces [i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
        		yForces [i] = allPlanets[i].calcNetForceExertedByY(allPlanets);  
        	}
        	for(int i = 0; i < allPlanets.length; i++) {
        	  allPlanets[i].update(dt, xForces [i], yForces [i]);
        	}
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (Planet p : allPlanets) {
        	  p.draw();
            }
            StdDraw.show(10);
        }
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n",radius);
        for (Planet p : allPlanets) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
        }
}
}