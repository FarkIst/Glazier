

public class Calculator {
        public enum FRAMETYPE {PVC, ALUMINIUM, WOOD};
	private double height;
	private double width;
        private double frameprice;
        private double glassprice;
	
	public Calculator(double height, double width, FRAMETYPE frametype) throws Exception  {
            this.height = height/100d;
            this.width = width/100d;
            DataAccessObject dao = new DataAccessObjectImpl();
            try {
                frameprice = dao.getFrameprice(frametype);
                glassprice = dao.getGlassprice();
            } catch (Exception ex) {
                System.out.println("Unable to retrieve frame price!");
                ex.printStackTrace();
              
                throw new Exception("Calculation exception:\n" + ex.getMessage() + "!");
            }
	}

	public double getGlassPrice(){
		return height * width * glassprice;
	}
	
	public double getFramePrice(){
		return (2 * height + 2 * width) * frameprice;
	}
	
	public double getTotalPrice(){
		return getGlassPrice() + getFramePrice();
	}
	
}
