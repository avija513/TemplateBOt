public class Restaurant {
    private String foodPlaceName;
    private int typicalCost;
    private boolean hasVegetarianOption;
    private String menu;
    private int rating;
    private boolean spicy;
    private String website;
    private double miles; 
    public Restaurant(String f, int p, boolean v, String m, int r, boolean s, String w, double mi) {
        foodPlaceName = f;
        typicalCost = p;
        hasVegetarianOption = v;
        menu = m;
        rating = r;
        spicy = s;
        website = w; 
        miles = mi;

    }

    public String getFoodPlaceName() {
        return foodPlaceName;
    }

    public int getPrice() {
        return typicalCost;
    }

    public boolean gethasvegetarian() {
        return hasVegetarianOption;
    }

    public String getmenu() {
        return menu;
    }
    public int getRating(){
        return rating;
    }
    public boolean getSpicy(){
        return spicy;
    }

    public String getWebsite(){
        return website; 
    }
    public double getMiles(){
        return miles;
    }

    public String checkVeggieOptions() {
        if (hasVegetarianOption) {
            return ("This " + foodPlaceName + "has veggie options. Is there anything else you want to know?");
        } else {
            return "This " + foodPlaceName + " has no veggie options. Is there anything else you want to know?";
        }
    }

    public void setFoodPlaceName(String f) {
        foodPlaceName = f;
    }

    public void setTypicalCost(int p) {
        typicalCost = p;
    }

    public void setHasVegetarianOption(boolean veg) {
        hasVegetarianOption = veg;
    }

    public void setMenu(String m) {
        menu = m;
    }
    public void setWebsite(String w){
        website = w; 
    }
    public void setmiles(double distance){
        miles = distance;
    }
}
