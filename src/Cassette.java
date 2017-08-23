import java.util.*;

/**
 * 
 * @author Ahmad El-Ariss 1008651
 * @author Jean Emmanuel Charles 1065027
 * @author Wissam Akchich 0870592
 * @version 1.0
 * @since 12 Fevrier 2014
 
 */

public class Cassette {

	private int cass_Num;
	private static int[] numIndex;
	private static int[] temp;
	private String cass_Titre;
	private String cass_Realisat;
	private int[] cass_Emprunteur;
	private static int lastAssignedNumber = 0;
	private int[] NB_COPIES_MAX1 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

	/**
	 * Constructeur par paramètres dans lequel on fait appel aux setteurs pour
	 * initialiser quelques attributs de la classe Cassette.
	 * 
	 * @param Cass_Titre
	 * @param Cass_Realisat
	 */
	public Cassette(String Cass_Titre, String Cass_Realisat) {
		countCass_Num();
		cass_Titre = Cass_Titre;
		cass_Realisat = Cass_Realisat;
		cass_Emprunteur = new int[10];
		this.cass_Num = lastAssignedNumber;
		numIndex = new int[10];
		temp = new int[10];
	}

	/**
	 * @return le numero de la cassette.
	 */
	public int getCassNombre() {
		return this.cass_Num;
	}

	/**
	 * @return le numero de l'index.
	 */
	public int[] getIndex() {
		return numIndex;
	}

	/**
	 * @return le titre de la cassette.
	 */
	public String getTitre() {
		return this.cass_Titre;

	}

	/**
	 * @return le realisateur de la cassette.
	 */
	public String getRealisateur() {
		return this.cass_Realisat;
	}

	/**
	 * @param Nombre
	 *            modifie le numero de la cassette.
	 */
	public void setNumbre(int Nombre) {
		cass_Num = Nombre;
	}

	/**
	 * @param Titre
	 *            modifie le titre de la cassette.
	 */
	public void setTitre(String Titre) {
		this.cass_Titre = Titre;
	}

	/**
	 * @param Realisateur
	 *            modifie le realisateur de la cassette.
	 */
	public void setRealisateur(String Realisateur) {
		this.cass_Realisat = Realisateur;
	}
	
	/**
	 * @return le nombre de copies maximales d'une cassette.
	 */
	public int getNBcopies(Cassette[] cassette1) {
		return (cassette1[cass_Num - 1].NB_COPIES_MAX1[cass_Num - 1]);
	}
	
	/**
	 * Incrimante la valeur de lastAssignedNumber de 1.
	 */
	public static void countCass_Num() {
		lastAssignedNumber = lastAssignedNumber + 1;
	}

	/**
	 * Methode qui affiche la liste des cassettes disponibles.
	 * 
	 * @param cassette1
	 */
	public static void AfficherListe1(Cassette[] cassette1) {

		System.out.println("liste des cassettes disponibles: ");

		for (int i = 0; i < lastAssignedNumber; i++) {
			if (cassette1[i] != null)
				System.out
						.println("numero de la cassette  :"
								+ cassette1[i].getCassNombre()
								+ "  titre de la cassette  :"
								+ cassette1[i].getTitre());
		}
	}

