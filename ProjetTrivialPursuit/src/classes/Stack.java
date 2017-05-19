package classes;

import com.google.gson.Gson;
import exception.AucuneQuestionDefinieException;
import java.util.ArrayList;
import java.util.List;

import exception.QuestionDejaPresenteException;
import exception.QuestionInexistanteException;
import java.util.Random;

public final class Stack 
{
    private List<Question>Questions;

    public Stack()
    {
        Questions=new ArrayList<>();
        // on charge les questions depuis le fichier JSON
        this.chargerQuestions();
    }

    /**
     * Allows the user to add a question to the Stack
     * @param q the question to add
     * @return the status of the add
     * @throws QuestionDejaPresenteException if the question is already in the stack
     */
    public boolean addQuestion(Question q)throws QuestionDejaPresenteException
    {
        // On vérifie si aucune question identique n'es déjà dans la liste de questions
        if(!Questions.contains(q))
        {
            // on sauvegarde l'état de l'ajout de la question
            boolean ret = Questions.add(q);
            // Appel de la sauvegarde par sérialisation des questions
            this.sauvegarderQuestions();
            // renvoir de la valeur
            return ret;
        }
        else
        {
            // Si la question est déjà présent, on génère une exception
            throw new QuestionDejaPresenteException();
        }
    }

    /**
     * Allows the user to delete a question from the stack
     * @param q the question to remove
     * @return the status of the remove
     * @throws QuestionInexistanteException if the question isn't in the stack
     */
    public boolean deleteQuestion(Question q)throws QuestionInexistanteException
    {
        // Vérification que la question soit présente dans la stack
        if(Questions.contains(q))
        {
            // On stock le résultat de la suppression
            boolean ret = Questions.remove(q);
            // On met à jour le fichier JSON
            this.sauvegarderQuestions();
            // On renvoi la valeur de la suppression
            return ret;
        }
        else
        {
            // On signale que la question n'es pas dans la Stack
            throw new QuestionInexistanteException();
        }
    }

    /**
     * allows the user to modify a question by typing the question text, and remplacing it by a new question in arg
     * @param question the question (textual) to replace
     * @param q the Question to set as replacent of the old one
     * @return true if the change is fine
     * @throws QuestionInexistanteException if the question doesn't exist in stack
     */
    public boolean editQuestion(String question, Question q) throws QuestionInexistanteException
    {
        // On créer une question "bidon" pour la recherche
        Question old = new Question("recherche", Category.Economy, question);
        // On récupère son index dans la stack
        int index = this.Questions.indexOf(old);
        
        // Si elle n'existe pas dans la stack
        if(index == -1)
                throw new QuestionInexistanteException(); // On génère une exception

        // Sinon, on défini la question en argument comme nouvelle question pour l'index
        this.Questions.set(index, q);
        // on met à jour le fichier JSON
        this.sauvegarderQuestions();
        // on signale que tout s'est bien passé
        return true;
    }

    /**
     * Permet de charger les questions via le fichier questions.json vers la Stack
     */
    public void chargerQuestions()
    {
        // On créer un objet GSON
        Gson gs = new Gson();
        // On récupère le fichier sous format texte
        String listeQuestionsBrut = Serialisation.lireFichier("questions.json");
        // Si le fichier n'es pas null, cela veut dire que le fichier contient bien des questions
        if(listeQuestionsBrut != null)
        {
            // On sépare chaque ligne de JSON dans le fichier pour les mettre en tableau
            String[] listeQuestionsSplit = listeQuestionsBrut.split(System.lineSeparator());
            // On boucle sur chaque ligne présente
            for(String val : listeQuestionsSplit) 
            {
                // On recréer la question en objet via le JSON
                Question q = (Question) gs.fromJson(val, Question.class);
                // si la question n'es pas null et n'existe pas encore dans la stack
                if(q != null && ! this.Questions.contains(q))
                {
                    // on l'ajoute
                    this.Questions.add(q);
                }
            }
        }
    }

    /**
     * Permet de sauvegarder les questions de la stack dans un fichier nommé questions.json
     * @return the status of the writing on file
     */
    public boolean sauvegarderQuestions()
    {
        // On vérifie que la stack n'es pas null
        if(this.Questions != null)
        {
            // On créer une instance d'objet GSON
            Gson gs = new Gson();
            // On créer un string vierge
            String str = "";
            // On boucle pour chaque question
            for(Question j : this.Questions)
            {
                // on ajoute la question au format JSON dans le string, et on ajoute un retour a la ligne
                str += gs.toJson(j) + System.lineSeparator();
            }
            // On renvoir l'état de l'écriture
            return Serialisation.ecrireFichier("questions.json", str);
        }

        return false;
    }
    
    /**
     * allows the user to get a random question from the stack. 
     * !! DON'T FORGET TO DELETE IT FROM THE STACK ONCE THE USER GAVE A ANSWER !!
     * @return the question randomly selected
     * @throws AucuneQuestionDefinieException if there is no question in the stack
     */
    public Question getRandomQuestion() throws AucuneQuestionDefinieException
    {
        // si la stack contient une seule ou aucune question
        if(this.Questions.size() < 1)
        {
            // on génère une exception
            throw new AucuneQuestionDefinieException();
        }
        // on renvoi une question aléatoire
        return this.Questions.get(new Random().nextInt(this.Questions.size()));
    }
}
