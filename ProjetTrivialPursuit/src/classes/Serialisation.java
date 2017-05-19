package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serialisation 
{
    public static String lireFichier(String nomFichier)
    {
        BufferedReader br = null;
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        try 
        {
            fr = new FileReader(nomFichier);
            br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) 
            {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        catch (FileNotFoundException ex) 
        {
            System.err.println("Le fichier demandé ("+nomFichier+") n'existe pas.");
            return null;
        } 
        catch (IOException ex) 
        {
            System.err.println("Erreur de flux Entree/Sortie: \n"+ex.getMessage());
            return null;
        }
        finally
        {
            if(br != null)
            {
                try 
                {
                    br.close();
                } 
                catch (IOException ex) 
                {
                    System.err.println("Fermeture du flux impossible pour le BufferedReader (Serialisation.lireFichier): \n" + ex.getMessage());
                }
            }
            
            if(fr != null)
            {
                try
                {
                    fr.close();
                }
                catch(IOException ex)
                {
                    System.err.println("Fermeture du flux impossible pour le FileReader (Serialisation.lireFichier): \n" + ex.getMessage());
                }
            }
        }
        
        return sb.toString();
    }
    
    public static boolean ecrireFichier(String nomFichier, String data)
    {
        FileWriter      fichier     = null;
        try
        {
            fichier     = new FileWriter(nomFichier);
            fichier.write(data);
        }
        catch(IOException ex)
        {
            System.err.println("Impossible d'écrire dans le fichier texte: \n"+ex.getMessage());
            return false;
        }
        finally
        {
            if(fichier != null)
            {
                try 
                {
                    fichier.close();
                } 
                catch (IOException ex) 
                {
                    System.err.println("Impossible de fermer le flux de données: \n"+ ex.getMessage());
                    return false;
                }
            }
        }
        
        return true;
    }
}
