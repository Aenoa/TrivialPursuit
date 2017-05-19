package classes;

import java.util.HashMap;

class Camembert 
{
    private HashMap<Category, Boolean> possedes = null;
    
    public Camembert()
    {
        this.possedes = new HashMap<>();
        for(Category c : Category.values())
        {
            this.possedes.put(c, Boolean.FALSE);
        }
    }
    
    public boolean gotCamembert(Category c)
    {
        return this.possedes.get(c);
    }
    
    public boolean switchCamembert(Category c)
    {
        return this.possedes.put(c, Boolean.TRUE);
    }
    
    public boolean estComplet()
    {
        return !this.possedes.values().contains(false);
    }
}
