package cctech;


class Point
{
	int x,y;

	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Given outside Point is [x=" + x + ", y=" + y + "]";
	}

}


class CheckPolygon {
	

	public boolean isInsidePolygon(Point[] polygon, int n, Point p) {
		
	
		if(n<3)
			return false;
		
		Point extremeoutside=new Point(1000, p.y);
		
		int count=0,i=0;
		
		do
		{
			int next=(i+1)%n;
			if(intersection(polygon[i],polygon[next],p,extremeoutside))
				{
				if (direction(polygon[i], p, polygon[next]) == 0)
				{
					//System.out.println("direction is 0");
                return onLine(polygon[i], p, polygon[next]);
				}
				//System.out.println("count in if before increment"+count);
            count++;
            }
        i = next;
         } while (i != 0);
//System.out.println("count outside"+count);

if(count%2==0)
	return false;
else
	return true;
  

		}
		
		
	



	public  boolean intersection(Point x1, Point x2, Point z, Point outside) {
		
		
		
		   int d1 = direction(x1, x2, z);
		   int d2 = direction(x1, x2, outside);
		   int d3 = direction(z, outside, x1);
		   int d4 = direction(z, outside, x2);

		   if(d1 != d2 && d3 != d4)
		      return true;           
		   if(d1==0 && onLine(x1,x2, z))       
		      return true;
		   if(d2==0 && onLine(x1,x2, z))        
		      return true;
		   if(d3==0 && onLine(z,outside, x1))      
		      return true;
		   if(d4==0 && onLine(z,outside, x2)) 
		      return true;
		   return false;
	}



	public boolean onLine(Point p, Point r, Point q) {
		
		
		 if(r.x <= max(p.x, q.x) && r.x >= min(p.x, q.x) &&
			      (r.y <= max(p.y, q.y) && r.y >= min(p.y, q.y)))
		 {
			 
		// System.out.println("point is on line");
			         return true;
		 }

			   return false;
	}



	public int max(int x, int y) {
		
		if(x>y)
        return x;
		else
			return y;
	}
	public int min(int x, int y) {
		
		if(x<y)
        return x;
		else
			return y;
	}







	public int direction(Point p1, Point p2, Point r) {
		int val = (p2.y - p1.y) * (r.x - p2.x) - (p2.x - p1.x) * (r.y - p2.y);
		 if (val == 0)
	            return 0;
	        return (val > 0) ? 1 : 2;
	}
	
}
	
public class TestPolygon
{
public static void main(String args[])
{
    Point polygon[] = { new Point(10,20), new Point(20,30),
            new Point(30,60), new Point(60,40) ,new Point(40,10)};
    int n = polygon.length;
    
    Point p = new Point(10,20);
    CheckPolygon cp=new CheckPolygon();
    boolean result= cp.isInsidePolygon(polygon, n, p);
    if(result==true)
    {
    	System.out.println(p);
    	System.out.println("The point lies in polygon");
    }
    else
    {
    	System.out.println(p);
    	System.out.println("The point doesnot lies in polygon");
    }
}


}

	