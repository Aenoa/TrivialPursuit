package classes;


import com.google.gson.Gson;
import java.util.ArrayList;

public class Players 
{
    private static ArrayList<Joueur> plist;
    
    @Deprecated
    public static ArrayList<Joueur> getPlayerList()
    {
        if(Players.plist == null)
        {
            Players.chargerListeJoueurs();
        }
        return Players.plist;
    }
    
    /**
     * loads a players.json file filled with json data of Joueur
     */
    private static void chargerListeJoueurs()
    {
        // Setting the new arrayList
        Players.plist = new ArrayList<>();
        // on génère une instance d'objet GSON
	Gson gs = new Gson();
        // on récupère le string contenant les json
        String listeJoueursBrut = Serialisation.lireFichier("players.json");
	// si la string n'es pas null
        if(listeJoueursBrut != null)
        {
            // on le split
            String[] listeJoueursSplit = listeJoueursBrut.split(System.lineSeparator());
            // on parcours la liste
            for (String val : listeJoueursSplit) 
            {
                // on créer un nouveau joueur via le JSON
                Joueur j = (Joueur) gs.fromJson(val, Joueur.class);
                // on vérifie qu'il ne soit pas présent ET ne soit pas nul
                if(j != null && !Players.plist.contains(j))
                {
                    // on l'ajoute
                    Players.plist.add(j);
                }
            }
        }
    }
    
    /**
     * allows you to write into players.json the list of players
     * @return the status of writing
     */
    public static boolean sauvegarderJoueurs()
    {
        // on vérifie que la liste ne soit pas null
        if(Players.plist != null)
        {
            // on créer une instance GSON
            Gson gs = new Gson();
            // on fais un string vierge
            String str = "";
            // on parcours les joueurs présents
            for(Joueur j : Players.plist)
            {
                // on les ajoutent à la liste en format JSON
                    str += gs.toJson(j) + System.lineSeparator();
            }
            // on écris en fichier le string, et renvoi le résultat de l'écriture
            return Serialisation.ecrireFichier("players.json", str);
        }
        // list is empty or null, setting status to fail
        return false;
    }
    
    /**
     * allows you to check if the account/password combo of a player is valid
     * @param nom nom de compte du joueur
     * @param pass mot de pass du joueur
     * @return true if account is valid and authentic, false otherwise
     */
    public static boolean rechercherJoueur(String nom, String pass)
    {
        // si liste null, on charge
        if(Players.plist == null)
        {
            Players.chargerListeJoueurs();
        }
        // on fais un joueur bidon pour la recherche
        Joueur toSeek = new Joueur(nom, pass, "test@test.test", 0);
        // on cherche son index
        int indexOfPlayer = Players.plist.indexOf(toSeek);
        // si il existe dans la liste
        if(indexOfPlayer != -1)
        {
            // on récupère l'info du joueur en question trouvé
            toSeek = Players.plist.get(indexOfPlayer);
            // on vérifie que son mdp soit correct
            if(toSeek.getMdp().equals(pass))
            {
                // on renvoi que c'est bon
                return true;
            }
        }
        // on lui refuse car le mdp est incorrect ou joueur non présent dans liste
        return false;
    }
    
    /**
     * allows the user to add a player into the list
     * @param j the player to add
     * @return true if added successfuly, false otherwise
     */
    public static boolean ajouterJoueur(Joueur j)
    {
        // si la lsite est vide, on charge
    	if(Players.plist == null)
        {
            Players.chargerListeJoueurs();
        }
        // on vérifie qu'il n'existe pas dans la liste
        if(!Players.plist.contains(j))
        {
            // on récupère le résultat de l'ajout
            boolean ret = Players.plist.add(j);
            // on sauvegarde le tout en json dans un fichier
            Players.sauvegarderJoueurs();
            // on renvoi le résultat de l'ajout
            return ret;
    	}
        // on renvoi faux si quoi que ce soit s'est mal passé
	return false;
    }
    
    /**
     * allows the user to remove a player from the list
     * @param j the player to remove
     * @return true if it is removed successfully, false otherwise
     */
    public static boolean retirerJoueur(Joueur j)
    {
        // on vérifie que la liste ne soit pas null
        if(Players.plist == null)
        {
            Players.chargerListeJoueurs();
        }
        // le joueur est il présent dans la liste ?
        if(Players.plist.contains(j))
        {
            // oui, on stock la valeur de la suppression du joueur
                boolean ret = Players.plist.remove(j);
                // on met à jour le fichier
                Players.sauvegarderJoueurs();
                // on renvoi la valeur de la suppression
                return ret;
        }
        // on renvoi faux dans les autres cas
        return false;
    }
}