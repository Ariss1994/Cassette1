import java.util.Arrays;

/**
 * 
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author Wissam Akchich 0870592
 * @version 1.0
 * @since 12 Fevrier 2014
 * */
public class Adeherent {

	private int adh_Num;
	private String adh_Nom;
	private int adh_NbEmprunts;
	private static int adh_Num_temp = 0;

	/**
	 * Le construcetur par parametres dans lequel on fait appel aux setteurs
	 * pour initialiser quelques attributs de la classe Adeherent.
	 * 
	 * @param Nom
	 * 
	 */
	public Adeherent(String Nom) {
		countAdh_Num();
		this.adh_Num = adh_Num_temp;
		adh_Nom = Nom;

	}

	/**
	 * @return le numero de l'adeherent.
	 */
	public int getNombre() {
		return adh_Num;
	}

	/**
	 * @return le nom de l'adeherent.
	 */
	public String getNom() {
		return this.adh_Nom;
	}

	/**
	 * @return le nombre d'emprunts d'un adeherent.
	 */
	public int getNombredEmprunts() {
		return this.adh_NbEmprunts;
	}

	/**
	 * @param nombre
	 *            Modifie le nombre de l'adeherent.
	 */
	public void setNombre(int nombre) {
		adh_Num = nombre;
	}

	/**
	 * @param nom
	 *            Modifie le nom de l'adeherent.
	 */
	public void setNom(String nom) {
		adh_Nom = nom;
	}

	/**
	 * @param Emprunts
	 *            Modifie les Emprunts d'un adeherent.
	 */
	public void setEmprunts(int Emprunts) {
		this.adh_NbEmprunts = Emprunts;
	}
	
	/**
	 * Methode qui incrimente le adh_Num_temp de 1.
	 */
	public static void countAdh_Num() {
		adh_Num_temp = adh_Num_temp + 1;
	}

	/**
	 * Methode qui affiche la liste des adeherents.
	 * 
	 * @param adeherent
	 */
	public static void AfficherListe1(Adeherent[] adeherent) {
		System.out.println("liste des adherent disponible");
		for (int i = 0; i < adh_Num_temp; i++)
			if (adeherent[i] != null)
				System.out.println("numero d'aherent  :"
						+ adeherent[i].getNombre() + "  nom d'aherent  :"
						+ adeherent[i].getNom());
	}

	/**
	 * Methode qui affiche les adeherents par ordre alphabetique.
	 * 
	 * @param adeherent
	 */
	public static void AfficherListe(Adeherent[] adeherent) {

		String[] v = new String[adh_Num_temp];
		for (int i = 0; i < adh_Num_temp; i++) {
			if (adeherent[i] != null)
				v[i] = adeherent[i].getNom();
		}
		String[] v1 = new String[adh_Num_temp];
		for (int i = 0; i < v1.length; i++) {
			if (v[i] != null)
				v1[i] = v[i];
			else
				v1[i] = "";
		}
		Arrays.sort(v1);
		for (int i = 0; i < v1.length; i++) {
			if (v1[i]!= "")
				System.out.println(v1[i]);
		}
	}
	
	/**
	 * @param Nom
	 * @param adeherent
	 *            Methode qui ajoute un adeherent.
	 */
	public static void AjouterAdeherent(String Nom, Adeherent[] adeherent) {
		adeherent[adh_Num_temp] = new Adeherent(Nom);
	}

	/**
	 * Methode qui supprime un adeherent.
	 * 
	 * @param adh_Num
	 * @param adeherent
	 */
	public static void supprimerAdeherent(int adh_Num, Adeherent[] adeherent) {

		adeherent[adh_Num - 1] = null;
		
	}

	/**
	 * Methode qui modifie un adeherent sans supprimer son numero.
	 * 
	 * @param Nom
	 * @param Num
	 * @param adeherent
	 */
	public static void modifierAdeherent(String Nom, int Num, Adeherent[] adeherent) {
		adeherent[Num - 1].setNom(Nom);

	}	
}