	/**
	 * Methode qui affiche la liste des cassette en ordre alphabetique.
	 * 
	 * @param cassette1
	 */
	public static void AfficherListe(Cassette[] cassette1) {

		String[] v = new String[lastAssignedNumber];
		for (int i = 0; i < lastAssignedNumber; i++) {
			if (cassette1[i] != null)
				v[i] = cassette1[i].getTitre();
		}

		String[] v1 = new String[lastAssignedNumber];
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
	 * Methode qui ajoute une cassette dans le tableau cassette1.
	 * 
	 * @param Nom
	 * @param cassette1
	 * @param Cass_Realisateur
	 */
	public static void AjouterCassette(String Nom, Cassette[] cassette1,
			String Cass_Realisateur) {

		cassette1[lastAssignedNumber] = new Cassette(Nom, Cass_Realisateur);
	}

	/**
	 * Methode qui supprime une cassette.
	 * 
	 * @param cass_Num
	 * @param cassette1
	 */
	public static void supprimerCassette(int cass_Num, Cassette[] cassette1) {

		cassette1[cass_Num - 1] = null;

	}

	/**
	 * Methode qui modifie le Titre d'une casstte sans changer son numero.
	 * 
	 * @param Titre
	 * @param Num
	 * @param cassette1
	 */
	public static void modifierCassette(String Titre, int Num,
			Cassette[] cassette1) {
		cassette1[Num - 1].setTitre(Titre);

	}

	/**
	 * Methode qui imprime le titre de la cassette empruntée.
	 * 
	 * @param adh_Num
	 * @param cass_Num
	 * @param adeherent
	 * @param cassette1
	 */
	public static void emprunter(int adh_Num, int cass_Num,
			Adeherent[] adeherent, Cassette[] cassette1) {

		if (adeherent[adh_Num - 1] == null)
			System.out
					.println("l'adeherent n'existe pas .regarder bien la liste disponible");
		else if ((cassette1[cass_Num - 1].NB_COPIES_MAX1[cass_Num - 1]) == 0)
			System.out.print("Pas de copies suffisantes!");

		else {
			cassette1[cass_Num - 1].cass_Emprunteur[numIndex[cass_Num - 1]] = adh_Num;

			System.out.println(Arrays
					.toString(cassette1[cass_Num - 1].cass_Emprunteur));
			numIndex[cass_Num - 1]++;

			(cassette1[cass_Num - 1].NB_COPIES_MAX1[cass_Num - 1])--;
		}
	}

	/**
	 * Methode pour rendre une cassette, puis le nombre de copie de cette
	 * cassette est incrimanté de 1.
	 * 
	 * @param adh_Num
	 * @param cass_Num
	 * @param adeherent
	 * @param cassette1
	 */
	public static void RendreCassette(int adh_Num, int cass_Num,
			Adeherent[] adeherent, Cassette[] cassette1) {

		for (int i = 0; i < cassette1[cass_Num - 1].cass_Emprunteur.length; i++) {
			if (cassette1[cass_Num - 1].cass_Emprunteur[i] == adh_Num) {
				cassette1[cass_Num - 1].cass_Emprunteur[i] = 0;
			}
		}
		System.out.println(Arrays
				.toString(cassette1[cass_Num - 1].cass_Emprunteur));

		(cassette1[cass_Num - 1].NB_COPIES_MAX1[cass_Num - 1])++;
	}

	/**
	 * Methode qui imprime les personnes qui ont emprunté plusieurs cassettes.
	 * 
	 * @param cassette1
	 * @param adeherent
	 */
	public static void plusieurspersonnes(
			Cassette[] cassette1, Adeherent[] adeherent) {

		int[] Tab = new int[10];
		for (int i = 0; i < lastAssignedNumber; i++) {

			for (int j = 0; j < cassette1[i].cass_Emprunteur[j]; j++) {
				if (cassette1[i].cass_Emprunteur[j] != 0) {
					Tab[j] = cassette1[i].cass_Emprunteur[j];
				}
			}
			if (Tab[i] > 1)
				System.out.println(adeherent[Tab[i] - 1].getNom());
		}
	}

	/**
	 * Methode qui imprime le Titre de la cassette empruntée par plusieurs
	 * personnes.
	 * 
	 * @param adeherent
	 * @param cassette1
	 */
	public static void CassetteEmprunterparPlusieursAdeherents(
			Adeherent[] adeherent, Cassette[] cassette1) {

		int[] Tab = new int[10];
		for (int i = 0; i < lastAssignedNumber; i++) {

			for (int j = 0; j < cassette1[i].cass_Emprunteur[j]; j++) {
				if (cassette1[i].cass_Emprunteur[j] != 0) {
					Tab[j] = cassette1[i].cass_Emprunteur[j];
					temp[i] = temp[i] + 1;
				}
			}
			if (temp[i] > 1 && Tab[i] != 0) {
				System.out.println(cassette1[Tab[i] - 1].getTitre()
						+ " emprunter  " + temp[i] + " fois");

			}
		}
	}
}
